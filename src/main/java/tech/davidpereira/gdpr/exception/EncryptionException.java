package tech.davidpereira.gdpr.exception;

public class EncryptionException extends RuntimeException {

	public EncryptionException(String errorMessage) {
		super(errorMessage);
	}

	public EncryptionException(String errorMessage, Exception e) {
		super(errorMessage, e);
	}

}
