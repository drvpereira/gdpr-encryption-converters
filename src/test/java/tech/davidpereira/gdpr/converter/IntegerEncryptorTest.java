package tech.davidpereira.gdpr.converter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerEncryptorTest {

    private IntegerEncryptor integerEncryptor;

    @Before
    public void setUp() {
        integerEncryptor = new IntegerEncryptor();
    }

    @Test
    public void testDataFromStringWithNullParameter() {
        final String data = null;
        final Integer expectedResult = null;

        final Integer result = integerEncryptor.dataFromString(data);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testDataFromStringWithInvalidParameter() {
        final String data = "test";
        final Integer expectedResult = null;

        final Integer result = integerEncryptor.dataFromString(data);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testDataFromStringWithValidParameter() {
        final String data = "1";
        final Integer expectedResult = 1;

        final Integer result = integerEncryptor.dataFromString(data);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testDataToStringWithNullParameter() {
        final Integer data = null;
        final String expectedResult = null;

        final String result = integerEncryptor.dataToString(data);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testDataToStringWithValidParameter() {
        final Integer data = 1;
        final String expectedResult = "1";

        final String result = integerEncryptor.dataToString(data);

        assertEquals(expectedResult, result);
    }

}
