package com.github.raboro.logic.propositional.exception;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class NotEnoughInputValuesException extends RuntimeException {

    /**
     * @param values which are not enough
     */
    public NotEnoughInputValuesException(int values) {
        super(String.format("Given values: %s, are not enough, minimum are 2", values));
    }
}
