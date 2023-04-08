package com.github.raboro.logic.propositional.symbols;

import java.util.stream.IntStream;

import static com.github.raboro.logic.propositional.symbols.Xor.xor;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class Xnor extends Symbol {

    public Xnor(boolean a, boolean b) {
        this(new boolean[]{a, b});
    }

    public Xnor(boolean... values) {
        super("\u27F7", values);
    }

    public static boolean xnor(boolean a, boolean b) {
        return !xor(a, b);
    }

    public static boolean xnor(boolean... values) {
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
        return reference.length == values.length && xnor(reference) == value();
    }

    public void baseTruthTable() {
        baseTruthTable(2);
    }

    public void baseTruthTable(int variableCounter) {
        super.baseTruthTable(construct(super.constructParameters(variableCounter)));
    }

    private Symbol construct(boolean... values) {
        return new Xnor(values);
    }
}
