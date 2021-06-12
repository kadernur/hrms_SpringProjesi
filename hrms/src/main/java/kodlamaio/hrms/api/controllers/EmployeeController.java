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

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("api/employees")
@CrossOrigin

public class EmployeeController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeService) {
		super();
		this.employeeService = employeService;
	}
	
	// TODO Teste girecek
	
	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll() {
		
		
		return this.employeeService.getAll();
		
	}

	@GetMapping("getbyid")
	public DataResult<Employee> getById(@RequestParam("id") int employeeId){
		return this.employeeService.getById(employeeId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employee employee){
		return this.employeeService.add(employee);
	}

	@PostMapping("/update")
 	public Result update(@RequestBody Employee employee){
		return this.employeeService.update(employee);
	}
	
	@PostMapping("/delete")
    public Result delete(@RequestBody Employee employee){
		return this.employeeService.delete(employee);
	}
	
	

}
