package com.scentre.group.Employee.service;

import java.util.List;

import com.scentre.group.Employee.model.Employee;

public interface EmployeeService {
	
	Employee findByName(String name);
	
	Employee findById(String id);
	
	List<Employee> findAllEmployee();
	
	List<Employee> findAllEmployeeByName(String name);
	
	List<Employee> findAllEmployeeByDeptCode(String deptcode);
	
	void saveEmployee(Employee employee);
	
	void updateEmployee(String name, Employee employee);
	
	void deleteEmployeeByName(String name);
	
	boolean isUserExist(Employee employee);
}
