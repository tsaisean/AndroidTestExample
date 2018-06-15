package com.example.sean.androidtestexample.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

/**
 * Created by Sean on 2017/9/18.
 */

/**
 * 31. Mockito mocks can be serialized / deserialized across classloaders (Since 1.10.0) <p>
 *
 * See <a href="https://static.javadoc.io/org.mockito/mockito-core/2.18.3/org/mockito/Mockito.html#serilization_across_classloader">Mockito mocks can be serialized / deserialized across classloaders (Since 1.10.0)</a>
 */
public class MockitoTest_31 {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test31_mockSerialized () {
//        // use regular serialization
//        mock(Book.class, withSettings().serializable());
//
//        // use serialization across classloaders
//        mock(Book.class, withSettings().serializable(ACROSS_CLASSLOADERS));
    }
}
