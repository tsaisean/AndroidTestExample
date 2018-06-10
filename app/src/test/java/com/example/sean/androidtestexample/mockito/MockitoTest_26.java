package com.example.sean.androidtestexample.mockito;

import com.example.sean.androidtestexample.Customer;
import com.example.sean.androidtestexample.Order;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockingDetails;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.when;

/**
 * Created by Sean on 2017/9/18.
 */


/**
 * 26. Mocking details (Improved in 2.2.x) <p>
 *
 * See <a href="https://static.javadoc.io/org.mockito/mockito-core/2.18.3/org/mockito/Mockito.html#mocking_details">Mocking details</a>
 */
public class MockitoTest_26 {

    @Mock
    Customer customer;

    @Spy
    Order spiedOrder = new Order(1, customer);

    @Mock
    Order mockedOrder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test26_mockingDetails () {
        //To identify whether a particular object is a mock or a spy:
        System.out.println(mockingDetails(mockedOrder).isMock());
        System.out.println(mockingDetails(mockedOrder).isSpy());
        // Spy is also a mock.
        System.out.println(mockingDetails(spiedOrder).isMock());
        System.out.println(mockingDetails(spiedOrder).isSpy());

        when(mockedOrder.getTotal()).thenReturn(30f);
        when(mockedOrder.getDefaultVipDiscount()).thenReturn(10f);

        //Getting details like type to mock or default answer:
        MockingDetails details = mockingDetails(mockedOrder);
        System.out.println(details.getMockCreationSettings().getTypeToMock());
        System.out.println(details.getMockCreationSettings().getDefaultAnswer());

        //Getting interactions and stubbings of the mock:
        System.out.println(details.getInvocations());
        System.out.println();
        System.out.println(details.getStubbings());
        System.out.println();

        mockedOrder.getTotal();

        //Printing all interactions (including stubbing, unused stubs)
        System.out.println(mockingDetails(mockedOrder).printInvocations());
    }
}
