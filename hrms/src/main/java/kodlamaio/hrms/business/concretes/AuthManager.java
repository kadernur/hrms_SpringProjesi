package kodlamaio.hrms.business.concretes;



import java.time.LocalDate;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;


import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verification.VerificationService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import kodlamaio.hrms.entities.dtos.RegisterForCandidateDto;
import kodlamaio.hrms.entities.dtos.RegisterForEmployerDto;

@Service("AuthManager")
public class AuthManager implements AuthService {

	private CandidateService candidateService;
	private EmployerService employerService;
	private VerificationCodeService codeService;
	private VerificationService verificationService;
	
	private ModelMapper modelMapper;

	@Autowired
	public AuthManager(ModelMapper modelMapper,CandidateService candidateService, EmployerService employerService, VerificationCodeService codeService, VerificationService verificationService) {

		this.modelMapper = modelMapper;
		
		this.candidateService = candidateService;

		this.employerService = employerService;
		
		this.codeService= codeService;
		
		this.verificationService = verificationService;

	}

	@Override
	public Result registerEmployer(RegisterForEmployerDto registerForEmployerDto) {
        
       if(!checkIfEqualPasswordAndConfirmPassword(registerForEmployerDto.getPassword(),registerForEmployerDto.getConfirmPassword())) {
			
			return new ErrorResult("Passwords do not match !");
		}
		
       Employer employer = modelMapper.map(registerForEmployerDto, Employer.class);
       
		var result = this.employerService.add(employer);
		
		System.out.println(result);
         if(result.isSuccess()) {
        	 this.generateVerificationCode(employer.getId());

           }
          return new ErrorResult("something's gone wrong... Please try again.");
	
	}

	@Override
	public Result registerCandidate(RegisterForCandidateDto registerForCandidateDto) {

		
		if(!checkIfEqualPasswordAndConfirmPassword(registerForCandidateDto.getPassword(),registerForCandidateDto.getConfirmedPassword())) {
			
			return new ErrorResult("Passwords do not match !");
		}
		
		Candidate candidate = modelMapper.map(registerForCandidateDto, Candidate.class);
		
		var result = this.candidateService.add(candidate);
		
		if(result.isSuccess()) {
			
			this.generateVerificationCode(candidate.getId());
		
		}
		return new ErrorResult(result.getMessage());
		
	}
	
	// confirmed password
	
	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

		
		if (!password.equals(confirmPassword)) {
			return false;
		}

		return true;
	}

	@Override
	public Result verifyEmail(int user_id, String activationCode) {
		
		var result = this.codeService.getByUserIdAndVerificationCode(user_id, activationCode);

		if(!this.isVerificationCodeExist(user_id, activationCode).isSuccess()
				&& !this.isVerificationCodeActive(user_id, activationCode).isSuccess()
				&& !isExpired(user_id,activationCode).isSuccess()) {
			
			return new ErrorResult();
		}

	    if(!this.setCandidateActivationCode(user_id).isSuccess() && !this.setEmployerActivationCode(user_id).isSuccess()) {
	    	return new ErrorResult("User couldn't find");
	    }
	    
	 
	    VerificationCode verificationCode = result.getData();
	    
	    verificationCode.setConfirmedDate(LocalDate.now());
	    verificationCode.setIsActivate(true);
	    this.codeService.update(verificationCode);
	   	    
	    return new SuccessResult("Verified !");

	}
	
	
	// business rules
	
	private Result setEmployerActivationCode(int user_id) {
		
    if(this.employerService.getById(user_id).getData()!= null) {
	    	
	    	Employer employer = this.employerService.getById(user_id).getData();
	    
	    	employer.setIsEmailVerified(true);
	    	
	    	this.employerService.update(employer);
	    	
	    	return new SuccessResult();
	    }
        
    return new ErrorResult();
	}
	
	private Result setCandidateActivationCode(int user_id) {
	    if(this.candidateService.getById(user_id).getData()!=null) {
	    	
	    	Candidate candidate =this.candidateService.getById(user_id).getData();
	    	
	    	candidate.setIsEmailVerified(true);
	    	
	    	this.candidateService.update(candidate);

	    	return new SuccessResult();
	    }
	    
	    return new ErrorResult();
		}
		
	private Result isVerificationCodeExist(int user_id, String activationCode) {
		
		if(this.codeService.getByUserIdAndVerificationCode(user_id, activationCode).getData()==null) {
			return new ErrorResult("Verification Code is wrong !");
		}
		return new SuccessResult();
		
	}
	
	private Result isVerificationCodeActive(int user_id, String activationCode) {
		
		if(this.codeService.getByUserIdAndVerificationCode(user_id, activationCode).getData().getIsActivate()) {

		    return new ErrorResult("Verification Code is already active");
		}
		return new SuccessResult();
	}

	private Result isExpired(int user_id, String activationCode) {
		
		if(this.codeService.getByUserIdAndVerificationCode(user_id, activationCode).getData().getExpiredDate().isBefore(LocalDate.now())) {

	    	return new ErrorResult("Verification Code is Expired");
		}
		return new SuccessResult();
	}
	
	private Result generateVerificationCode(int userId)
	{
		String code = this.verificationService.codeGenerator();
		this.verificationService.sendVerificationCode(code);
		VerificationCode verificationCode = new VerificationCode(userId,code, LocalDate.now().plusDays(1));
		this.codeService.add(verificationCode);
		return new SuccessResult("Candidate Registered !");
	}
	

}




















