package tech.davidpereira.gdpr.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LongEncryptorTest {

	private LongEncryptor longEncryptor;

	@Before
	public void setUp() {
		longEncryptor = new LongEncryptor();
	}

	@Test
	public void testDataFromStringWithNullParameter() {
		final String data = null;
		final Long expectedResult = null;

		final Long result = longEncryptor.dataFromString(data);

		assertEquals(expectedResult, result);
	}

	@Test
	public void testDataFromStringWithInvalidParameter() {
		final String data = "test";
		final Long expectedResult = null;

		final Long result = longEncryptor.dataFromString(data);

		assertEquals(expectedResult, result);
	}

	@Test
	public void testDataFromStringWithValidParameter() {
		final String data = "1";
		final Long expectedResult = 1L;

		final Long result = longEncryptor.dataFromString(data);

		assertEquals(expectedResult, result);
	}

	@Test
	public void testDataToStringWithNullParameter() {
		final Long data = null;
		final String expectedResult = null;

		final String result = longEncryptor.dataToString(data);

		assertEquals(expectedResult, result);
	}

	@Test
	public void testDataToStringWithValidParameter() {
		final Long data = 1L;
		final String expectedResult = "1";

		final String result = longEncryptor.dataToString(data);

		assertEquals(expectedResult, result);
	}

}
