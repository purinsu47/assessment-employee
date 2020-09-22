package com.scentre.group.Employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.scentre.group.Employee.model.Employee;
import com.scentre.group.Employee.repositories.EmployeeRepository;

@SpringBootTest
class EmployeeApplicationTests {
	
	@Autowired EmployeeRepository employeeRepository;

	@Test
	public void Test_Integration() {
		Employee employee = new Employee();
		employee.setDepartment("Dept001");
		employee.setEmployeetype("Offlane");
		employee.setManager("Man001");
		employee.setMobilenumber("001");
		employee.setName("MidOne");
		employee.setSalary("1200000");
		Employee employeeEntity = employeeRepository.save(employee);
		Employee foundEntity = employeeRepository.findByName(employeeEntity.getName());
		
		assertNotNull(foundEntity);
		assertEquals(employeeEntity.getName(), foundEntity.getName());
		
	}

}
