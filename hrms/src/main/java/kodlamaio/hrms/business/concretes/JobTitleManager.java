package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;

@Service("JobTitleManager")

public class JobTitleManager implements JobTitleService {
	
	
	private JobTitleDao jobtitleDao;
	

	@Autowired
	public JobTitleManager(JobTitleDao jobtitleDao) {
		super();
		this.jobtitleDao = jobtitleDao;
	}

	
	
	
	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobtitleDao.findAll());
		
	}
	
	
	

	@Override
	public Result add(JobTitle jobTitle) {
		
		if(!this.isTitleExist(jobTitle.getTitleName()))
		{
			return new ErrorResult("Job title Exist!");
		}
		
		this.jobtitleDao.save(jobTitle);
		
		return new SuccessResult("Job Title Added.");
		
		
		
	}
	
	
	private  boolean isTitleExist(String titleName)
	{
		if(this.jobtitleDao.findByTitleName(titleName)!= null)
		{
			return false;
		}
		return true;
		
	}

}






















