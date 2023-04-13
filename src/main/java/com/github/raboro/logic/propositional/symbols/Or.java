package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;
import com.github.raboro.logic.propositional.exception.ValueNotSameSizeException;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class Or extends Symbol {

    public Or(boolean... values) {
        super("\u2228", values);
    }

    public static boolean or(boolean a, boolean b) {
        return a || b;
    }

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
        return or(constructReference(reference)) == value();
    }

    @Override
    public boolean valueEquals(boolean... reference) {
        if (reference.length != values.length) {
            throw new ValueNotSameSizeException(
                    String.format("Your input (size %s has not the same size as required %s",
                            reference.length, values.length));
        }
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
