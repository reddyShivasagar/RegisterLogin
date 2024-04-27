package com.dakr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dakr.dto.EmployeeDTO;
import com.dakr.service.Impl.EmployeeServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@PostMapping("/save")
	public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
		String id=employeeService.addEmployee(employeeDTO);
		return id;
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO){
		
		LoginMessage loginMessage=employeeService.loginEmployee(loginDTO);
		return ResponseEntity.ok(loginMessage);
	}
}
