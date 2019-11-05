package tech.davidpereira.gdpr.converter;

import tech.davidpereira.gdpr.exception.DecryptionException;
import tech.davidpereira.gdpr.exception.EncryptionException;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.encrypt.BytesEncryptor;

import javax.persistence.AttributeConverter;

public abstract class EncryptionConverter<T> implements AttributeConverter<T, String> {

    @Autowired @Qualifier("randomIv")
    private BytesEncryptor bytesEncryptor;

    @Autowired @Qualifier("fixedIv")
    private BytesEncryptor keyEncryptor;

    @Override
    public String convertToDatabaseColumn(T attribute) {
        return encrypt(dataToString(attribute), true);
    }

    @Override
    public T convertToEntityAttribute(String dbData) {
        return dataFromString(decrypt(dbData, true));
    }

    abstract T dataFromString(String data);

    abstract String dataToString(T attribute);

    protected String encrypt(String attributeString, boolean randomIv) {
        if (attributeString == null)
            return null;

        try {
            if (randomIv) {
                return Base64.toBase64String(bytesEncryptor.encrypt(attributeString.getBytes()));
            } else {
                return Base64.toBase64String(keyEncryptor.encrypt(attributeString.getBytes()));
            }
        } catch (Exception e) {
            throw new EncryptionException(e.getMessage(), e);
        }
    }

    protected String decrypt(String attributeString, boolean randomIv) {
        if (attributeString == null)
            return null;

        try {
            if (randomIv) {
                return new String(bytesEncryptor.decrypt(Base64.decode(attributeString)));
            } else {
                return new String(keyEncryptor.decrypt(Base64.decode(attributeString)));
            }
        } catch (Exception e) {
            throw new DecryptionException(e.getMessage(), e);
        }
    }

}
