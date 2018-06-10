package com.example.sean.androidtestexample.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

/**
 * Created by Sean on 2017/9/18.
 */

/**
 * 29. BDD style verification (Since 1.10.0) <p>
 *
 * See <a href="https://static.javadoc.io/org.mockito/mockito-core/2.18.3/org/mockito/Mockito.html#BDD_behavior_verification">BDD style verification</a>
 */
public class MockitoTest_29 {
    @Mock
    List mockedList;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test29_bddStyleVerification () {
        // given
        given(mockedList.size()).willReturn(2);

        // when
        mockedList.size();

        // then
        then(mockedList).should().size();
    }
}
