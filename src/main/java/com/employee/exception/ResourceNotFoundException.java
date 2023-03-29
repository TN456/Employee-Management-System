package com.employee.exception;
/**
 * @author Tanuja N
 *
 */
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}


}
