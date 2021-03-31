package org.campus02.fileloader;

public class GenericFileLoadException extends Exception {

    public GenericFileLoadException() {
    }

    public GenericFileLoadException(String message) {
        super(message);
    }

    public GenericFileLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericFileLoadException(Throwable cause) {
        super(cause);
    }

    public GenericFileLoadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
