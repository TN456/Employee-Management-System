package com.employee.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

/**
 * @author Tanuja N
 *
 */
@SpringBootTest
class EmployeeServiceImplTest {
	
	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@BeforeEach
	void setup() {
		Optional<Employee> employee = Optional.of(new Employee(2,"Tanuja","123456","tanuja232002@gmailcom"));
		Mockito.when(employeeRepository.findById(2)).thenReturn(employee);
	}
	
	@Test
	public void testGetEmployeeById() {
		String employee_name = "Tanuja";
		Employee employeeById = employeeService.getEmployeeById(2);
		assertEquals(employee_name, employeeById.getName());
	}

}
