package tech.davidpereira.gdpr.converter;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class LocalDateEncryptorTest {

    private LocalDateEncryptor localDateEncryptor;

    @Before
    public void setUp() {
        localDateEncryptor = new LocalDateEncryptor();
    }

    @Test
    public void testDataFromStringWithNullParameter() {
        final String data = null;
        final LocalDate expectedResult = null;

        final LocalDate result = localDateEncryptor.dataFromString(data);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testDataFromStringWithInvalidParameter() {
        final String data = "test";
        final LocalDate expectedResult = null;

        final LocalDate result = localDateEncryptor.dataFromString(data);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testDataFromStringWithValidParameter() {
        final String data = "2019-10-24";
        final LocalDate expectedResult = LocalDate.of(2019, 10, 24);

        final LocalDate result = localDateEncryptor.dataFromString(data);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testDataToStringWithNullParameter() {
        final LocalDate data = null;
        final String expectedResult = null;

        final String result = localDateEncryptor.dataToString(data);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testDataToStringWithValidParameter() {
        final LocalDate data = LocalDate.of(2019,10, 24);
        final String expectedResult = "2019-10-24";

        final String result = localDateEncryptor.dataToString(data);

        assertEquals(expectedResult, result);
    }
}
