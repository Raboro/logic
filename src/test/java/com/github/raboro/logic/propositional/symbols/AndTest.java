package com.github.raboro.logic.propositional.symbols;


import org.junit.jupiter.api.Test;

import static com.github.raboro.logic.propositional.symbols.And.and;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
class AndTest {

    @Test
    void testSymbol() {
        assertEquals("\u2227", new And(true, true).symbol);
    }

    @Test
    void testStaticAndTwoInputs() {
        assertFalse(and(false, false));
        assertFalse(and(true, false));
        assertFalse(and(false, true));
        assertTrue(and(true, true));
    }

    @Test
    void testStaticAndMultipleInputs() {
        assertFalse(and(false, true, false, false));
        assertFalse(and(false, true, false));
        assertFalse(and(true, false, true, true, false, true));
        assertTrue(and(true, true, true, true, true, true));
        assertTrue(and(true, true, true));
    }

    @Test
    void testAndTwoInputs() {
        assertFalse(new And(false, false).value());
        assertFalse(new And(true, false).value());
        assertFalse(new And(false, true).value());
        assertTrue(new And(true, true).value());
    }

    @Test
    void testAndMultipleInputs() {
        assertFalse(new And(false, true, false, false).value());
        assertFalse(new And(false, true, false).value());
        assertFalse(new And(true, false, true, true, false, true).value());
        assertTrue(new And(true, true, true, true, true, true).value());
        assertTrue(new And(true, true, true).value());
    }
}