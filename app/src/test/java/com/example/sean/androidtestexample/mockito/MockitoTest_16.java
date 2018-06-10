package com.example.sean.androidtestexample.mockito;

import com.example.sean.androidtestexample.Order;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_16 {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test16_capturingArguments () {
        Order order = mock(Order.class);
        when(order.getDefaultVipDiscount()).thenCallRealMethod();

        Assert.assertEquals(0.8f, order.getDefaultVipDiscount());
    }
}
