package com.courses.week4.mockito.examples.service.impl;


import com.courses.week4.mockito.examples.exceptions.CustomerNotFoundException;
import com.courses.week4.mockito.examples.model.CartItem;
import com.courses.week4.mockito.examples.model.Customer;
import com.courses.week4.mockito.examples.model.Order;
import com.courses.week4.mockito.examples.model.OrderItem;
import com.courses.week4.mockito.examples.service.CustomerService;
import com.courses.week4.mockito.examples.service.OrderService;

import java.util.List;

public class SimpleOrderService implements OrderService {

	private CustomerService customerService;

	public SimpleOrderService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public Order createOrder(long customerId, List<CartItem> items)
			throws CustomerNotFoundException {

		Customer customer = customerService.findCustomerById(customerId);
		if (customer == null) {
			throw new CustomerNotFoundException(customerId);
		}

		Order order = new Order(customer);
		for (CartItem item : items) {

			int quantity = item.getQuantity();
			double price = item.getProduct().getPrice();
			double totalPrice = price * quantity;

			order.addItem(new OrderItem(item.getProduct(), quantity, totalPrice));
		}

		order.setBilling(customer.getWorkAddress());
		order.setShipping(customer.getHomeAddress());

		return order;
	}
}
