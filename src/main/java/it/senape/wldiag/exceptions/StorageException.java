package it.senape.wldiag.exceptions;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}