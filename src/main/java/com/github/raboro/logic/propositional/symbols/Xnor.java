package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;

import java.util.stream.IntStream;

import static com.github.raboro.logic.propositional.symbols.Xor.xor;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class Xnor extends Symbol {

    public Xnor(boolean... values) {
        super("\u27F7", values);
    }

    public static boolean xnor(boolean a, boolean b) {
        return !xor(a, b);
    }

    /**
     * @param values are the input arguments (booleans) for the evaluation with XNOR
     * @return evaluates the result of <b>values</b> with XNOR
     * @throws NotEnoughInputValuesException if the number of boolean input arguments are < 2
     */
    public static boolean xnor(boolean... values) {
        if (notEnoughValues(values)) {
            throw new NotEnoughInputValuesException(values.length);
        }
        return IntStream.range(1, values.length)
                .noneMatch(i -> values[0] != values[i]);
    }

    @Override
    public boolean value() {
        return IntStream.range(1, values.length)
                .noneMatch(i -> values[0] != values[i]);
    }

    @Override
    public boolean valueOf(boolean... values) {
        return new Xnor(values).value();
    }

    @Override
    public boolean valueOf(String reference) {
        return new Xnor(constructReference(reference)).value();
    }

    @Override
    public boolean valueEquals(String reference) {
        validateReferenceSize(reference);
        return xnor(constructReference(reference)) == value();
    }

    @Override
    public boolean valueEquals(boolean... reference) {
        validateReferenceSize(reference);
        return xnor(reference) == value();
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
        return new Xnor(values);
    }
}
