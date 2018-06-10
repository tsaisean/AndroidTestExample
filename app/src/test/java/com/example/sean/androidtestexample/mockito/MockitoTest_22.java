package com.example.sean.androidtestexample.mockito;

import com.example.sean.androidtestexample.Customer;
import com.example.sean.androidtestexample.Order;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest_22 {

    @Mock
    private Customer mockedCustomer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * This feature should be used rarely - figure out a better way of testing your multi-threaded system.
     */
    @Test
    public void test22_verificationWithTimeout() {
        Order order = new Order(1, mockedCustomer);

        order.getCustomerLevelAsync(200);

        // This will failed the test.
        // verify(mockedCustomer, timeout(100)).getLevel();

        verify(mockedCustomer, timeout(300)).getLevel();
    }
}
