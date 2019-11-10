package tech.davidpereira.gdpr.converter;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class BigDecimalEncryptorTest {

	private BigDecimalEncryptor bigDecimalEncryptor;

	@Before
	public void setUp() {
		bigDecimalEncryptor = new BigDecimalEncryptor();
	}

	@Test
	public void testDataFromStringWithNullParameter() {
		final String data = null;
		final BigDecimal expectedResult = null;

		final BigDecimal result = bigDecimalEncryptor.dataFromString(data);

		assertEquals(expectedResult, result);
	}

	@Test
	public void testDataFromStringWithInvalidParameter() {
		final String data = "test";
		final BigDecimal expectedResult = null;

		final BigDecimal result = bigDecimalEncryptor.dataFromString(data);

		assertEquals(expectedResult, result);
	}

	@Test
	public void testDataFromStringWithValidParameter() {
		final String data = "1.0";
		final BigDecimal expectedResult = new BigDecimal("1.0");

		final BigDecimal result = bigDecimalEncryptor.dataFromString(data);

		assertEquals(expectedResult, result);
	}

	@Test
	public void testDataToStringWithNullParameter() {
		final BigDecimal data = null;
		final String expectedResult = null;

		final String result = bigDecimalEncryptor.dataToString(data);

		assertEquals(expectedResult, result);
	}

	@Test
	public void testDataToStringWithValidParameter() {
		final BigDecimal data = new BigDecimal("1.0");
		final String expectedResult = "1.0";

		final String result = bigDecimalEncryptor.dataToString(data);

		assertEquals(expectedResult, result);
	}

}
