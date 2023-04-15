package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;

/**
 * Represents the logical OR, it´s true, if min. one input argument is true,
 * else it´s false, if all input arguments are false.
 *
 * @author Raboro
 * @see com.github.raboro.logic.propositional.symbols.Symbol
 * @since 1.0-SNAPSHOT
 */
public class Or extends Symbol {

    public Or(boolean... values) {
        super("\u2228", values);
    }

    public static boolean or(boolean a, boolean b) {
        return a || b;
    }

    /**
     * @param values are the input arguments (booleans) for the evaluation with OR
     * @return evaluates the result of <b>values</b> with OR
     * @throws NotEnoughInputValuesException if the number of boolean input arguments are < 2
     */
    public static boolean or(boolean... values) {
        if (notEnoughValues(values)) {
            throw new NotEnoughInputValuesException(values.length);
        }
        for (boolean value : values) {
            if (value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean value() {
        for (boolean value : values) {
            if (value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean valueOf(boolean... values) {
        return new Or(values).value();
    }

    @Override
    public boolean valueOf(String reference) {
        return new Or(constructReference(reference)).value();
    }

    @Override
    public boolean valueEquals(String reference) {
        validateReferenceSize(reference);
        return or(constructReference(reference)) == value();
    }

    @Override
    public boolean valueEquals(boolean... reference) {
        validateReferenceSize(reference);
        return or(reference) == value();
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
        return new Or(values);
    }
}
