package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	
	
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisementDto>> getByIsActive();
	
	DataResult<List<JobAdvertisementDto>> getAllSortedByReleaseDate();
	
	DataResult<List<JobAdvertisementDto>> getAllByEmployerId(int employerId);

	
	
	Result toggleActive(int jobId);
	

	Result update(JobAdvertisement jobAdvertisement);
	
	Result delete(JobAdvertisement jobAdvertisement);

}
