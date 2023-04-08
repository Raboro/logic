package com.github.raboro.logic.propositional.exception;

public class NotEnoughInputValuesException extends RuntimeException{

    public NotEnoughInputValuesException() {
        super("Not enough input values", new Throwable());
    }

    public NotEnoughInputValuesException(String message) {
        super(message, new Throwable());
    }

    public NotEnoughInputValuesException(int values) {
        super(String.format("Given values: %s, are not enough, minimum are 2", values), new Throwable());
    }

    public NotEnoughInputValuesException(String message, Throwable err) {
        super(message, err);
    }
}
