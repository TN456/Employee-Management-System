package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

/**
 * @author Tanuja N
 *
 */
public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(int id);
	Employee updateEmployee(Employee employee,int id);
	void deleteEmployee(int id);
}
