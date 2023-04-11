package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;
import org.junit.jupiter.api.Test;

import static com.github.raboro.logic.propositional.symbols.Nand.nand;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
class NandTest extends SymbolTest {

    NandTest() {
        mapper = constructMapper();
    }

    private SymbolTestMapper constructMapper() {
        Symbol symbol = new Nand(true, true);
        Symbol[] symbols = new Symbol[]{
                new Nand(false, false, false),
                new Nand(false, false, true),
                new Nand(false, true, false),
                new Nand(false, true, true),
                new Nand(true, false, false),
                new Nand(true, false, true),
                new Nand(true, true, false),
                new Nand(true, true, true)
        };
        SymbolTestMapper.SymbolTestMapperBuilder builder = new SymbolTestMapper.SymbolTestMapperBuilder(symbol);
        return builder.setValueExpected(new boolean[]{true, true, true, true, true, true, true, false})
                .setSymbol(symbol.symbol)
                .setValueEqualsNeededSymbols(symbols)
                .setValueEqualsNeededBinaryReference()
                .setValueEqualsNeededBooleanReference()
                .setValueEqualsInvalidBooleanReference(new boolean[]{false, true})
                .valueEqualsInvalidStringReference("01")
                .build();
    }

    @Test
    void testStaticAndTwoInputs() {
        assertTrue(nand(false, false));
        assertTrue(nand(true, false));
        assertTrue(nand(false, true));
        assertFalse(nand(true, true));
    }

    @Test
    void testStaticAndMultipleInputs() {
        assertTrue(nand(false, true, false, false));
        assertTrue(nand(false, true, false));
        assertTrue(nand(true, false, true, true, false, true));
        assertFalse(nand(true, true, true, true, true, true));
        assertFalse(nand(true, true, true));
    }

    @Test
    void testExceptionThrownIfInvalidInputNoArguments() {
        assertThrows(NotEnoughInputValuesException.class, Nand::nand);
    }

    @Test
    void testExceptionThrownIfInvalidInputOneArguments() {
        assertThrows(NotEnoughInputValuesException.class, () -> nand(true));
        assertThrows(NotEnoughInputValuesException.class, () -> nand(false));
    }
}