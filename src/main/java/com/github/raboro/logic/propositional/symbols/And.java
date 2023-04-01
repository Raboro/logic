package com.github.raboro.logic.propositional.symbols;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class And extends Symbol {

    private final boolean[] values;

    public And(boolean a, boolean b) {
        this(new boolean[]{a, b});
    }

    public And(boolean... values) {
        super("\u2227", values);
        this.values = values;
    }

    public static boolean and(boolean a, boolean b) {
        return a && b;
    }

    public static boolean and(boolean... values) {
        boolean result = values[0];
        for (int i = 1; i < values.length; i++)
            result = and(result, values[i]);
        return result;
    }

    @Override
    public boolean value() {
        boolean result = values[0];
        for (int i = 1; i < values.length; i++)
            result = and(result, values[i]);
        return result;
    }
}
