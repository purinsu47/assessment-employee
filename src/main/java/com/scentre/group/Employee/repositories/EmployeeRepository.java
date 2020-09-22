package com.scentre.group.Employee.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.scentre.group.Employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Employee findById(String id);

	Employee findByName(String name);
	
	@Query(value = "Select * from employee e where e.name = ?1", nativeQuery = true)
	List<Employee> findAllByName(String name);
	
	@Query(value = "Select * from employee e where e.department = ?1", nativeQuery = true)
	List<Employee> findAllByDept(String deptcode);
}
