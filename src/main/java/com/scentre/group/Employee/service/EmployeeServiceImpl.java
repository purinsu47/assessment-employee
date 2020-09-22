package com.scentre.group.Employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scentre.group.Employee.model.Employee;
import com.scentre.group.Employee.repositories.EmployeeRepository;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee findByName(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> findAllEmployeeByName(String name) {
		return employeeRepository.findAllByName(name);
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public List<Employee> findAllEmployeeByDeptCode(String deptcode) {
		return employeeRepository.findAllByDept(deptcode);
	}

	@Override
	public void updateEmployee(String name, Employee employee) {
		Employee emp = employeeRepository.findByName(name);
		emp.setDepartment(employee.getDepartment());
		emp.setEmployeetype(employee.getEmployeetype());
		emp.setManager(employee.getManager());
		emp.setMobilenumber(employee.getManager());
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		saveEmployee(emp);

	}

	@Override
	public Employee findById(String id) {
		return employeeRepository.findById(id);
	}

	@Override
	public void deleteEmployeeByName(String name) {
		Employee emp = employeeRepository.findByName(name);
		employeeRepository.delete(emp);
	}

	@Override
	public boolean isUserExist(Employee employee) {
		return findByName(employee.getName()) != null;
	}

}
