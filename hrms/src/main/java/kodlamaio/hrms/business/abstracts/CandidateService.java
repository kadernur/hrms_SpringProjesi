package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

public interface CandidateService {
	
	
	DataResult<Candidate> getByNationalId(String nationalId);
	DataResult<Candidate> getByEmail(String email);
	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate);
	
    DataResult<Candidate> getById(int candidateId);
	
	DataResult<CandidateCvDto> getDtoById(int candidateId);

	
	Result update(Candidate candidate);
	
	Result delete(Candidate candidate);
}
