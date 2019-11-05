package tech.davidpereira.gdpr.converter;

import javax.persistence.Converter;

@Converter
public class LongEncryptor extends EncryptionConverter<Long> {

    @Override
    public Long dataFromString(String data) {
        if (data == null)
            return null;

        try {
            return Long.valueOf(data);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String dataToString(Long attr) {
        if (attr == null)
            return null;
        return attr.toString();
    }

}