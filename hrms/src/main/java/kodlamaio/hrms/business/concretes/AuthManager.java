package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;

import kodlamaio.hrms.business.abstracts.EmployerSevice;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verification.VerificationService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service("AuthManager")

public class AuthManager implements AuthService {
	
	private CandidateService candidateService;
    private EmployerSevice employerService;
    private VerificationCodeService codeService;
    private VerificationService verificationService;
    
    
	

    @Autowired
	public AuthManager(CandidateService candidateService, EmployerSevice employerService,
			VerificationCodeService codeService, VerificationService verificationService) {
		super();
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.codeService = codeService;
		this.verificationService = verificationService;
	}
    
    
    

	
		
		
		public Result registerEmployer(Employer employer, String confirmedPassword) {
	        
		       if(!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(),confirmedPassword)) {
					
					return new ErrorResult("Passwords do not match !");
				}
				
			   	var result = this.employerService.add(employer);
				
		        if(result.isSuccess()) {
		        	 
		        
		        	 String code = this.verificationService.codeGenerator(); // verification code ürettim
		 			this.verificationService.sendVerificationCode(code);  // gönderdim
		 			
		 			VerificationCode kader = new VerificationCode(employer.getId(),code,LocalDate.now().plusDays(1));
		 			this.codeService.add(kader);  // veri tabanına ekledim.
		        	 
				   return new SuccessResult("Employer Registered !");
				   
		           }
		          return new ErrorResult("something's gone wrong... Please try again.");
			
			}

		
		
		
	

	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Result registerCandidate(Candidate candidate, String confirmedPassword) {
if(!checkIfEqualPasswordAndConfirmPassword(candidate.getPassword(),confirmedPassword)) {
			
			return new ErrorResult("Passwords do not match !");
		}
		
		var result = this.candidateService.add(candidate);
		
		if(result.isSuccess()) {
			
			String code = this.verificationService.codeGenerator(); // verification code ürettim
			this.verificationService.sendVerificationCode(code);  // gönderdim
			
			VerificationCode umut = new VerificationCode(candidate.getId(),code,LocalDate.now().plusDays(1));
			this.codeService.add(umut);  // veri tabanına ekledim.
			
			return new SuccessResult("Candidate Registered !");
		
		}
		return new ErrorResult("something's gone wrong... Please try again.");
		
	}

	
	
	
	
	
	
	
	
	@Override
	public Result verifyEmail(int user_id, String activationCode) {
var result = this.codeService.getByUserIdAndVerificationCode(user_id, activationCode);
		
	    if(result.getData() ==null) {
	    	
	    	return new ErrorResult("Verification Code is wrong !");
	    }
	    
	    if(result.getData().getIsActivate()) {
	    	return new ErrorResult("Verification Code is already active");
	    }
	    
	    if(result.getData().getExpiredDate().isBefore(LocalDate.now())){
	 
	    	return new ErrorResult("Verification Code is Expired");
	    }
	   
	    // TODO: abla intihar etmeden önce  --- aha umut gör :P 
	  
	    
	    VerificationCode verificationCode = result.getData();
	    
	    verificationCode.setConfirmedDate(LocalDate.now());
	    verificationCode.setIsActivate(true);
	    this.codeService.update(verificationCode);
	   
	    return new SuccessResult("Verified !");
	}










private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

	
	if (!password.equals(confirmPassword)) {
		return false;
	}

	return true;
}





}




















