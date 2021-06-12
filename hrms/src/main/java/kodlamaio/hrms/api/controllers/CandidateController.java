package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

@RestController
@RequestMapping("api/candidates")
@CrossOrigin
public class CandidateController {
	
	private CandidateService candidateService;
	
	

	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	
	@GetMapping("/getall")
	
	public List<Candidate> getAll(){
		return this.candidateService.getAll().getData();
	}
	
	
	@GetMapping("getCVById")
	public DataResult<CandidateCvDto> getCvById(@RequestParam int candidateId){
		
		return this.candidateService.getDtoById(candidateId);
	}
	
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate) {
		
		return this.candidateService.add(candidate);
		
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Candidate candidate) {
		
		return this.candidateService.update(candidate);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody Candidate candidate) {
		
		return this.candidateService.delete(candidate);
	}

}
