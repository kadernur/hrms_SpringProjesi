package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Link;

public interface LinkService {
	
	
	Result add(Link link);


	DataResult<List<Link>> getAllByCandidateId(int candidateId);

	Result update(Link link);
	
	Result delete(Link link);
	
}
