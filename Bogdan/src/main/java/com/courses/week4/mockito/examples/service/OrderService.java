package com.courses.week4.mockito.examples.service;


import com.courses.week4.mockito.examples.exceptions.CustomerNotFoundException;
import com.courses.week4.mockito.examples.model.CartItem;
import com.courses.week4.mockito.examples.model.Order;

import java.util.List;

public interface OrderService {

	Order createOrder(long customerId, List<CartItem> items)
			throws CustomerNotFoundException;

}