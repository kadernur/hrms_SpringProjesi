package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;

@RestController
@CrossOrigin //Araştır
@RequestMapping("api/coverLetters")
public class CoverLetterController {
	
	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLetterController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	
	
	@PostMapping("/add")
	public Result add(@RequestBody CoverLetter coverLetter) {
		
		return this.coverLetterService.add(coverLetter);
	}
	
	
	
	@PostMapping("/update")
	public Result update(@RequestBody CoverLetter coverLetter) {
		
		return this.coverLetterService.update(coverLetter);
	}
	
	
	@PostMapping("/delete")
	public Result delete(@RequestBody CoverLetter coverLetter) {
		
		return this.coverLetterService.delete(coverLetter);
	}
	

}
