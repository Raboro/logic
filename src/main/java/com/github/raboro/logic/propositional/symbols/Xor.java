package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;

/**
 * Represents the logical XOR, it´s true if one input arguments is true, else it´s false.
 * It´s the exclusive logical OR. Because the logical OR is also true, if multiple input arguments are true.
 *
 * @author Raboro
 * @see com.github.raboro.logic.propositional.symbols.Symbol
 * @see com.github.raboro.logic.propositional.symbols.Or
 * @since 1.0-SNAPSHOT
 */
public class Xor extends Symbol {

    public Xor(boolean... values) {
        super("\u22BB", values);
    }

    public static boolean xor(boolean a, boolean b) {
        return a ^ b;
    }

    /**
     * @param values are the input arguments (booleans) for the evaluation with XOR
     * @return evaluates the result of <b>values</b> with XOR
     * @throws NotEnoughInputValuesException if the number of boolean input arguments are < 2
     */
    public static boolean xor(boolean... values) {
        if (notEnoughValues(values)) {
            throw new NotEnoughInputValuesException(values.length);
        }
        boolean result = values[0];
        for (int i = 1; i < values.length; i++) {
            result = xor(result, values[i]);
        }
        return result;
    }

    @Override
    public boolean value() {
        boolean result = values[0];
        for (int i = 1; i < values.length; i++) {
            result = xor(result, values[i]);
        }
        return result;
    }

    @Override
    public boolean valueOf(boolean... values) {
        return new Xor(values).value();
    }

    @Override
    public boolean valueOf(String reference) {
        return new Xor(constructReference(reference)).value();
    }

    @Override
    public boolean valueEquals(String reference) {
        validateReferenceSize(reference);
        return xor(constructReference(reference)) == value();
    }

    @Override
    public boolean valueEquals(boolean... reference) {
        validateReferenceSize(reference);
        return xor(reference) == value();
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
        return new Xor(values);
    }
}
