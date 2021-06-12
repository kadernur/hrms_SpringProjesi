package kodlamaio.hrms.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
//import kodlamaio.hrms.entities.concretes.Candidate;
//import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.RegisterForCandidateDto;
import kodlamaio.hrms.entities.dtos.RegisterForEmployerDto;

@RestController
@CrossOrigin
@RequestMapping("api/auth")

public class AuthController {
	
	private AuthService authService;
	
	
	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	
	@PostMapping("/registerCandidate")
	public Result registerCandidate( @RequestBody RegisterForCandidateDto registerForCandidateDto) {
		
		return this.authService.
				registerCandidate(registerForCandidateDto);
		
	}
	
	@PostMapping("/registerEmployer")
	public Result registerCandidate(@RequestBody RegisterForEmployerDto registerForEmployerDto) {
		
		return this.authService.registerEmployer(registerForEmployerDto);
		
	}
	
	
	
	//@GetMapping("/verify")
	//public Result verify(int userId, String verificationCode) {
		
	//	return this.authService.verifyEmail(userId, verificationCode);
//	}

}
