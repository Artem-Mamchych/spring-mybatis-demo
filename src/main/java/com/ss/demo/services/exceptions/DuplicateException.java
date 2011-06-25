package com.ss.demo.services.exceptions;

/**
 * Exception for cases when something already exists in system
 * and not allowed to have duplicate.
 *
 * @see Exception
 */
public class DuplicateException extends Exception {

    /**
     * Default constructor.
     *
     * {@link Exception}
     */
    public DuplicateException() {
    }

    /**
     * Create exception with specific message.
     *
     * @param message exception message
     */
    public DuplicateException(String message) {
        super(message);
    }
}
