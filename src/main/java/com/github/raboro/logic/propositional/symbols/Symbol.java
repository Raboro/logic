package com.github.raboro.logic.propositional.symbols;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public abstract class Symbol {

    public final String SYMBOL;
    public final int LENGTH;
    private final boolean[] values;

    Symbol(String symbol, boolean... values) {
        SYMBOL = symbol;
        LENGTH = values.length;
        this.values = values;
    }

    public abstract boolean value();

    public abstract boolean valueEquals(String reference);

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            result.append(values[i]).append(" ");
            if (i != values.length - 1)
                result.append(SYMBOL).append(" ");
        }
        return result.toString();
    }
}