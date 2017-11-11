package com.example.sean.androidtestexample.mockito;

import com.example.sean.androidtestexample.Customer;
import com.example.sean.androidtestexample.Order;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.verifyNoMoreInteractions;

/**
 * Created by Sean on 2017/9/18.
 */

public class MockitoTest {
    @Mock
    private List annotationMockedList;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test1_verify() {
        //mock creation
        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.clear();

        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test (expected = RuntimeException.class)
    public void test2_stub() {
        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //following prints "first"
        System.out.println(mockedList.get(0));

        //following throws runtime exception
        System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
        verify(mockedList).get(0);
    }

    @Test
    public void test3_argumentMatchers() {
        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");

        //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
        // when(mockedList.contains(argThat(isValid()))).thenReturn("element");

        //following prints "element"
        System.out.println(mockedList.get(999));

        //you can also verify using an argument matcher
        verify(mockedList).get(anyInt());

        //argument matchers can also be written as Java 8 Lambdas
        // verify(mockedList).add(argThat(someString -> someString.length() > 5));
    }

    @Test
    public void test4_verifyingExactNumberOfInvocations() {
        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        //using mock
        mockedList.add("once");

        mockedList.add("twice");
        mockedList.add("twice");

        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //following two verifications work exactly the same - times(1) is used by default
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        //exact number of invocations verification
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //verification using never(). never() is an alias to times(0)
        verify(mockedList, never()).add("never happened");

        //verification using atLeast()/atMost()
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
        verify(mockedList, atMost(5)).add("three times");
    }


    @Test (expected = RuntimeException.class)
    public void test5_stubbingVoidMethodsWithExceptions() {
        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        doThrow(new RuntimeException()).when(mockedList).clear();

        //following throws RuntimeException:
        mockedList.clear();
    }

    @Test
    public void test6_verificationInOrder() {
        // A. Single mock whose methods must be invoked in a particular order
        List singleMock = mock(List.class);

        //using a single mock
        singleMock.add("was added first");
        singleMock.add("was added second");

        //create an inOrder verifier for a single mock
        InOrder inOrder = inOrder(singleMock);

        //following will make sure that add is first called with "was added first, then with "was added second"
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        // B. Multiple mocks that must be used in a particular order
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //using mocks
        firstMock.add("was called first");
        secondMock.add("was called second");

        //create inOrder object passing any mocks that need to be verified in order
        InOrder inOrder2 = inOrder(firstMock, secondMock);

        //following will make sure that firstMock was called before secondMock
        inOrder2.verify(firstMock).add("was called first");
        inOrder2.verify(secondMock).add("was called second");

        // Oh, and A + B can be mixed together at will
    }

    @Test
    public void test7_zeroInteractions() {
        List mockedListA = mock(List.class);
        List mockedListB = mock(List.class);

        mockedListA.add("one");

        verifyZeroInteractions(mockedListB);
    }

    @Test
    public void test8_zeroInteractions() {
        List mockedListA = mock(List.class);
        mockedListA.add("one");
        mockedListA.add("two");

        verify(mockedListA).add("one");

        //following verification will fail
        verifyNoMoreInteractions(mockedListA);
    }

    @Test
    public void test9_mockAnnotation() {
        // We put MockitoAnnotations.initMocks(this) in setUp().

        annotationMockedList.add("one");
        verify(annotationMockedList).add("one");
    }

    @Test
    public void test10_stubbingConsecutiveCalls () {
        when(annotationMockedList.add("some"))
                .thenReturn(true)
                .thenReturn(false);

        Assert.assertEquals(true, annotationMockedList.add("some"));
        Assert.assertEquals(false, annotationMockedList.add("some"));
        Assert.assertEquals(false, annotationMockedList.add("some"));
    }

    @Test
    public void test11_stubbingWithCallbacks() {
        when(annotationMockedList.add(1)).thenAnswer(new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                return true;
            }
        });

        Assert.assertEquals(true, annotationMockedList.add(1));
        Assert.assertEquals(false, annotationMockedList.add(2));
        Assert.assertEquals(false, annotationMockedList.add("some"));
    }

    @Test
    public void test12_stubbingVoidMethods() {
        List spiedList = spy(new LinkedList());

        //let's make clear() do nothing
        Mockito.doNothing().when(spiedList).clear();

        spiedList.add("one");

        //clear() does nothing, so the list still contains "one"
        spiedList.clear();

        Assert.assertEquals(1, spiedList.size());


        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                ((List)invocationOnMock.getMock()).add(1);
                ((List)invocationOnMock.getMock()).add(2);
                return null;
            }
        }).when(spiedList).clear();

        spiedList.clear();

        Assert.assertEquals(3, spiedList.size());
    }

    @Test
    public void test13_spy() {
        List list = new LinkedList();
        List spy = spy(list);

        //optionally, you can stub out some methods:
        when(spy.size()).thenReturn(100);

        //using the spy calls *real* methods
        spy.add("one");
        spy.add("two");

        //prints "one" - the first element of a list
        System.out.println(spy.get(0));

        //size() method was stubbed - 100 is printed
        System.out.println(spy.size());

        //optionally, you can verify
        verify(spy).add("one");
        verify(spy).add("two");
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

    @Test
    public void test16_capturingArguments () {
        Order order = mock(Order.class);
        when(order.getDefaultVipDiscount()).thenCallRealMethod();

        Assert.assertEquals(0.8f, order.getDefaultVipDiscount());
    }

    @Test
    public void test17_resettingMocks () {
        when(annotationMockedList.size()).thenReturn(10);

        reset(annotationMockedList);

        Assert.assertEquals(0, annotationMockedList.size());
    }

    @Test
    public void test18_validateMockitoUsage() {
        // https://static.javadoc.io/org.mockito/mockito-core/2.11.0/org/mockito/Mockito.html#framework_validation
    }

}
