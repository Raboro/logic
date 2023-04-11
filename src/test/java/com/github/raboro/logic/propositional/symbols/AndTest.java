package com.github.raboro.logic.propositional.symbols;


import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;
import org.junit.jupiter.api.Test;

import static com.github.raboro.logic.propositional.symbols.And.and;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
class AndTest extends SymbolTest {

    AndTest() {
        mapper = constructMapper();
    }

    private SymbolTestMapper constructMapper() {
        Symbol symbol = new And(true, true);
        Symbol[] symbols = new Symbol[]{
                new And(false, false, false),
                new And(false, false, true),
                new And(false, true, false),
                new And(false, true, true),
                new And(true, false, false),
                new And(true, false, true),
                new And(true, true, false),
                new And(true, true, true)
        };
        SymbolTestMapper.SymbolTestMapperBuilder builder = new SymbolTestMapper.SymbolTestMapperBuilder(symbol);
        return builder.setValueExpected(new boolean[]{false, false, false, false, false, false, false, true})
                .setSymbol(symbol.symbol)
                .setValueEqualsNeededSymbols(symbols)
                .setValueEqualsNeededBinaryReference()
                .setValueEqualsNeededBooleanReference()
                .setValueEqualsInvalidBooleanReference(new boolean[]{false, false})
                .valueEqualsInvalidStringReference("00")
                .build();
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
    void testExceptionThrownIfInvalidInputNoArguments() {
        assertThrows(NotEnoughInputValuesException.class, And::and);
    }

    @Test
    void testExceptionThrownIfInvalidInputOneArguments() {
        assertThrows(NotEnoughInputValuesException.class, () -> and(true));
        assertThrows(NotEnoughInputValuesException.class, () -> and(false));
    }
}