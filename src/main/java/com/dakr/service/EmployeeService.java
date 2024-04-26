package com.dakr.service;

import com.dakr.dto.EmployeeDTO;
import com.dakr.dto.LoginDTO;
import com.dakr.response.LoginMessage;

public interface EmployeeService {

	public String addEmployee(EmployeeDTO employeeDTO);
	
	public LoginMessage loginEmployee(LoginDTO loginDTO);
}
