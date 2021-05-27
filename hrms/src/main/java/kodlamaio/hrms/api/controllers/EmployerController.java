package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerSevice;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController

@RequestMapping("api/employers")
public class EmployerController {
	
	private EmployerSevice employerService;

	
	@Autowired
	public EmployerController(EmployerSevice employerService) {
		super();
		this.employerService = employerService;
	}
	
	
	@GetMapping("/getall")
	public List<Employer> getAll()
	{
		return this.employerService.getAll().getData();
	}

}
