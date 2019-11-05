package tech.davidpereira.gdpr.converter;

import javax.persistence.Converter;

@Converter
public class IntegerEncryptor extends EncryptionConverter<Integer> {

    @Override
    public Integer dataFromString(String data) {
        if (data == null)
            return null;

        try {
            return Integer.valueOf(data);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String dataToString(Integer attr) {
        if (attr == null)
            return null;
        return attr.toString();
    }

}