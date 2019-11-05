package tech.davidpereira.gdpr.converter;

import tech.davidpereira.gdpr.exception.DecryptionException;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.encrypt.BouncyCastleAesCbcBytesEncryptor;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;

public class KeyEncryptorTest {

    private KeyEncryptor keyEncryptor;

    @Before
    public void setUp() {
        keyEncryptor = new KeyEncryptor();
        ReflectionTestUtils.setField(keyEncryptor, "keyEncryptor", new BouncyCastleAesCbcBytesEncryptor(Hex.toHexString("9G0XgFO$*dUu".getBytes()), Hex.toHexString("6AzoOXB#qA1L".getBytes()), new FixedIvGenerator("q4oED0a11SWeDV4XrHzfBQ==")));
    }

    @Test
    public void testConvertToDatabaseColumnWithNullData() {
        final String data = null;
        final String expectedResult = null;

        final String result = keyEncryptor.convertToDatabaseColumn(data);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testConvertToEntityAttributeWithNullData() {
        final String data = null;
        final String expectedResult = null;

        final String result = keyEncryptor.convertToEntityAttribute(data);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testEncryptionAlwaysSame() {
        final String data = "test";

        final String encrypted1 = keyEncryptor.convertToDatabaseColumn(data);
        final String encrypted2 = keyEncryptor.convertToDatabaseColumn(data);

        assertEquals(encrypted1, encrypted2);
    }

    @Test
    public void testEncryptionAndDecryptionWithValidData() {
        final String data = "test";
        final String expectedResult = "test";

        final String encrypted = keyEncryptor.convertToDatabaseColumn(data);
        final String result = keyEncryptor.convertToEntityAttribute(encrypted);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testEncryptionAndDecryptionWithEmptyString() {
        final String data = "";
        final String expectedResult = "";

        final String encrypted = keyEncryptor.convertToDatabaseColumn(data);
        final String result = keyEncryptor.convertToEntityAttribute(encrypted);

        assertEquals(expectedResult, result);
    }

    @Test
    public void testEncryptionAndDecryptionWithLongValidData() {
        final String data = "Interdum et malesuada fames ac ante ipsum primis in faucibus. Aliquam tempor interdum ex id malesuada. Morbi eget urna ullamcorper, finibus enim at, congue libero.";
        final String expectedResult = "Interdum et malesuada fames ac ante ipsum primis in faucibus. Aliquam tempor interdum ex id malesuada. Morbi eget urna ullamcorper, finibus enim at, congue libero.";

        final String encrypted = keyEncryptor.convertToDatabaseColumn(data);
        System.out.println(encrypted);
        final String result = keyEncryptor.convertToEntityAttribute(encrypted);

        assertEquals(expectedResult, result);
    }

    @Test(expected = DecryptionException.class)
    public void testDecryptionWithInvalidData() {
        final String data = "test";
        keyEncryptor.convertToEntityAttribute(data);
    }
}
