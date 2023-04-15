package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;

import static com.github.raboro.logic.propositional.symbols.And.and;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class Nand extends Symbol {

    public Nand(boolean... values) {
        super("\u22BC", values);
    }

    public static boolean nand(boolean a, boolean b) {
        return !(a && b);
    }

    /**
     * @param values are the input arguments (booleans) for the evaluation with NAND
     * @return evaluates the result of <b>values</b> with NAND
     * @throws NotEnoughInputValuesException if the number of boolean input arguments are < 2
     */
    public static boolean nand(boolean... values) {
        if (notEnoughValues(values)) {
            throw new NotEnoughInputValuesException(values.length);
        }
        boolean result = values[0];
        for (int i = 1; i < values.length; i++) {
            result = and(result, values[i]);
        }
        return !result;
    }

    @Override
    public boolean value() {
        boolean result = values[0];
        for (int i = 1; i < values.length; i++) {
            result = and(result, values[i]);
        }
        return !result;
    }

    @Override
    public boolean valueOf(boolean... values) {
        return new Nand(values).value();
    }

    @Override
    public boolean valueOf(String reference) {
        return new Nand(constructReference(reference)).value();
    }

    @Override
    public boolean valueEquals(String reference) {
        validateReferenceSize(reference);
        return nand(constructReference(reference)) == value();
    }

    @Override
    public boolean valueEquals(boolean... reference) {
        validateReferenceSize(reference);
        return nand(reference) == value();
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
        return new Nand(values);
    }
}
