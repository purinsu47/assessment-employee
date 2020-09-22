package com.scentre.group.Employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scentre.group.Employee.model.Employee;
import com.scentre.group.Employee.service.EmployeeService;
import com.scentre.group.Employee.util.CustomErrorType;
import com.scentre.group.Employee.util.Success;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employee/")
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;

	public static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);

	@ApiOperation(value = "Add a new Employee details.")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseEntity<?> addNewEmployee(@RequestBody Employee employee) {

		if (employeeService.isUserExist(employee)) {
			logger.error("Unable to create. An Employee with name {} already exist", employee.getName());
			CustomErrorType error = new CustomErrorType(
					"Unable to create. An Employee with name " + employee.getName() + " already exist.");
			return new ResponseEntity<CustomErrorType>(error, HttpStatus.CONFLICT);
		}
		logger.info("Adding Employee...");
		employeeService.saveEmployee(employee);
		Success success = new Success(true, "Successfully Added", employee.getName());
		return new ResponseEntity<Success>(success, HttpStatus.OK);
	}

	@ApiOperation(value = "Update Employee Details by Employee name.")
	@RequestMapping(value = "update/{name}", method = RequestMethod.POST)
	public ResponseEntity<?> updateEmployee(@PathVariable("name") String name, @RequestBody Employee employee) {

		if (!employeeService.isUserExist(employee)) {
			logger.error("Unable to update. An Employee with name {} does not exist", employee.getName());
			CustomErrorType error = new CustomErrorType(
					"Unable to update. An Employee with name " + employee.getName() + " does not exist.");
			return new ResponseEntity<CustomErrorType>(error, HttpStatus.CONFLICT);
		}
		logger.info("Updating Employee with name {}", name);
		employeeService.updateEmployee(name, employee);
		Success success = new Success(true, "Successfully Updated", employee.getName());
		return new ResponseEntity<Success>(success, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Employee Details by Employee Name.")
	@RequestMapping(value = "delete/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployee(@PathVariable("name") String name) {
		Employee employee = employeeService.findByName(name);
		if (employee == null) {
			logger.error("Unable to delete. An Employee with name {} does not exist", name);
			CustomErrorType error = new CustomErrorType(
					"Unable to delete. An Employee with name " + name + " does not exist.");
			return new ResponseEntity<CustomErrorType>(error, HttpStatus.CONFLICT);
		}
		logger.info("Deleting Employee with name {}", name);
		employeeService.deleteEmployeeByName(name);
		Success success = new Success(true, "Successfully Deleted", name);
		return new ResponseEntity<Success>(success, HttpStatus.OK);
	}

	@ApiOperation(value = "Employee Details by Employee Name.")
	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployeeByName(@PathVariable("name") String name) {
		logger.info("Fetching Employee with name {}", name);
		Employee employee = employeeService.findByName(name);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@ApiOperation(value = "List of all Employees Details.")
	@RequestMapping(value = "all", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		logger.info("Fetching all Employees");
		List<Employee> employeeList = employeeService.findAllEmployee();
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}

	@ApiOperation(value = "List of all Employee Details by Employee Name.")
	@RequestMapping(value = "all/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployeesByName(@PathVariable("name") String name) {
		logger.info("Fetching all Employees with name {}", name);
		List<Employee> employeeList = employeeService.findAllEmployeeByName(name);
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}

	@ApiOperation(value = "List of all Employee Details by Department")
	@RequestMapping(value = "department/{code}", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployeesByDept(@PathVariable("code") String code) {
		logger.info("Fetching all Employees from Deparment {}", code);
		List<Employee> employeeList = employeeService.findAllEmployeeByDeptCode(code);
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}

}
