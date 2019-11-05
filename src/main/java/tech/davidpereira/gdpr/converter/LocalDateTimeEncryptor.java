package tech.davidpereira.gdpr.converter;

import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

@Converter
public class LocalDateTimeEncryptor extends EncryptionConverter<LocalDateTime> {

    @Override
    public LocalDateTime dataFromString(String data) {
        if (data == null)
            return null;

        try {
            return LocalDateTime.parse(data, ISO_DATE_TIME);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    @Override
    public String dataToString(LocalDateTime attr) {
        if (attr == null)
            return null;
        return attr.format(ISO_DATE_TIME);
    }

}