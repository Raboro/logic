package com.github.raboro.logic.propositional.symbols;


import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;
import org.junit.jupiter.api.Test;

import static com.github.raboro.logic.propositional.symbols.Implication.implication;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
class ImplicationTest extends SymbolTest {

    ImplicationTest() {
        mapper = constructMapper();
    }

    private SymbolTestMapper constructMapper() {
        Symbol symbol = new Implication(true, true);
        Symbol[] symbols = new Symbol[]{
                new Implication(false, false, false),
                new Implication(false, false, true),
                new Implication(false, true, false),
                new Implication(false, true, true),
                new Implication(true, false, false),
                new Implication(true, false, true),
                new Implication(true, true, false),
                new Implication(true, true, true)
        };
        SymbolTestMapper.SymbolTestMapperBuilder builder = new SymbolTestMapper.SymbolTestMapperBuilder(symbol);
        return builder.setValueExpected(new boolean[]{false, true, false, true, true, true, false, true})
                .setSymbol(symbol.symbol)
                .setValueEqualsNeededSymbols(symbols)
                .setValueEqualsNeededBinaryReference()
                .setValueEqualsNeededBooleanReference()
                .setValueEqualsInvalidBooleanReference(new boolean[]{true, false})
                .valueEqualsInvalidStringReference("10")
                .build();
    }

    @Test
    void testStaticAndTwoInputs() {
        assertTrue(implication(false, false));
        assertFalse(implication(true, false));
        assertTrue(implication(false, true));
        assertTrue(implication(true, true));
    }

    @Test
    void testStaticAndMultipleInputs() {
        assertTrue(implication(false, true, false, false));
        assertFalse(implication(false, true, false));
        assertTrue(implication(true, false, true, true, false, true));
        assertTrue(implication(true, true, true, true, true, true));
        assertTrue(implication(true, true, true));
    }

    @Test
    void testExceptionThrownIfInvalidInputNoArguments() {
        assertThrows(NotEnoughInputValuesException.class, Implication::implication);
    }

    @Test
    void testExceptionThrownIfInvalidInputOneArguments() {
        assertThrows(NotEnoughInputValuesException.class, () -> implication(true));
        assertThrows(NotEnoughInputValuesException.class, () -> implication(false));
    }
}