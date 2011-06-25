package com.ss.demo.services.exceptions;

/**
 * The exception for case when searching item is not exists.
 *
 */
public class NotFoundException extends RuntimeException {

    /**
     * Default constructor.
     *
     * {@link Exception}
     * @param message exception message
     */
    public NotFoundException(String message) {
        super(message);
    }

    /**
     * Create exception with specific message.
     *
     */
    public NotFoundException() {
    }
}
