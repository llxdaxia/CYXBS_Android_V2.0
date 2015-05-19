package com.mredrock.cyxbs.data.exception;

/**
 * Exception throw by the application when a User search can't return a valid result.
 * <p>
 * Created by David on 15/5/18.
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super();
    }

    public NotFoundException(final String message) {
        super(message);
    }

    public NotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(final Throwable cause) {
        super(cause);
    }
}
