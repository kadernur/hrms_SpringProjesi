package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;


import kodlamaio.hrms.entities.dtos.RegisterForCandidateDto;
import kodlamaio.hrms.entities.dtos.RegisterForEmployerDto;

public interface AuthService {
	
	
		Result registerEmployer(RegisterForEmployerDto registerForEmployerDto);
	   
	   Result registerCandidate(RegisterForCandidateDto registerForCandidateDto);
	   
	   Result verifyEmail(int user_id, String activationCode);
}
