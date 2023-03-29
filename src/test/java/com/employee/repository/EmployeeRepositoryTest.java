package com.employee.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.employee.model.Employee;

/**
 * @author Tanuja N
 *
 */
@DataMongoTest
class EmployeeRepositoryTest {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@BeforeEach
	void setUp() {
		Employee employee = new Employee(1,"Tanuja","2836918","tanujalsj");
		employeeRepository.save(employee);
	}

	@Test
	public void testFindById() {
		Employee employee = employeeRepository.findById(1).get();
		assertEquals("Tanuja",employee.getName());
	}

}
