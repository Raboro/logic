package com.github.raboro.logic.propositional.symbols;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class Or extends Symbol {

    private final boolean[] values;

    public Or(boolean a, boolean b) {
        this(new boolean[]{a, b});
    }

    public Or(boolean... values) {
        super("\u2228", values);
        this.values = values;
    }

    public static boolean or(boolean a, boolean b) {
        return a || b;
    }

    public static boolean or(boolean... values) {
        for (boolean value : values) {
            if (value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean value() {
        for (boolean value : values) {
            if (value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean valueOf(boolean... values) {
        return new Or(values).value();
    }

    @Override
    public boolean valueOf(String reference) {
        return new Or(constructReference(reference)).value();
    }

    @Override
    public boolean valueEquals(String reference) {
        return or(constructReference(reference)) == value();
    }

    @Override
    public boolean valueEquals(boolean... reference) {
        return reference.length == values.length && or(reference) == value();
    }

    public void baseTruthTable() {
        baseTruthTable(2);
    }

    public void baseTruthTable(int variableCounter) {
        super.baseTruthTable(construct(super.constructParameters(variableCounter)));
    }

    private Symbol construct(boolean... values) {
        return new Or(values);
    }
}
