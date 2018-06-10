package com.example.sean.androidtestexample.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

/**
 * Created by Sean on 2017/9/18.
 */


/**
 * 27. Delegate calls to real instance (Since 1.9.5) <p>
 *
 * See <a href="https://static.javadoc.io/org.mockito/mockito-core/2.18.3/org/mockito/Mockito.html#delegating_call_to_real_instance">Delegate calls to real instance</a>
 */
public class MockitoTest_27 {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test27_delegateCallsToRealInstance () {
        /**
         * Useful for spies or partial mocks of objects that are difficult to mock or spy using the usual spy API. Possible use cases:
         * Final classes but with an interface
         * Already custom proxied object
         * Special objects with a finalize method, i.e. to avoid executing it 2 times
         */

        // Mockito2 now support mock final classes so this become quite useless now.
    }
}
