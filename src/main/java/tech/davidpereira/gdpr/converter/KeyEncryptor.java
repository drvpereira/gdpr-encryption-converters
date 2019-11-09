package tech.davidpereira.gdpr.converter;

import javax.persistence.Converter;

@Converter
public class KeyEncryptor extends StringEncryptor {

	@Override
	public String convertToDatabaseColumn(String attribute) {
		return encrypt(dataToString(attribute), false);
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		return dataFromString(decrypt(dbData, false));
	}

}