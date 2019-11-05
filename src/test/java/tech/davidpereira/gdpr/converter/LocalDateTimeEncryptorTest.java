package tech.davidpereira.gdpr.converter;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class LocalDateTimeEncryptorTest {

    private LocalDateTimeEncryptor localDateTimeEncryptor;

    @Before
    public void setUp() {
        localDateTimeEncryptor = new LocalDateTimeEncryptor();
    }

    @Test
    public void testDataFromStringWithNullParameter() {
        final String data = null;
        final LocalDateTime expectedResult = null;

        final LocalDateTime result = localDateTimeEncryptor.dataFromString(data);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testDataFromStringWithInvalidParameter() {
        final String data = "test";
        final LocalDateTime expectedResult = null;

        final LocalDateTime result = localDateTimeEncryptor.dataFromString(data);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testDataFromStringWithValidParameter() {
        final String data = "2019-10-24T15:35:25";
        final LocalDateTime expectedResult = LocalDateTime.of(2019, 10, 24, 15, 35, 25);

        final LocalDateTime result = localDateTimeEncryptor.dataFromString(data);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testDataToStringWithNullParameter() {
        final LocalDateTime data = null;
        final String expectedResult = null;

        final String result = localDateTimeEncryptor.dataToString(data);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testDataToStringWithValidParameter() {
        final LocalDateTime data = LocalDateTime.of(2019,10, 24, 15, 35, 25);
        final String expectedResult = "2019-10-24T15:35:25";

        final String result = localDateTimeEncryptor.dataToString(data);

        assertEquals(expectedResult, result);
    }

}
