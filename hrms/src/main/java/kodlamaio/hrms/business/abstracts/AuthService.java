package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;

public interface AuthService {
	
	Result registerEmployer( Employer employer,String confirmedPassword);
	Result registerCandidate(Candidate candidate,String confirmedPassword);
	Result verifyEmail(int user_id,String activationCode);

}
