package com.example.sean.androidtestexample.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.description;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Sean on 2017/9/18.
 */

/**
 * 35. Custom verification failure message (Since 2.1.0) <p>
 *
 * See <a href="https://static.javadoc.io/org.mockito/mockito-core/2.18.3/org/mockito/Mockito.html#plugin_switch">Custom verification failure message</a>
 */
public class MockitoTest_35 {

    @Mock
    private List annotationMockedList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test35_mockAbstractClasses () {
        annotationMockedList.add("one");

        // will print a custom message on verification failure
        verify(annotationMockedList, description("This will print on failure")).remove(any());

        // will work with any verification mode
        verify(annotationMockedList, times(2).description("someMethod should be called twice")).add(any());
    }
}
