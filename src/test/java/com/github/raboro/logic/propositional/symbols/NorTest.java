package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;
import org.junit.jupiter.api.Test;

import static com.github.raboro.logic.propositional.symbols.Nor.nor;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
class NorTest extends SymbolTest {

    NorTest() {
        mapper = constructMapper();
    }

    private SymbolTestMapper constructMapper() {
        Symbol symbol = new Nor(true, true);
        Symbol[] symbols = new Symbol[]{
                new Nor(false, false, false),
                new Nor(false, false, true),
                new Nor(false, true, false),
                new Nor(false, true, true),
                new Nor(true, false, false),
                new Nor(true, false, true),
                new Nor(true, true, false),
                new Nor(true, true, true)
        };
        SymbolTestMapper.SymbolTestMapperBuilder builder = new SymbolTestMapper.SymbolTestMapperBuilder(symbol);
        return builder.setValueExpected(new boolean[]{true, false, false, false, false, false, false, false})
                .setSymbol(symbol.symbol)
                .setValueEqualsNeededSymbols(symbols)
                .setValueEqualsNeededBinaryReference()
                .setValueEqualsNeededBooleanReference()
                .setValueEqualsInvalidBooleanReference(new boolean[]{false, false})
                .setValueEqualsInvalidStringReference("00")
                .setTruthTable("""
                        | 1 | 2 || y |
                        |---|---||---|
                        | 0 | 0 || 1 |
                        | 0 | 1 || 0 |
                        | 1 | 0 || 0 |
                        | 1 | 1 || 0 |
                        """)
                .build();
    }

    @Test
    void testStaticAndTwoInputs() {
        assertTrue(nor(false, false));
        assertFalse(nor(true, false));
        assertFalse(nor(false, true));
        assertFalse(nor(true, true));
    }

    @Test
    void testStaticAndMultipleInputs() {
        assertFalse(nor(false, true, false, false));
        assertFalse(nor(false, true, false));
        assertFalse(nor(true, false, true, true, false, true));
        assertTrue(nor(false, false, false, false, false, false));
        assertTrue(nor(false, false, false));
    }

    @Test
    void testExceptionThrownIfInvalidInputNoArguments() {
        assertThrows(NotEnoughInputValuesException.class, Nor::nor);
    }

    @Test
    void testExceptionThrownIfInvalidInputOneArguments() {
        assertThrows(NotEnoughInputValuesException.class, () -> nor(true));
        assertThrows(NotEnoughInputValuesException.class, () -> nor(false));
    }
}