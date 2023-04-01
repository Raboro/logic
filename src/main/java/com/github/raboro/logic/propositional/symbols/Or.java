package com.github.raboro.logic.propositional.symbols;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class Or implements Symbol {

    private final boolean[] values;

    public Or(boolean a, boolean b) {
        values = new boolean[]{a, b};
    }

    public Or(boolean... values) {
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
    public String symbol() {
        return "\u2228";
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            result.append(values[i]).append(" ");
            if (i != values.length - 1)
                result.append(symbol()).append(" ");
        }
        return result.toString();
    }
}
