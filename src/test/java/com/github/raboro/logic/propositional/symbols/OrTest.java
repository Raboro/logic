package com.github.raboro.logic.propositional.symbols;

import org.junit.jupiter.api.Test;

import static com.github.raboro.logic.propositional.symbols.Or.or;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
class OrTest {

    @Test
    void testSymbol() {
        assertEquals("\u2228", new Or(true, true).SYMBOL);
    }

    @Test
    void testStaticOrTwoValues() {
        assertFalse(or(false, false));
        assertTrue(or(false, true));
        assertTrue(or(true, false));
        assertTrue(or(true, true));
    }

    @Test
    void testStaticOrMultipleValues() {
        assertFalse(or(false, false, false, false));
        assertTrue(or(false, true, false, false,true));
        assertTrue(or(true, false, false));
        assertTrue(or(true, true, true, true, true));
    }

    @Test
    void testOrTwoValues() {
        assertFalse(new Or(false, false).value());
        assertTrue(new Or(false, true).value());
        assertTrue(new Or(true, false).value());
        assertTrue(new Or(true, true).value());
    }

    @Test
    void testOrMultipleValues() {
        assertFalse(new Or(false, false, false, false).value());
        assertTrue(new Or(false, true, false, false,true).value());
        assertTrue(new Or(true, false, false).value());
        assertTrue(new Or(true, true, true, true, true).value());
    }
}