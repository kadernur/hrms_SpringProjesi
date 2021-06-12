package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.School;

@RestController
@CrossOrigin
@RequestMapping("api/schools")

public class SchoolController {
	
	
	private SchoolService schoolService;

	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody School  school) {
		
		return this.schoolService.add(school);
	}
	
	
	
	@PostMapping("/update")
	public Result update(@RequestBody School school) {
		
		return this.schoolService.update(school);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody School school) {
		
		return this.schoolService.delete(school);
	}
}
	


