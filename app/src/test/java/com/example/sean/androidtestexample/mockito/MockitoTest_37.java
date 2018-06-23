package com.example.sean.androidtestexample.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doAnswer;

/**
 * Created by Sean on 2017/9/18.
 */

/**
 * 37. Java 8 Custom Answer Support (Since 2.1.0) <p>
 *
 * See <a href="https://static.javadoc.io/org.mockito/mockito-core/2.18.3/org/mockito/Mockito.html#Java_8_Custom_Answers">Java 8 Custom Answer Support</a>
 */
public class MockitoTest_37 {

    @Mock
    private List annotationMockedList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test37_java8CustomAnswerSupport () {
        // answer by returning 12 every time
        doAnswer(invocation -> 12).when(annotationMockedList).get(anyInt());

        Assert.assertEquals(12, annotationMockedList.get(0));

        // Java 7 equivalent - not as neat
        doAnswer(new Answer() {
                     @Override
                     public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                         return 13;
                     }
                 }).when(annotationMockedList).get(anyInt());

        Assert.assertEquals(13, annotationMockedList.get(0));
    }
}
