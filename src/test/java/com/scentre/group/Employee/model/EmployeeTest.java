package com.scentre.group.Employee.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;

public class EmployeeTest {
	
	@InjectMocks Employee employee = new Employee();
	
	@Test
	public void testSetGet() {
		employee.setDepartment("department");
		employee.setId(02l);
		employee.setName("name");
		employee.setManager("manager");
		employee.setMobilenumber("0022");
		employee.setSalary("2000");
		employee.setEmployeetype("type");
		
		assertEquals("department", employee.getDepartment());
		assertEquals(02l, employee.getId());
		assertEquals("name", employee.getName());
		assertEquals("manager", employee.getManager());
		assertEquals("0022", employee.getMobilenumber());
		assertEquals("2000", employee.getSalary());
		assertEquals("type", employee.getEmployeetype());
		
		employee.toString();
		
	}

}
