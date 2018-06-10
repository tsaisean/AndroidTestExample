package com.example.sean.androidtestexample.mockito;

import com.example.sean.androidtestexample.Person;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Sean on 2017/9/18.
 */

/**
 * 30. Spying or mocking abstract classes (Since 1.10.12, further enhanced in 2.7.13 and 2.7.14) <p>
 *
 * See <a href="https://static.javadoc.io/org.mockito/mockito-core/2.18.3/org/mockito/Mockito.html#spying_abstract_classes">Spying or mocking abstract classes</a>
 */
public class MockitoTest_30 {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test30_mockAbstractClasses () {
        Person person = mock(Person.class);

        when(person.getName()).thenReturn("Sean");

        Assert.assertSame("Sean", person.getName());
    }
}
