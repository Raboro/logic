package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;
import com.github.raboro.logic.propositional.exception.ValueNotSameSizeException;

import static com.github.raboro.logic.propositional.symbols.Or.or;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class Nor extends Symbol {

    public Nor(boolean... values) {
        super("↓", values);
    }

    public static boolean nor(boolean a, boolean b) {
        return !or(a, b);
    }

    public static boolean nor(boolean... values) {
        if (notEnoughValues(values)) {
            throw new NotEnoughInputValuesException(values.length);
        }
        return !or(values);
    }

    @Override
    public boolean value() {
        return !or(values);
    }

    @Override
    public boolean valueOf(boolean... values) {
        return new Nor(values).value();
    }

    @Override
    public boolean valueOf(String reference) {
        return new Nor(constructReference(reference)).value();
    }

    @Override
    public boolean valueEquals(String reference) {
        return nor(constructReference(reference)) == value();
    }

    @Override
    public boolean valueEquals(boolean... reference) {
        if (reference.length != values.length) {
            throw new ValueNotSameSizeException(
                    String.format("Your input (size %s has not the same size as required %s",
                            reference.length, values.length));
        }
        return nor(reference) == value();
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
        return new Nor(values);
    }
}
