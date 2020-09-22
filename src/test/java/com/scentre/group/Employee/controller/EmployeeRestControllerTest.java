package com.scentre.group.Employee.controller;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.scentre.group.Employee.model.Employee;
import com.scentre.group.Employee.service.EmployeeServiceImpl;

public class EmployeeRestControllerTest {

	@InjectMocks EmployeeRestController employeeRestController;
	
	@Mock EmployeeServiceImpl employeeServiceImpl;
	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testAddnewEmployee_SUCCESS() {
		employeeRestController.addNewEmployee(new Employee());
	}
	
	@Test
	public void testAddnewEmployee_EMPLOYEE_EXISTS() {
		when(employeeServiceImpl.isUserExist(Matchers.any())).thenReturn(true);
		employeeRestController.addNewEmployee(new Employee());
	}
	
	@Test
	public void testUpdateEmployee_SUCCESS() {
		when(employeeServiceImpl.isUserExist(Matchers.any())).thenReturn(true);
		employeeRestController.updateEmployee("Name", new Employee());
	}
	
	@Test
	public void testUpdateEmployee_EMPLOYEE_NOT_EXISTS() {
		when(employeeServiceImpl.isUserExist(Matchers.any())).thenReturn(false);
		employeeRestController.updateEmployee("Name", new Employee());
	}
	
	@Test
	public void testDeleteEmployee_SUCCESS() {
		when(employeeServiceImpl.findByName(Matchers.anyString())).thenReturn(new Employee());
		employeeRestController.deleteEmployee("name");
	}
	
	@Test
	public void testDeleteEmployee_EMPLOYEE_NOT_EXISTS() {
		when(employeeServiceImpl.findByName(Matchers.anyString())).thenReturn(null);
		employeeRestController.deleteEmployee("name");
	}
	
	@Test
	public void testGetEmployeeByName_SUCCESSS() {
		employeeRestController.getEmployeeByName("name");
	}
	
	@Test
	public void testGetEmployeesByName_SUCCESSS() {
		employeeRestController.getAllEmployeesByName("name");
	}
	
	@Test
	public void testGetAllEmployees_SUCCESSS() {
		employeeRestController.getAllEmployees();
	}
	
	@Test
	public void testGetAllEmployeeByDept_SUCCESSS() {
		employeeRestController.getAllEmployeesByDept("name");
	}
}
