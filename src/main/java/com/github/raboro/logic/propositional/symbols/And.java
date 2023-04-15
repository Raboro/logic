package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class And extends Symbol {

    public And(boolean... values) {
        super("\u2227", values);
    }

    public static boolean and(boolean a, boolean b) {
        return a && b;
    }

    public static boolean and(boolean... values) {
        if (notEnoughValues(values)) {
            throw new NotEnoughInputValuesException(values.length);
        }
        boolean result = values[0];
        for (int i = 1; i < values.length; i++) {
            result = and(result, values[i]);
        }
        return result;
    }

    @Override
    public boolean value() {
        boolean result = values[0];
        for (int i = 1; i < values.length; i++) {
            result = and(result, values[i]);
        }
        return result;
    }

    @Override
    public boolean valueOf(boolean... values) {
        return new And(values).value();
    }

    @Override
    public boolean valueOf(String reference) {
        return new And(constructReference(reference)).value();
    }

    @Override
    public boolean valueEquals(String reference) {
        validateReferenceSize(reference);
        return and(constructReference(reference)) == value();
    }

    @Override
    public boolean valueEquals(boolean... reference) {
        validateReferenceSize(reference);
        return and(reference) == value();
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
        return new And(values);
    }
}
