package kodlamaio.hrms.core.utilities.adapters_mernis;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.mernisService.FakeMernisService;

@Service

public class MernisServiceAdapter implements UserCheckService  {

	
	
	
	@Override
	public boolean checkIfRealPerson(long nationalityId, String firstName, String lastName, LocalDate dateOfBirth)
	
	
	{
		
		
FakeMernisService client= new FakeMernisService();
		
		boolean result = client.TCKimlikDogrula(nationalityId, firstName, lastName, dateOfBirth);
		

		return result;
	}

}
