package com.github.raboro.logic.propositional.symbols;

import static com.github.raboro.logic.propositional.symbols.And.and;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class Nand extends Symbol {

    public Nand(boolean a, boolean b) {
        this(new boolean[]{a, b});
    }

    public Nand(boolean... values) {
        super("\u22BC", values);
    }

    public static boolean nand(boolean a, boolean b) {
        return !(a && b);
    }

    public static boolean nand(boolean... values) {
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
        return nand(constructReference(reference)) == value();
    }

    @Override
    public boolean valueEquals(boolean... reference) {
        return reference.length == values.length && nand(reference) == value();
    }

    public void baseTruthTable() {
        baseTruthTable(2);
    }

    public void baseTruthTable(int variableCounter) {
        super.baseTruthTable(construct(super.constructParameters(variableCounter)));
    }

    private Symbol construct(boolean... values) {
        return new Nand(values);
    }
}