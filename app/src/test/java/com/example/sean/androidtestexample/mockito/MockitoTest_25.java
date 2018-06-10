package com.example.sean.androidtestexample.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.verification.NoInteractionsWanted;

import java.util.List;

import static org.mockito.Mockito.ignoreStubs;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by Sean on 2017/9/18.
 */


/**
 * 25. Verification ignoring stubs (Since 1.9.0) <p>
 *
 * See <a href="https://static.javadoc.io/org.mockito/mockito-core/2.18.3/org/mockito/Mockito.html#ignore_stubs_verification">Verification ignoring stubs</a>
 */
public class MockitoTest_25 {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test25_verificationIgnoringStubs () {
        //mocking lists for the sake of the example (if you mock List in real you will burn in hell)
        List mock1 = mock(List.class), mock2 = mock(List.class);

        //stubbing mocks:
        when(mock1.get(0)).thenReturn(10);
        when(mock2.get(0)).thenReturn(20);

        //using mocks by calling stubbed get(0) methods:
        System.out.println(mock1.get(0)); //prints 10
        System.out.println(mock2.get(0)); //prints 20

        //using mocks by calling clear() methods:
        mock1.clear();
        mock2.clear();

        //verification:
        verify(mock1).clear();
        verify(mock2).clear();

        //verifyNoMoreInteractions() fails because get() methods were not accounted for.
        try {
            verifyNoMoreInteractions(mock1, mock2);
        } catch (NoInteractionsWanted e) {
            System.out.println(e);
        }

        //However, if we ignore stubbed methods then we can verifyNoMoreInteractions()
        verifyNoMoreInteractions(ignoreStubs(mock1, mock2));

        //Remember that ignoreStubs() *changes* the input mocks and returns them for convenience.
    }
}
