package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.NoBinaryInputException;
import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;
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
        if (notEnoughValues(values)) {
            throw new NotEnoughInputValuesException(values.length);
        }
        this.symbol = symbol;
        length = values.length;
        this.values = values;
    }

    protected static boolean notEnoughValues(boolean[] values) {
        return values.length < 2;
    }

    protected static boolean notEnoughValues(String values) {
        return values.length() < 2;
    }

    /**
     * @return evaluates the result of the given inputs with the symbol
     */
    public abstract boolean value();

    /**
     * @param values
     * are the input arguments (booleans) for the evaluation of the symbol
     * @return evaluates the result of <b>values</b> with the symbol
     */
    public abstract boolean valueOf(boolean... values);

    /**
     * @param reference
     * is the input argument for the evaluation of the symbol. The String contains a binary representation of the input
     * <br>
     * (e.g. 011 -> false, true, true)
     * <br>
     * (false -> 0; true -> 1)
     * @return evaluates the result of <b>reference</b> with the symbol
     */
    public abstract boolean valueOf(String reference);

    /**
     * @param reference
     * is the input argument for the evaluation of the symbol. The String contains a binary representation of the input
     * <br>
     * (e.g. 011 -> false, true, true)
     * <br>
     * (false -> 0; true -> 1)
     * @return <b>true</b> if result of the given input <b>reference</b> is the same as the already passed input in the constructor of the symbol,
     * else <b>false</b>
     */
    public abstract boolean valueEquals(String reference);

    /**
     * @param reference
     * are the input arguments (booleans) for the evaluation of the symbol
     * <br>
     * reference needs to have the same size as the given input have
     * @return <b>true</b> if result of the given input <b>reference</b> is the same as the already passed input in the constructor of the symbol,
     * else <b>false</b>
     */
    public abstract boolean valueEquals(boolean... reference);

    protected boolean[] constructReference(String reference) {
        validateReference(reference);
        final boolean[] referenceValues = new boolean[reference.length()];
        for (int i = 0; i < reference.length(); i++) {
            referenceValues[i] = reference.charAt(i) != '0';
        }
        return referenceValues;
    }

    private void validateReference(String reference) {
        for (char c : reference.toCharArray()) {
            if (notInBinary(c)) {
                throw new NoBinaryInputException(c);
            }
        }
    }

    private boolean notInBinary(char c) {
        return c != '0' && c != '1';
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
                .collect(Collectors.joining())
                .strip();
    }

    private boolean lastValue(int i) {
        return i == values.length - 1;
    }
}