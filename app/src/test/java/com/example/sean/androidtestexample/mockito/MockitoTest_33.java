package com.example.sean.androidtestexample.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Created by Sean on 2017/9/18.
 */

/**
 * 33. Mockito JUnit rule (Since 1.10.17) <p>
 *
 * See <a href="https://static.javadoc.io/org.mockito/mockito-core/2.18.3/org/mockito/Mockito.html#mockito_junit_rule">Mockito JUnit rule</a>
 */

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest_33 {

    @Mock
    private List annotationMockedList;

    @Before
    public void setUp() {
        // This is no need since we are using @RunWith(MockitoJUnitRunner.class).
        // MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test33_mockAbstractClasses () {
        annotationMockedList.add("one");
        verify(annotationMockedList).add("one");
    }
}
