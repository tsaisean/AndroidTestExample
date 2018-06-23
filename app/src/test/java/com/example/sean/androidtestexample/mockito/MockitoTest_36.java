package com.example.sean.androidtestexample.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Sean on 2017/9/18.
 */

/**
 * 36. Java 8 Lambda Matcher Support (Since 2.1.0) <p>
 *
 * See <a href="https://static.javadoc.io/org.mockito/mockito-core/2.18.3/org/mockito/Mockito.html#mock_maker_plugin">Java 8 Lambda Matcher Support</a>
 */
public class MockitoTest_36 {

    @Mock
    private List<String> annotationMockedList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test36_java8LambdaSupport () {
        annotationMockedList.add("1");
        annotationMockedList.add("2");

        // verify a list only had strings of a certain length added to it
        // note - this will only compile under Java 8
        verify(annotationMockedList, times(2)).add(argThat(string -> string.length() < 5));

        // Java 7 equivalent - not as neat
        verify(annotationMockedList, times(2)).add(argThat(new ArgumentMatcher<String>() {
            @Override
            public boolean matches(String string) {
                return string.length() < 5;
            }
        }));
    }
}
