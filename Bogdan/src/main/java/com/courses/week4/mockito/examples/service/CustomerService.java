package com.courses.week4.mockito.examples.service;


import com.courses.week4.mockito.examples.model.Customer;

public interface CustomerService {

	Customer findCustomerById(long customerId);
}
