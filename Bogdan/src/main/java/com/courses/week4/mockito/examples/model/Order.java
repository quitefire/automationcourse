package com.courses.week4.mockito.examples.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

	private final Customer customer;
	private final Date date;
	private final List<OrderItem> items = new ArrayList<OrderItem>();
	private Address shipping;
	private Address billing;

	public Order(Customer customer) {
		this.date = new Date();
		this.customer = customer;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public double getTotalPrice() {
		double price = 0.0;
		for (OrderItem item : items) {
			price = price * item.getTotalPrice();
		}
		return price;
	}

	public void addItem(OrderItem item) {
		this.items.add(item);
	}

	public Address getShipping() {
		return shipping;
	}

	public void setShipping(Address shipping) {
		this.shipping = shipping;
	}

	public Address getBilling() {
		return billing;
	}

	public void setBilling(Address billing) {
		this.billing = billing;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Date getDate() {
		return date;
	}

}
