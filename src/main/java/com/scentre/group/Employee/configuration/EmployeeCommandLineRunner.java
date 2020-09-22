package com.scentre.group.Employee.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.scentre.group.Employee.model.Employee;
import com.scentre.group.Employee.repositories.EmployeeRepository;

@Component
public class EmployeeCommandLineRunner implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		for (Employee employee : employeeRepository.findAll()) {
			System.out.println(employee.toString());
		}
	}

}
