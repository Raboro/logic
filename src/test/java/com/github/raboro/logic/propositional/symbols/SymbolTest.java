package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.NoBinaryInputException;
import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testExceptionThrownIfInvalidInputNoArguments() {
        if (mapper != null) {
            Symbol symbol = mapper.getSymbol();
            assertThrows(NotEnoughInputValuesException.class, symbol::valueOf);
        }
    }

    @Test
    void testExceptionThrownIfInvalidInputOneArguments() {
        if (mapper != null) {
            Symbol symbol = mapper.getSymbol();
            assertThrows(NotEnoughInputValuesException.class, () -> symbol.valueOf(true));
            assertThrows(NotEnoughInputValuesException.class, () -> symbol.valueOf(false));
            assertThrows(NotEnoughInputValuesException.class, () -> symbol.valueOf(""));
            assertThrows(NotEnoughInputValuesException.class, () -> symbol.valueOf(" "));
            assertThrows(NotEnoughInputValuesException.class, () -> symbol.valueOf("1"));
        }
    }

    @Test
    void testExceptionThrownIfInvalidInputNoBinaryString() {
        if (mapper != null) {
            Symbol symbol = mapper.getSymbol();
            assertThrows(NoBinaryInputException.class, () -> symbol.valueOf("35"));
        }
    }
}