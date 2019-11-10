package tech.davidpereira.gdpr.converter;

import static org.junit.Assert.assertEquals;

import org.bouncycastle.util.encoders.Hex;
import org.junit.Before;
import org.junit.Test;
import tech.davidpereira.gdpr.exception.DecryptionException;

import org.springframework.security.crypto.encrypt.BouncyCastleAesCbcBytesEncryptor;
import org.springframework.test.util.ReflectionTestUtils;

public class EncryptionConverterTest {

	private StringEncryptor stringEncryptor;

	@Before
	public void setUp() {
		stringEncryptor = new StringEncryptor();
		ReflectionTestUtils.setField(stringEncryptor, "bytesEncryptor", new BouncyCastleAesCbcBytesEncryptor(
				Hex.toHexString("9G0XgFO$*dUu".getBytes()), Hex.toHexString("6AzoOXB#qA1L".getBytes())));
	}

	@Test
	public void testConvertToDatabaseColumnWithNullData() {
		final String data = null;
		final String expectedResult = null;

		final String result = stringEncryptor.convertToDatabaseColumn(data);

		assertEquals(expectedResult, result);
	}

	@Test
	public void testConvertToEntityAttributeWithNullData() {
		final String data = null;
		final String expectedResult = null;

		final String result = stringEncryptor.convertToEntityAttribute(data);

		assertEquals(expectedResult, result);
	}

	@Test
	public void testEncryptionAndDecryptionWithValidData() {
		final String data = "test";
		final String expectedResult = "test";

		final String encrypted = stringEncryptor.convertToDatabaseColumn(data);
		final String result = stringEncryptor.convertToEntityAttribute(encrypted);

		assertEquals(expectedResult, result);
	}

	@Test
	public void testEncryptionAndDecryptionWithEmptyString() {
		final String data = "";
		final String expectedResult = "";

		final String encrypted = stringEncryptor.convertToDatabaseColumn(data);
		final String result = stringEncryptor.convertToEntityAttribute(encrypted);

		assertEquals(expectedResult, result);
	}

	@Test
	public void testEncryptionAndDecryptionWithLongValidData() {
		final String data = "Interdum et malesuada fames ac ante ipsum primis in faucibus. Aliquam tempor interdum ex id malesuada. Morbi eget urna ullamcorper, finibus enim at, congue libero.";
		final String expectedResult = "Interdum et malesuada fames ac ante ipsum primis in faucibus. Aliquam tempor interdum ex id malesuada. Morbi eget urna ullamcorper, finibus enim at, congue libero.";

		final String encrypted = stringEncryptor.convertToDatabaseColumn(data);
		System.out.println(encrypted);
		final String result = stringEncryptor.convertToEntityAttribute(encrypted);

		assertEquals(expectedResult, result);
	}

	@Test(expected = DecryptionException.class)
	public void testDecryptionWithInvalidData() {
		final String data = "test";
		stringEncryptor.convertToEntityAttribute(data);
	}

}
