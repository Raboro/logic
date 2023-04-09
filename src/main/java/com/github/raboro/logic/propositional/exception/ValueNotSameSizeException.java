package com.github.raboro.logic.propositional.exception;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class ValueNotSameSizeException extends RuntimeException {

    public ValueNotSameSizeException() {
        super("Not every value has the required size");
    }

    public ValueNotSameSizeException(String message) {
        super(message);
    }
}
