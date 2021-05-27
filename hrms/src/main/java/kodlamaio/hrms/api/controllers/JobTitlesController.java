package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("api/jobtitles")

public class JobTitlesController {
	
	private JobTitleService jobTitleService;
	
	
	

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	
	@GetMapping("/getall")
	
	public List<JobTitle> getAll()
	{
		return this.jobTitleService.getAll().getData();
	}
	
	
	@PostMapping("/add")
	public Result registerCandidate(@RequestBody JobTitle jobTitle)
	{
		return this.jobTitleService.add(jobTitle);
	}

}
