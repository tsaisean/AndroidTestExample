package com.example.sean.androidtestexample.mockito;

import com.example.sean.androidtestexample.Customer;
import com.example.sean.androidtestexample.Order;
import com.example.sean.androidtestexample.Package;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_23 {

    @Mock
    private Customer mockedCustomer;

    @Spy
    private Order spiedOrder = new Order(2, mockedCustomer);

    @InjectMocks
    private Package mockedPackage;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Similar to test case 21.
     */
    @Test
    public void test23_automaticInstantiationOfSpies_InjectMocks() {
        Assert.assertEquals(spiedOrder, mockedPackage.getOrder());
        Assert.assertEquals("BOX", mockedPackage.getType());
    }
}
