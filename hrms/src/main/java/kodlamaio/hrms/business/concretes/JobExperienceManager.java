package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.JobExperience;

@Service("JobExperienceManager")
public class JobExperienceManager implements JobExperienceService {

	private JobExperienceDao jobExperienceDao;
	
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	
	
	@Override
	public Result add(JobExperience jobExperinence) {
		this.jobExperienceDao.save(jobExperinence);
		return new SuccessResult("Job Experience added. ");
	}
		

	@Override
	public DataResult<List<JobExperience>> getAllByCandidateIdOrderByResignationTimeDesc(int candidateId) {
		
		return new SuccessDataResult<List<JobExperience>>
		(this.jobExperienceDao.findAllByCandidate_IdOrderByResignationTimeDesc(candidateId));
	}

	@Override
	public DataResult<List<JobExperience>> getAllByCandidateId(int candidateId) {
		
		
		
		return new SuccessDataResult<List<JobExperience>>
		(this.jobExperienceDao.findAllByCandidate_Id(candidateId));
	
	
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		
		return new SuccessDataResult<List<JobExperience>>
		(this.jobExperienceDao.findAll());
		
		
	}

	
	@Override
	public DataResult<JobExperience> getById(int id) {
		
		return new SuccessDataResult<JobExperience>
		(this.jobExperienceDao.findById(id).orElseGet(null));
		
	}

	@Override
	public Result update(JobExperience jobExperinence) {
		this.jobExperienceDao.save(jobExperinence);
		return new SuccessResult("Job Experience updated.");
	}

	@Override
	public Result delete(JobExperience jobExperinence) {
		this.jobExperienceDao.delete(jobExperinence);
		return  new SuccessResult("Job Experience deleted.");
	}

}
