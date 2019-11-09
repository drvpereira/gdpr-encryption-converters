package tech.davidpereira.gdpr.converter;

import javax.persistence.Converter;
import java.math.BigDecimal;

@Converter
public class BigDecimalEncryptor extends EncryptionConverter<BigDecimal> {

	@Override
	public BigDecimal dataFromString(String data) {
		if (data == null)
			return null;

		try {
			return new BigDecimal(data);
		}
		catch (NumberFormatException e) {
			return null;
		}
	}

	@Override
	public String dataToString(BigDecimal attr) {
		if (attr == null)
			return null;
		return attr.toString();
	}

}