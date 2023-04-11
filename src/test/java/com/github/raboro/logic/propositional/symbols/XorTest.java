package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;
import org.junit.jupiter.api.Test;

import static com.github.raboro.logic.propositional.symbols.Xor.xor;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
class XorTest extends SymbolTest {

    XorTest() {
        mapper = constructMapper();
    }

    private SymbolTestMapper constructMapper() {
        Symbol symbol = new Xor(true, true);
        Symbol[] symbols = new Symbol[]{
                new Xor(false, false, false),
                new Xor(false, false, true),
                new Xor(false, true, false),
                new Xor(false, true, true),
                new Xor(true, false, false),
                new Xor(true, false, true),
                new Xor(true, true, false),
                new Xor(true, true, true)
        };
        SymbolTestMapper.SymbolTestMapperBuilder builder = new SymbolTestMapper.SymbolTestMapperBuilder(symbol);
        return builder.setValueExpected(new boolean[]{false, true, true, false, true, false, false, true})
                .setSymbol(symbol.symbol)
                .setValueEqualsNeededSymbols(symbols)
                .setValueEqualsNeededBinaryReference()
                .setValueEqualsNeededBooleanReference()
                .setValueEqualsInvalidBooleanReference(new boolean[]{true, false})
                .valueEqualsInvalidStringReference("10")
                .build();
    }

    @Test
    void testStaticXorTwoInputs() {
        assertFalse(xor(false, false));
        assertTrue(xor(false, true));
        assertTrue(xor(true, false));
        assertFalse(xor(true, true));
    }

    @Test
    void testStaticXorMultipleInput() {
        assertFalse(xor(false, false, false, false));
        assertTrue(xor(false, true, false));
        assertFalse(xor(true, true, false));
        assertFalse(xor(true, true, true, true));
    }

    @Test
    void testExceptionThrownIfInvalidInputNoArguments() {
        assertThrows(NotEnoughInputValuesException.class, Xor::xor);
    }

    @Test
    void testExceptionThrownIfInvalidInputOneArguments() {
        assertThrows(NotEnoughInputValuesException.class, () -> xor(true));
        assertThrows(NotEnoughInputValuesException.class, () -> xor(false));
    }
}