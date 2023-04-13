package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;
import com.github.raboro.logic.propositional.exception.ValueNotSameSizeException;

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
        return xnor(constructReference(reference)) == value();
    }

    @Override
    public boolean valueEquals(boolean... reference) {
        if (reference.length != values.length) {
            throw new ValueNotSameSizeException(
                    String.format("Your input (size %s has not the same size as required %s",
                            reference.length, values.length));
        }
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
