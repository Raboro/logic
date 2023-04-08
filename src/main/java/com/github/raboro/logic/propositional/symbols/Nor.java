package com.github.raboro.logic.propositional.symbols;

import static com.github.raboro.logic.propositional.symbols.Or.or;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class Nor extends Symbol {

    public Nor(boolean a, boolean b) {
        this(new boolean[]{a, b});
    }

    public Nor(boolean... values) {
        super("↓", values);
    }

    public static boolean nor(boolean a, boolean b) {
        return !or(a, b);
    }

    public static boolean nor(boolean... values) {
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
        return reference.length == values.length && nor(reference) == value();
    }

    public void baseTruthTable() {
        baseTruthTable(2);
    }

    public void baseTruthTable(int variableCounter) {
        super.baseTruthTable(construct(super.constructParameters(variableCounter)));
    }

    private Symbol construct(boolean... values) {
        return new Nor(values);
    }
}
