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
        for (boolean value : values)
            if (value)
                return true;
        return false;
    }

    @Override
    public boolean value() {
        for (boolean value : values)
            if (value)
                return true;
        return false;
    }

    @Override
    public boolean valueEquals(String reference) {
        final boolean[] referenceValues = new boolean[reference.length()];
        for (int i = 0; i < reference.length(); i++) {
            referenceValues[i] = reference.charAt(i) != '0';
        }
        return or(referenceValues) == value();
    }

    public void baseTruthTable() {
        baseTruthTable(2);
    }

    public void baseTruthTable(int variableCounter) {
        super.baseTruthTable(construct(super.constructParameters(variableCounter)));
    }

    private Symbol construct(boolean...values) {
        return new Or(values);
    }
}
