package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.School;

@Service("SchoolManager")
public class SchoolManager implements SchoolService {
	
	private SchoolDao schoolDao;
	

	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	
	@Override
	public Result add(School school) {

		this.schoolDao.save(school);

		return new SuccessResult("School added.");
	}

	@Override
	public DataResult<List<School>> getAllByCandidateIdOrderByGraduationYear(int candidateId) {
		
		
		return new SuccessDataResult<List<School>>
		(this.schoolDao.findAllByCandidate_IdOrderByGraduationYear(candidateId));
	
	
	}

	@Override
	public DataResult<List<School>> getAllByCandidateId(int candidateId) {
		
		
		return new SuccessDataResult<List<School>>
		(this.schoolDao.findAllByCandidate_Id(candidateId));
	
	
	}

	@Override
	public Result update(School school) {
		 this.schoolDao.save(school);
			return new SuccessResult("School updated.");
	}

	@Override
	public Result delete(School school) {
		this.schoolDao.delete(school);
		return new SuccessResult("School deleted.");
	}

}
