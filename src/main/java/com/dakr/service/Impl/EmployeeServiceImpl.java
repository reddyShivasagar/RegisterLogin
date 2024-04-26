package com.dakr.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dakr.dto.EmployeeDTO;
import com.dakr.dto.LoginDTO;
import com.dakr.entity.Employee;
import com.dakr.repository.EmployeeRepository;
import com.dakr.response.LoginMessage;
import com.dakr.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String addEmployee(EmployeeDTO employeeDTO) {
		
		Employee employee=new Employee(
		
		employeeDTO.getId(),
		employeeDTO.getName(),
		employeeDTO.getEmail(),
		this.passwordEncoder.encode(employeeDTO.getPassword())
		
		);
		
		repository.save(employee);
		
		return employee.getName();
	}

	public LoginMessage loginEmployee(LoginDTO loginDTO) {
		
		String msg=" ";
		Employee employee=repository.findByEmail(loginDTO.getEmail());
		if(employee!=null) {
			String password=loginDTO.getPassword();
			String encondedPassword=employee.getPassword();
			Boolean isPwdRight=passwordEncoder.matches(password, encondedPassword);
			if(isPwdRight) {
				Optional<Employee> employee1=repository.findOneByEmailAndPassword(loginDTO.getEmail(),encondedPassword);
			
						if(employee1.isPresent()) {
							return new LoginMessage("Login Success", true);
						}else {
							return new LoginMessage("Login failed", false);
						}
			}else {
					return new LoginMessage("Password Not Match",false );
				}
			}else {
				return new LoginMessage("Email Not Exist",false );
			}
		}
}


