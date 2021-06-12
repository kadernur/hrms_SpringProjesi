package kodlamaio.hrms.core.utilities.verification;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class VerificationManager  implements VerificationService{

	
	
	//Email gönderme simule
	@Override
	public void sendVerificationCode(String email) {
		
		UUID uuid=UUID.randomUUID();
		
		@SuppressWarnings("unused")
		String verificationLink ="https://hrmsverificationmail/" + uuid.toString();
		
	}

	@Override
	public String codeGenerator() {
		
		
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString();
		return verificationCode;
		
	}

}
