package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.NoBinaryInputException;
import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;
import com.github.raboro.logic.propositional.exception.ValueNotSameSizeException;
import com.github.raboro.logic.propositional.utils.TruthTable;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public abstract class Symbol {

    /**
     * character which represents the symbol
     */
    public final String character;

    /**
     * the length of the input
     */
    public final int length;

    /**
     * input values
     */
    protected final boolean[] values;

    Symbol(String character, boolean... values) {
        if (notEnoughValues(values)) {
            throw new NotEnoughInputValuesException(values.length);
        }
        this.character = character;
        length = values.length;
        this.values = values;
    }

    /**
     * @param values which gets checked for length
     * @return true if the input is big enough or false
     */
    protected static boolean notEnoughValues(boolean[] values) {
        return values.length < 2;
    }

    /**
     * @return evaluates the result of the given inputs with the symbol
     */
    public abstract boolean value();

    /**
     * @param values are the input arguments (booleans) for the evaluation of the symbol
     * @return evaluates the result of <b>values</b> with the symbol
     * @throws NotEnoughInputValuesException if the number of boolean input arguments are smaller than 2
     */
    public abstract boolean valueOf(boolean... values);

    /**
     * @param reference is the input argument for the evaluation of the symbol. The String contains a binary representation of the input
     *                  <br>
     *                  (e.g. 011 -> false, true, true)
     *                  <br>
     *                  (false -> 0; true -> 1)
     * @return evaluates the result of <b>reference</b> with the symbol
     * @throws NotEnoughInputValuesException if the String input length is smaller than 2
     * @throws NoBinaryInputException        if the String input contains not only '0' and '1'
     */
    public abstract boolean valueOf(String reference);

    /**
     * @param reference is the input argument for the evaluation of the symbol. The String contains a binary representation of the input
     *                  <br>
     *                  (e.g. 011 -> false, true, true)
     *                  <br>
     *                  (false -> 0; true -> 1)
     * @return <b>true</b> if result of the given input <b>reference</b> is the same as the already passed input in the constructor of the symbol,
     * else <b>false</b>
     * @throws NotEnoughInputValuesException if the String input length is smaller than 2
     * @throws NoBinaryInputException        if the String input contains not only '1' and '0'
     * @throws ValueNotSameSizeException     if the String input is not same size as the ones given in the constructor of the symbol
     */
    public abstract boolean valueEquals(String reference);

    /**
     * @param reference are the input arguments (booleans) for the evaluation of the symbol
     *                  <br>
     *                  reference needs to have the same size as the given input have
     * @return <b>true</b> if result of the given input <b>reference</b> is the same as the already passed input in the constructor of the symbol,
     * else <b>false</b>
     * @throws NotEnoughInputValuesException if the number of boolean input arguments are smaller than 2
     * @throws ValueNotSameSizeException     if boolean input arguments are not same size as the ones given in the constructor of the symbol
     */
    public abstract boolean valueEquals(boolean... reference);

    /**
     * prints the truth table of the symbol to the console with two variables = true
     * => this leads to the base truth table of the symbol
     */
    public abstract void baseTruthTable();

    /**
     * @param variableCounter the number of variables for the truth table.
     *                        Same as baseTruthTable() but with a specific number of variables
     */
    public abstract void baseTruthTable(int variableCounter);

    /**
     * @param reference input, which gets validated for the valid size
     */
    protected void validateReferenceSize(boolean[] reference) {
        if (reference.length != values.length) {
            throw new ValueNotSameSizeException(
                    String.format("Your input (size %s) has not the same size as required %s",
                            reference.length, values.length));
        }
    }

    /**
     * @param reference input, which gets validated for the valid size
     */
    protected void validateReferenceSize(String reference) {
        if (reference.length() != values.length) {
            throw new ValueNotSameSizeException(
                    String.format("Your input (size %s) has not the same size as required %s",
                            reference.length(), values.length));
        }
    }

    /**
     * @param reference in binary gets mapped to boolean values
     * @return boolean array which is the representation of the reference binary String
     */
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

    /**
     * @param c gets checked for binary char
     * @return boolean if c is in binary true, else false
     */
    private boolean notInBinary(char c) {
        return c != '0' && c != '1';
    }

    /**
     * @param variableCounter number of variables for the truth table
     * @return variables with true as value for the truth table
     */
    protected boolean[] constructParameters(int variableCounter) {
        final boolean[] variables = new boolean[variableCounter];
        Arrays.fill(variables, true);
        return variables;
    }

    /**
     * @param symbol gets the base truth table generated
     */
    protected void baseTruthTable(Symbol symbol) {
        final TruthTable truthTable = new TruthTable(symbol);
        truthTable.print();
    }

    @Override
    public String toString() {
        return IntStream.range(0, values.length)
                .mapToObj(i -> values[i] + " " + (lastValue(i) ? "" : character) + " ")
                .collect(Collectors.joining())
                .strip();
    }

    private boolean lastValue(int i) {
        return i == values.length - 1;
    }
}