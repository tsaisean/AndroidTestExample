package com.example.sean.androidtestexample.mockito;

import com.example.sean.androidtestexample.Order;
import com.example.sean.androidtestexample.Package;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_21 {

    @Mock
    private Order order;

    @InjectMocks
    private Package mockedPackage;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test21_captor_spy_injectMocks() {
        // @InjectMocks
        /**
         * If you have two mocked Order objects, the first defined one will be used for injection.
         */
        Assert.assertEquals(order, mockedPackage.getOrder());
        Assert.assertEquals("BOX", mockedPackage.getType());
    }
}
