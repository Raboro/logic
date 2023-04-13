package com.github.raboro.logic.propositional.symbols;


import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;
import org.junit.jupiter.api.Test;

import static com.github.raboro.logic.propositional.symbols.Xnor.xnor;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
class XnorTest extends SymbolTest {

    XnorTest() {
        mapper = constructMapper();
    }

    private SymbolTestMapper constructMapper() {
        Symbol symbol = new Xnor(true, true);
        Symbol[] symbols = new Symbol[]{
                new Xnor(false, false, false),
                new Xnor(false, false, true),
                new Xnor(false, true, false),
                new Xnor(false, true, true),
                new Xnor(true, false, false),
                new Xnor(true, false, true),
                new Xnor(true, true, false),
                new Xnor(true, true, true)
        };
        SymbolTestMapper.SymbolTestMapperBuilder builder = new SymbolTestMapper.SymbolTestMapperBuilder(symbol);
        return builder.setValueExpected(new boolean[]{true, false, false, false, false, false, false, true})
                .setSymbolCharacter(symbol.character)
                .setValueEqualsNeededSymbols(symbols)
                .setValueEqualsNeededBinaryReference()
                .setValueEqualsNeededBooleanReference()
                .setValueEqualsInvalidBooleanReference(new boolean[]{true, false})
                .setValueEqualsInvalidStringReference("10")
                .setTruthTable("""
                        | 1 | 2 || y |
                        |---|---||---|
                        | 0 | 0 || 1 |
                        | 0 | 1 || 0 |
                        | 1 | 0 || 0 |
                        | 1 | 1 || 1 |
                        """)
                .build();
    }

    @Test
    void testStaticAndTwoInputs() {
        assertTrue(xnor(false, false));
        assertFalse(xnor(true, false));
        assertFalse(xnor(false, true));
        assertTrue(xnor(true, true));
    }

    @Test
    void testStaticAndMultipleInputs() {
        assertFalse(xnor(false, true, false, false));
        assertFalse(xnor(false, true, false));
        assertFalse(xnor(true, false, true, true, false, true));
        assertTrue(xnor(true, true, true, true, true, true));
        assertTrue(xnor(true, true, true));
        assertTrue(xnor(false, false, false));
    }

    @Test
    void testExceptionThrownIfInvalidInputNoArguments() {
        assertThrows(NotEnoughInputValuesException.class, Xnor::xnor);
    }

    @Test
    void testExceptionThrownIfInvalidInputOneArguments() {
        assertThrows(NotEnoughInputValuesException.class, () -> xnor(true));
        assertThrows(NotEnoughInputValuesException.class, () -> xnor(false));
    }
}