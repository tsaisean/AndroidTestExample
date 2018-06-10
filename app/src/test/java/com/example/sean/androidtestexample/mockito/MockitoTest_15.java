package com.example.sean.androidtestexample.mockito;

import com.example.sean.androidtestexample.Customer;
import com.example.sean.androidtestexample.Order;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_15 {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test15_capturingArguments () {
        Customer customer = mock(Customer.class);
        customer.addOrder(new Order(1, customer));
        customer.addOrder(new Order(2, customer));

        ArgumentCaptor<Order> argument = ArgumentCaptor.forClass(Order.class);
        verify(customer, times(2)).addOrder(argument.capture());

        Assert.assertEquals(1, argument.getAllValues().get(0).getId());
        Assert.assertEquals(2, argument.getAllValues().get(1).getId());
        Assert.assertEquals(2, argument.getValue().getId());
    }
}
