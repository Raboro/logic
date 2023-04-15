package com.github.raboro.logic.propositional.exception;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class ValueNotSameSizeException extends RuntimeException {

    /**
     * @param message which should be the error message
     */
    public ValueNotSameSizeException(String message) {
        super(message);
    }
}
