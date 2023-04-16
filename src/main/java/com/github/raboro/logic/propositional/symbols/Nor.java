package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;

import static com.github.raboro.logic.propositional.symbols.Or.or;

/**
 * Represents the logical NOR, which is the negation of the logical OR.
 * It´s true, if all input arguments are false, else it´s false.
 *
 * @author Raboro
 * @see com.github.raboro.logic.propositional.symbols.Symbol
 * @see com.github.raboro.logic.propositional.symbols.Or
 * @since 1.0-SNAPSHOT
 */
public class Nor extends Symbol {

    /**
     * @param values boolean inputs
     */
    public Nor(boolean... values) {
        super("\u22BD", values);
    }

    /**
     * @param a first boolean input
     * @param b second boolean input
     * @return evaluates the result of a and b
     */
    public static boolean nor(boolean a, boolean b) {
        return !or(a, b);
    }

    /**
     * @param values are the input arguments (booleans) for the evaluation with NOR
     * @return evaluates the result of <b>values</b> with NOR
     * @throws NotEnoughInputValuesException if the number of boolean input arguments are smaller than 2
     */
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
        validateReferenceSize(reference);
        return nor(constructReference(reference)) == value();
    }

    @Override
    public boolean valueEquals(boolean... reference) {
        validateReferenceSize(reference);
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
