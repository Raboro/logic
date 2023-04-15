package com.github.raboro.logic.propositional.exception;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class NoBinaryInputException extends RuntimeException {

    /**
     * @param invalidCharacter characters, which are not valid
     */
    public NoBinaryInputException(char invalidCharacter) {
        super(String.format("Given value: %s, is not in binary (0|1)", invalidCharacter));
    }
}
