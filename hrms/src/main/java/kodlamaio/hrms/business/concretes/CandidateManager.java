
package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.adapters_mernis.UserCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;


@Service("CandidateManager")

public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserCheckService userCheckService;
	private JobExperienceService jobExperienceService;
	private ImageService imageService;
	private LanguageService languageService;
	private LinkService linkService;
	private SkillService skillService;
	private SchoolService schoolService;
	private CoverLetterService coverLetterService;
	
	
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserCheckService userCheckService,
			JobExperienceService jobExperienceService, ImageService imageService, LanguageService languageService,
			LinkService linkService, SkillService skillService, SchoolService schoolService,CoverLetterService coverLetterService) {
		super();
		this.candidateDao = candidateDao;
		this.userCheckService = userCheckService;
		this.jobExperienceService = jobExperienceService;
		this.imageService = imageService;
		this.languageService = languageService;
		this.linkService = linkService;
		this.skillService = skillService;
		this.schoolService = schoolService;
		this.coverLetterService = coverLetterService;
	}

	
	
	@Override
	public DataResult<Candidate> getByNationalId(String nationalId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByIdentificationNumber(nationalId));
	
	
	
	}

	
	
	
	
	@Override
	public DataResult<Candidate> getByEmail(String email) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.findByEmail(email));
	}

	
	
	
	
	
	
	
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	
	}

	
	
	
	
	@Override
	public Result add(Candidate candidate) {
		if(!validationForCandidate(candidate)) {
			return new ErrorResult("Missing information...");
		}
		
		if(!checkIfRealPerson(candidate)) {
			return new ErrorResult("Invalid person...");
		}
		if(!checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult("Email already exist...");
		}
		if(!checkIfNationalityId(candidate.getIdentificationNumber())) {
			return new ErrorResult("Nationality already exist...");
		}
		
		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate added !");
	}
	
	
	// business rules
	private boolean checkIfEmailExists(String email) {
		if(this.candidateDao.findByEmail(email) !=null) {
			return false;
		}
		return true;
		
	}
	
	private boolean checkIfNationalityId(String nationalityId) {
		if(this.candidateDao.findByIdentificationNumber(nationalityId)!=null) {
			return false;
		}
		return true;
	}
	
	private boolean checkIfRealPerson(Candidate candidate) {
		   if(!this.userCheckService.checkIfRealPerson(Long.parseLong(candidate.getIdentificationNumber()), candidate.getFirstName().toUpperCase(new Locale("tr")), candidate.getLastName().toLowerCase(new Locale("tr")),
				   candidate.getDateOfBirth())) {
			   
			   return false;
		   }
		   return true;
			
		}
		

	private boolean validationForCandidate(Candidate candidate) {
		
		if(candidate.getFirstName() == null && candidate.getLastName() == null && candidate.getIdentificationNumber() == null
				&& candidate.getDateOfBirth() == null && candidate.getEmail() == null) {
			return false;
					
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	

	@Override
	public DataResult<Candidate> getById(int candidateId) {
		
		
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(candidateId));
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	

	@Override
	public DataResult<CandidateCvDto> getDtoById(int candidateId) {
		
		
		
		
		CandidateCvDto cvDto = new CandidateCvDto(); 
		
		cvDto.jobExperiences =this.jobExperienceService.getAllByCandidateId(candidateId).getData();
		cvDto.schools = this.schoolService.getAllByCandidateId(candidateId).getData();
		cvDto.languages =this.languageService.getAllByCandidateId(candidateId).getData();
		cvDto.links =this.linkService.getAllByCandidateId(candidateId).getData();
		cvDto.skills =this.skillService.getAllByCandidateId(candidateId).getData();
		cvDto.image =this.imageService.getByCandidateId(candidateId).getData();
		cvDto.coverLetters = this.coverLetterService.getAllByCandidateId(candidateId).getData();
		return new SuccessDataResult<CandidateCvDto>(cvDto);
		
		
		
		
		
		
		
		
		
		
		
	}



	@Override
	public Result update(Candidate candidate) {
		
		
		 this.candidateDao.save(candidate);
			
			return new SuccessResult("Candidate updated !");
			
			
	}



	@Override
	public Result delete(Candidate candidate) {
		
		
		
		this.candidateDao.delete(candidate);
		return new SuccessResult("Candidate deleted");
		
		
		
		
		
	}

}
