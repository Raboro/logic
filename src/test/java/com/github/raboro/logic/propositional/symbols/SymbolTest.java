package com.github.raboro.logic.propositional.symbols;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
class SymbolTest {

    protected SymbolTestMapper mapper = null;

    @Test
    void testSymbol() {
        if (mapper != null) {
            assertEquals(mapper.getSymbolString(), mapper.getSymbol().symbol);
        }
    }

    @Test
    void testValueBooleanReference() {
        if (mapper != null) {
            for (int i = 0; i < mapper.getValueExpected().length; i++) {
                assertEquals(mapper.getValueExpected()[i], mapper.getSymbol().valueOf(mapper.getSymbol().constructReference(constructBinaryOfDecimal(i))));
            }
        }
    }

    @Test
    void testValueStringReference() {
        if (mapper != null) {
            for (int i = 0; i < mapper.getValueExpected().length; i++) {
                assertEquals(mapper.getValueExpected()[i], mapper.getSymbol().valueOf(constructBinaryOfDecimal(i)));
            }
        }
    }

    private String constructBinaryOfDecimal(int decimalNumber) {
        final StringBuilder binaryNumber = new StringBuilder(Integer.toBinaryString(decimalNumber));
        while (binaryNumber.length() < 3) {
            binaryNumber.insert(0, "0");
        }
        return binaryNumber.toString();
    }

    @Test
    void testValueEqualsStringReferenceTrue() {
        if (mapper != null) {
            for (int i = 0; i < 8; i++) {
                assertTrue(mapper.getValueEqualsNeededSymbols()[i].valueEquals(mapper.getValueEqualsNeededBinaryReference()[i]));
            }
        }
    }

    @Test
    void testValueEqualsBooleanReferenceTrue() {
        if (mapper != null) {
            for (int i = 0; i < 8; i++) {
                assertTrue(mapper.getValueEqualsNeededSymbols()[i].valueEquals(mapper.getValueEqualsNeededBooleanReference()[i]));
            }
        }
    }
}
