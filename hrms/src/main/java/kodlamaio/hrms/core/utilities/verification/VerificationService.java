package kodlamaio.hrms.core.utilities.verification;

public interface VerificationService {
	void sendVerificationCode(String email);
	String codeGenerator();

}
