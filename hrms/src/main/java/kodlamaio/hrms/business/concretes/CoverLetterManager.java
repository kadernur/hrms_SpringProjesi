package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrms.entities.concretes.CoverLetter;

@Service("CoverLetterManager")

public class CoverLetterManager implements CoverLetterService {
	
	private CoverLetterDao coverLetterDao;
	

	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}
	
	

	@Override
	public Result add(CoverLetter coverLetter) {
		
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("CoverLetter Added");
		
	}

	@Override
	public DataResult<List<CoverLetter>> getAllByCandidateId(int candidateId) {
		
		
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAllByCandidate_Id(candidateId));
		
		
	}

	@Override
	public Result update(CoverLetter coverLetter) {
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Cover letter updated !");
	}

	@Override
	public Result delete(CoverLetter coverLetter) {
		
		  this.coverLetterDao.delete(coverLetter);
	        return new SuccessResult("Cover letter deleted !");
	}

}
