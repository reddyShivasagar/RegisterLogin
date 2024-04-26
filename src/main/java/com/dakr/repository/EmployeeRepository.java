package com.dakr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.dakr.entity.Employee;

@EnableJpaRepositories
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Optional<Employee>	findOneByEmailAndPassword(String email,String password);

	Employee findByEmail(String email);
}
