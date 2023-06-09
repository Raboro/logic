package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;
import com.github.raboro.logic.propositional.exception.ValueNotSameSizeException;

import static com.github.raboro.logic.propositional.symbols.Or.or;

/**
 * Represents the logical IMPLICATION. It´s only false if it´s first true but than false. Else it´s true.
 * Because from something true can not conclude something false.
 *
 * @author Raboro
 * @see com.github.raboro.logic.propositional.symbols.Symbol
 * @since 1.0-SNAPSHOT
 */
public class Implication extends Symbol {

    /**
     * @param values boolean inputs
     */
    public Implication(boolean... values) {
        super("\u27F6", values);
    }

    /**
     * @param a first boolean input
     * @param b second boolean input
     * @return evaluates the result of a and b
     */
    public static boolean implication(boolean a, boolean b) {
        return or(!a, b);
    }

    /**
     * @param values are the input arguments (booleans) for the evaluation with IMPLICATION
     * @return evaluates the result of <b>values</b> with IMPLICATION
     * @throws NotEnoughInputValuesException if the number of boolean input arguments are smaller than 2
     */
    public static boolean implication(boolean... values) {
        if (notEnoughValues(values)) {
            throw new NotEnoughInputValuesException(values.length);
        }
        boolean first = values[0];
        for (int i = 1; i < values.length; i++) {
            first = or(!first, values[i]);
        }
        return first;
    }

    @Override
    public boolean value() {
        boolean first = values[0];
        for (int i = 1; i < values.length; i++) {
            first = or(!first, values[i]);
        }
        return first;
    }

    @Override
    public boolean valueOf(boolean... values) {
        return new Implication(values).value();
    }

    @Override
    public boolean valueOf(String reference) {
        return new Implication(constructReference(reference)).value();
    }

    @Override
    public boolean valueEquals(String reference) {
        if (reference.length() != values.length) {
            throw new ValueNotSameSizeException(
                    String.format("Your input (size %s has not the same size as required %s",
                            reference.length(), values.length));
        }
        return implication(constructReference(reference)) == value();
    }

    @Override
    public boolean valueEquals(boolean... reference) {
        if (reference.length != values.length) {
            throw new ValueNotSameSizeException(
                    String.format("Your input (size %s has not the same size as required %s",
                            reference.length, values.length));
        }
        return implication(reference) == value();
    }

    @Override
    public void baseTruthTable() {
        baseTruthTable(2);
    }

    @Override
    public void baseTruthTable(int variableCounter) {
        super.baseTruthTable(construct(super.constructParameters(variableCounter)));
    }

    private Symbol construct(boolean... values) {
        return new Implication(values);
    }
}
