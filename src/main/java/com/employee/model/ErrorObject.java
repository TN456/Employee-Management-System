package com.employee.model;

/**
 * @author Tanuja N
 *
 */
import lombok.Data;

@Data
public class ErrorObject {
	
	private Integer statusCode;
	
	private String message;
	
}
