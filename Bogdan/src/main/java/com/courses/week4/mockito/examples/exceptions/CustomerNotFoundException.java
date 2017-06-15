package com.courses.week4.mockito.examples.exceptions;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final long customerId;

	public CustomerNotFoundException(long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String getMessage() {
		return String.format("Customer with id %s not found.", customerId);
	}

}
