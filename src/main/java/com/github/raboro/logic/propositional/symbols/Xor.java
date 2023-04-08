package com.github.raboro.logic.propositional.symbols;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class Xor extends Symbol {

    public Xor(boolean a, boolean b) {
        this(new boolean[]{a, b});
    }

    public Xor(boolean... values) {
        super("\u22BB", values);
    }

    public static boolean xor(boolean a, boolean b) {
        return a ^ b;
    }

    public static boolean xor(boolean... values) {
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
        return xor(constructReference(reference)) == value();
    }

    @Override
    public boolean valueEquals(boolean... reference) {
        return reference.length == values.length && xor(reference) == value();
    }

    public void baseTruthTable() {
        baseTruthTable(2);
    }

    public void baseTruthTable(int variableCounter) {
        super.baseTruthTable(construct(super.constructParameters(variableCounter)));
    }

    private Symbol construct(boolean... values) {
        return new Xor(values);
    }
}
