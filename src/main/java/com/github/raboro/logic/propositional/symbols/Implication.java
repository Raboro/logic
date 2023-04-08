package com.github.raboro.logic.propositional.symbols;

import static com.github.raboro.logic.propositional.symbols.Or.or;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class Implication extends Symbol {

    public Implication(boolean a, boolean b) {
        this(new boolean[]{a, b});
    }

    public Implication(boolean... values) {
        super("\u27F6", values);
    }

    public static boolean implication(boolean a, boolean b) {
        return or(!a, b);
    }

    public static boolean implication(boolean... values) {
        boolean first = values[0];
        for (int i = 1; i < values.length; i++) {
            first = or(!first, values[i]);
        }
        return first;
    }

    @Override
    public boolean value() {
        boolean first = values[0];
        for (int i = 1; i < values.length; i++) {
            first = or(!first, values[i]);
        }
        return first;
    }

    @Override
    public boolean valueOf(boolean... values) {
        return new Implication(values).value();
    }

    @Override
    public boolean valueOf(String reference) {
        return new Implication(constructReference(reference)).value();
    }

    @Override
    public boolean valueEquals(String reference) {
        return implication(constructReference(reference)) == value();
    }

    @Override
    public boolean valueEquals(boolean... reference) {
        return reference.length == values.length && implication(reference) == value();
    }

    public void baseTruthTable() {
        baseTruthTable(2);
    }

    public void baseTruthTable(int variableCounter) {
        super.baseTruthTable(construct(constructParameters(variableCounter)));
    }

    private Symbol construct(boolean... values) {
        return new Implication(values);
    }
}
