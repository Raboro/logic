package com.github.raboro.logic.propositional.exception;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class NoBinaryInputException extends RuntimeException {

    public NoBinaryInputException() {
        this("Input is not in binary");
    }

    public NoBinaryInputException(String message) {
        super(message);
    }

    public NoBinaryInputException(char invalidCharacter) {
        super(String.format("Given value: %s, is not in binary (0|1)", invalidCharacter));
    }
}
