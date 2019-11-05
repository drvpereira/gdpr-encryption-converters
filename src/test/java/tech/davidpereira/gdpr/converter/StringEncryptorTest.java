package tech.davidpereira.gdpr.converter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringEncryptorTest {

    private StringEncryptor stringEncryptor;

    @Before
    public void setUp() {
        stringEncryptor = new StringEncryptor();
    }

    @Test
    public void testDataFromStringWithNullParameter() {
        final String data = null;
        final String expectedResult = null;

        final String result = stringEncryptor.dataFromString(data);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testDataFromStringWithValidParameter() {
        final String data = "1a";
        final String expectedResult = "1a";

        final String result = stringEncryptor.dataFromString(data);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testDataToStringWithNullParameter() {
        final String data = null;
        final String expectedResult = null;

        final String result = stringEncryptor.dataToString(data);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testDataToStringWithValidParameter() {
        final String data = "1a";
        final String expectedResult = "1a";

        final String result = stringEncryptor.dataToString(data);

        assertEquals(expectedResult, result);
    }

}
