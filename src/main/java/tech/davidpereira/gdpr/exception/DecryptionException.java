package tech.davidpereira.gdpr.exception;

public class DecryptionException extends RuntimeException {

    public DecryptionException(String errorMessage) {
        super(errorMessage);
    }

    public DecryptionException(String errorMessage, Exception e) {
        super(errorMessage, e);
    }

}
