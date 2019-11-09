package tech.davidpereira.gdpr.converter;

import javax.persistence.Converter;

@Converter
public class StringEncryptor extends EncryptionConverter<String> {

	@Override
	public String dataFromString(String data) {
		return data;
	}

	@Override
	public String dataToString(String attr) {
		return attr;
	}

}