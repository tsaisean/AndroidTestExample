package com.example.sean.androidtestexample.powermockito;

import com.example.sean.androidtestexample.Customer;
import com.example.sean.androidtestexample.CustomerUtils;
import com.example.sean.androidtestexample.Order;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.any;

/**
 * Created by Sean on 2017/9/18.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({CustomerUtils.class, Order.class})
public class OrderTest {
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer(1, "Sean");
        customer.setLevel(11);
    }

    @Test
    public void getTotal() throws Exception {
        PowerMockito.mockStatic(CustomerUtils.class);
        Mockito.when(CustomerUtils.isVIP(any(Customer.class))).thenReturn(true);

        Order order = new Order((long) 1, customer);
        order.setOriginalTotal(10);
        Assert.assertEquals(8f, order.getTotal());
    }

    @Test
    public void getTotal_mockOriginTotal() throws Exception {
        Order order = PowerMockito.spy(new Order((long) 1, customer));

        PowerMockito.doReturn(20f).when(order, "getOriginalTotal");
        Assert.assertEquals(16f, order.getTotal());
    }

}