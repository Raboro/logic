package com.github.raboro.logic.propositional.symbols;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public abstract class Symbol {

    public final String SYMBOL;

    Symbol(String symbol) {
        SYMBOL = symbol;
    }

    public abstract boolean value();
}