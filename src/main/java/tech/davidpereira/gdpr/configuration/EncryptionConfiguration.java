package tech.davidpereira.gdpr.configuration;

import org.bouncycastle.util.encoders.Hex;
import tech.davidpereira.gdpr.converter.FixedIvGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.encrypt.BouncyCastleAesCbcBytesEncryptor;
import org.springframework.security.crypto.encrypt.BytesEncryptor;

@Configuration
@PropertySource("classpath:/application.properties")
@EnableConfigurationProperties({ EncryptionProperties.class })
public class EncryptionConfiguration {

	private final EncryptionProperties properties;

	@Autowired
	public EncryptionConfiguration(EncryptionProperties properties) {
		this.properties = properties;
	}

	@Bean
	@Qualifier("randomIv")
	public BytesEncryptor bytesEncryptor() {
		return new BouncyCastleAesCbcBytesEncryptor(Hex.toHexString(properties.getPassword().getBytes()),
				Hex.toHexString(properties.getSalt().getBytes()));
	}

	@Bean
	@Qualifier("fixedIv")
	public BytesEncryptor keyEncryptor() {
		return new BouncyCastleAesCbcBytesEncryptor(Hex.toHexString(properties.getPassword().getBytes()),
				Hex.toHexString(properties.getSalt().getBytes()), new FixedIvGenerator(properties.getIv()));
	}

}
