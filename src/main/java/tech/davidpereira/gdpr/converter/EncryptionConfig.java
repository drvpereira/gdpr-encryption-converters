package tech.davidpereira.gdpr.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.BouncyCastleAesCbcBytesEncryptor;
import org.springframework.security.crypto.encrypt.BytesEncryptor;

@Configuration
public class EncryptionConfig {

    @Value("${gdpr.database.encryption.password}")
    private String databaseEncryptionPassword;

    @Value("${gdpr.database.encryption.salt}")
    private String databaseEncryptionSalt;

    @Value("${gdpr.database.encryption.iv}")
    private String databaseEncryptionIv;

    @Bean @Qualifier("randomIv")
    public BytesEncryptor bytesEncryptor() {
        return new BouncyCastleAesCbcBytesEncryptor(databaseEncryptionPassword, databaseEncryptionSalt);
    }

    @Bean @Qualifier("fixedIv")
    public BytesEncryptor keyEncryptor() {
        return new BouncyCastleAesCbcBytesEncryptor(databaseEncryptionPassword, databaseEncryptionSalt, new FixedIvGenerator(databaseEncryptionIv));
    }

}
