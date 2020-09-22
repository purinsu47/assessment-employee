package com.scentre.group.Employee.service;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;



import com.scentre.group.Employee.model.Employee;
import com.scentre.group.Employee.repositories.EmployeeRepository;

public class EmployeeServiceImplTest {
	
	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testFindByName() {
		employeeServiceImpl.findByName(Mockito.anyString());
	}
	
	@Test
	public void testFindAllEmployee() {
		employeeServiceImpl.findAllEmployee();
	}
	
	@Test
	public void testFindAllEmployeeByName() {
		employeeServiceImpl.findAllEmployeeByName(Mockito.anyString());
	}
	
	@Test
	public void testSaveEmployee() {
		employeeServiceImpl.saveEmployee(new Employee());
	}
	
	@Test
	public void testFindAllEmployeeByDeptCode() {
		employeeServiceImpl.findAllEmployeeByDeptCode(Mockito.anyString());
	}
	
	@Test
	public void testUpdateEmployee() {
		Employee employee = new Employee();
		employee.setName("name");
		employee.setDepartment("dept");
		employee.setManager("manager");
		employee.setMobilenumber("mobile");
		employee.setSalary("salary");
		
		when(employeeRepository.findByName(Mockito.anyString())).thenReturn(employee);
		employeeServiceImpl.updateEmployee(Mockito.anyString(), employee);
	}
	
	@Test
	public void testFindById() {
		employeeServiceImpl.findById(Mockito.anyString());
	}
	
	@Test
	public void testDeleteEmployeeByName() {
		employeeServiceImpl.deleteEmployeeByName(Mockito.anyString());
	}
	
	@Test
	public void testIsEmployeeExists() {
		employeeServiceImpl.isUserExist(new Employee());
	}
	
	@Test
	public void testIsEmployeeExistsTrue() {
		Employee employee = new Employee();
		employee.setName("name");
		employee.setDepartment("dept");
		employee.setManager("manager");
		employee.setMobilenumber("mobile");
		employee.setSalary("salary");
		
		when(employeeRepository.findByName(Mockito.anyString())).thenReturn(employee);
		employeeServiceImpl.isUserExist(employee);
	}
	

}
