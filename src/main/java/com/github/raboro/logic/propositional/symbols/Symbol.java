package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.utils.TruthTable;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    protected boolean[] constructParameters(int variableCounter) {
        final boolean[] variables = new boolean[variableCounter];
        for (int i = 0; i < variableCounter; i++) {
            variables[i] = true;
        }
        return variables;
    }

    protected void baseTruthTable(Symbol symbol) {
        final TruthTable truthTable = new TruthTable(symbol);
        truthTable.print();
    }

    @Override
    public String toString() {
        return IntStream.range(0, values.length)
                .mapToObj(i -> values[i] + " " + (lastValue(i) ? "" : SYMBOL) + " ")
                .collect(Collectors.joining());
    }

    private boolean lastValue(int i) {
        return i == values.length - 1;
    }
}