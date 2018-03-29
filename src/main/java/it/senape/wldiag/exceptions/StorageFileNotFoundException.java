package it.senape.wldiag.exceptions;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
