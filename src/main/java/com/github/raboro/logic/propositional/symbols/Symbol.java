package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.utils.TruthTable;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public abstract class Symbol {

    public final String symbol;
    public final int length;
    protected final boolean[] values;

    Symbol(String symbol, boolean... values) {
        this.symbol = symbol;
        length = values.length;
        this.values = values;
    }

    public abstract boolean value();

    public abstract boolean valueOf(boolean... values);

    public abstract boolean valueOf(String reference);
    public abstract boolean valueEquals(String reference);

    public abstract boolean valueEquals(boolean... reference);

    protected boolean[] constructReference(String reference) {
        final boolean[] referenceValues = new boolean[reference.length()];
        for (int i = 0; i < reference.length(); i++) {
            referenceValues[i] = reference.charAt(i) != '0';
        }
        return referenceValues;
    }

    protected boolean[] constructParameters(int variableCounter) {
        final boolean[] variables = new boolean[variableCounter];
        Arrays.fill(variables, true);
        return variables;
    }

    protected void baseTruthTable(Symbol symbol) {
        final TruthTable truthTable = new TruthTable(symbol);
        truthTable.print();
    }

    @Override
    public String toString() {
        return IntStream.range(0, values.length)
                .mapToObj(i -> values[i] + " " + (lastValue(i) ? "" : symbol) + " ")
                .collect(Collectors.joining());
    }

    private boolean lastValue(int i) {
        return i == values.length - 1;
    }
}