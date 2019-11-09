package tech.davidpereira.gdpr.configuration;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author Raphael Medeiros (raphael.medeiros@gmail.com)
 * @since 09/11/2019
 */
@Data
@Component
@Primary
@ConfigurationProperties(prefix = "gdpr.database.encryption")
public class EncryptionProperties {

	// gdpr.database.encryption.password
	private String password;

	// gdpr.database.encryption.salt
	private String salt;

	// gdpr.database.encryption.iv
	private String iv;

}
