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
}
