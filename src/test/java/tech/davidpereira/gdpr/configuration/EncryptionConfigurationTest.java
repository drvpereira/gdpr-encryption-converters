package tech.davidpereira.gdpr.configuration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Raphael Medeiros (raphael.medeiros@gmail.com)
 * @since 09/11/2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { EncryptionConfiguration.class, EncryptionProperties.class },
		webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestPropertySource(locations = "classpath:/application.properties")
public class EncryptionConfigurationTest {

	@Autowired
	@Qualifier("randomIv")
	private BytesEncryptor bytesEncryptor;

	@Autowired
	@Qualifier("fixedIv")
	private BytesEncryptor keyEncryptor;

	@Autowired
	private EncryptionProperties properties;

	@Test
	public void getPassword() {
		Assert.assertEquals("12345", properties.getPassword());
	}

	@Test
	public void getSalt() {
		Assert.assertEquals("67890", properties.getSalt());
	}

	@Test
	public void getIv() {
		Assert.assertEquals("99", properties.getIv());
	}

	@Test
	public void bytesEncryptor() {
		Assert.assertNotNull(bytesEncryptor);
	}

	@Test
	public void keyEncryptor() {
		Assert.assertNotNull(keyEncryptor);
	}

}