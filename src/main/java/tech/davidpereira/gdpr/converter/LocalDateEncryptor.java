package tech.davidpereira.gdpr.converter;

import static java.time.format.DateTimeFormatter.ISO_DATE;

import javax.persistence.Converter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Converter
public class LocalDateEncryptor extends EncryptionConverter<LocalDate> {

	@Override
	public LocalDate dataFromString(String data) {
		if (data == null)
			return null;

		try {
			return LocalDate.parse(data, ISO_DATE);
		}
		catch (DateTimeParseException e) {
			return null;
		}
	}

	@Override
	public String dataToString(LocalDate attr) {
		if (attr == null)
			return null;
		return attr.format(ISO_DATE);
	}

}