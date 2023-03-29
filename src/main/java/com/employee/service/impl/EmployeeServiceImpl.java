package com.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.exception.ResourceNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

/**
 * @author Tanuja N
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		}
		throw new ResourceNotFoundException("Expense is not found for the id "+id);
	}

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		Employee existingEmployee = getEmployeeById(id);
		existingEmployee.setName(employee.getName() != null ? employee.getName() : existingEmployee.getName());
		existingEmployee.setEmail(employee.getEmail() != null ? employee.getEmail() : existingEmployee.getEmail());
		existingEmployee.setPhonenumber(employee.getPhonenumber() != null ? employee.getPhonenumber() : existingEmployee.getPhonenumber());
		return employeeRepository.save(existingEmployee);

	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee is not found for the id "+id));
		employeeRepository.deleteById(id);
	}
}
