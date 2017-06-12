package com.courses.week4.mockito.examples;


import com.courses.week4.mockito.examples.model.*;
import com.courses.week4.mockito.examples.exceptions.CustomerNotFoundException;
import com.courses.week4.mockito.examples.service.CustomerService;
import com.courses.week4.mockito.examples.service.OrderService;
import com.courses.week4.mockito.examples.service.impl.SimpleOrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SimpleOrderServiceTest {

    @Mock
    private CustomerService customerService;

    //@InjectMocks
    private OrderService orderService;

//    @Mock
//    private Customer existingCustomer;

    @Before
    public void setUp() {
        //instead of using MockitoJUnitRunner
        MockitoAnnotations.initMocks(this);
        orderService = new SimpleOrderService(customerService);
    }

    private static final List<CartItem> EMPTY_CART_ITEM_LIST = Collections.emptyList();

    @Test(expected = CustomerNotFoundException.class)
    public void testCreateOrderShouldFailOnMissingCustomer() {

        when(customerService.findCustomerById(1L)).thenReturn(null);

        orderService.createOrder(1L, EMPTY_CART_ITEM_LIST);
    }

    @Test
    public void testCreateOrderShouldFindExistingCustomer() {

        // given
        Address homeAddress = new Address("Street", "apt 15", Country.NL);
        Customer existingCustomer = new Customer("James", "Cogan", homeAddress);

        when(customerService.findCustomerById(1L)).thenReturn(existingCustomer);

        // when
        Order createdOrder = orderService.createOrder(1L,
                Collections.emptyList());

        // then
        assertThat(createdOrder.getCustomer(), equalTo(existingCustomer));
        verify(customerService).findCustomerById(1L);
    }

}
