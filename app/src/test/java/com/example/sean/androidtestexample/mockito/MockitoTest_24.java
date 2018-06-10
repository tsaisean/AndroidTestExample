package com.example.sean.androidtestexample.mockito;

import com.example.sean.androidtestexample.Order;
import com.example.sean.androidtestexample.Package;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_24 {

    @Mock
    private Order order;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test24_oneLinerStubs() {
        Package mockedPackage = when(mock(Package.class).getOrder()).thenReturn(order).getMock();

        Assert.assertEquals(order, mockedPackage.getOrder());
    }
}
