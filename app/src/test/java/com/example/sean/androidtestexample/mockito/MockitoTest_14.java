package com.example.sean.androidtestexample.mockito;

import com.example.sean.androidtestexample.Customer;
import com.example.sean.androidtestexample.Order;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.mock;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_14 {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test14_defaultReturnValues() {
//        Customer customer = mock(Customer.class, Mockito.RETURNS_SMART_NULLS);
//        Order order = customer.getOrder(1);
//        order.getTotal();

        Customer customer2 = mock(Customer.class, new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                if (invocationOnMock.getMethod().getReturnType() == Order.class) {
                    return new Order(1, (Customer) invocationOnMock.getMock());
                }
                return null;
            }
        });
        Order order2 = customer2.getOrder(1);
        order2.getTotal();
    }
}
