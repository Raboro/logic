package com.github.raboro.logic.propositional.exception;

public class NotEnoughInputValuesException extends RuntimeException {

    public NotEnoughInputValuesException() {
        this("Not enough input values");
    }

    public NotEnoughInputValuesException(String message) {
        super(message);
    }

    public NotEnoughInputValuesException(int values) {
        super(String.format("Given values: %s, are not enough, minimum are 2", values));
    }
}
