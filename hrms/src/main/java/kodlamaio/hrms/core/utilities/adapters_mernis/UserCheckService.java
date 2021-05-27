package kodlamaio.hrms.core.utilities.adapters_mernis;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
@Service

public interface UserCheckService {
	
	
	boolean checkIfRealPerson(long nationalityId, String firstName, String lastName,LocalDate dateOfBirth);
	




}
