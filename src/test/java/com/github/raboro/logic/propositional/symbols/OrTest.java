package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.NotEnoughInputValuesException;
import org.junit.jupiter.api.Test;

import static com.github.raboro.logic.propositional.symbols.Or.or;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
class OrTest extends SymbolTest {

    OrTest() {
        mapper = constructMapper();
    }

    private SymbolTestMapper constructMapper() {
        Symbol symbol = new Or(true, true);
        Symbol[] symbols = new Symbol[]{
                new Or(false, false, false),
                new Or(false, false, true),
                new Or(false, true, false),
                new Or(false, true, true),
                new Or(true, false, false),
                new Or(true, false, true),
                new Or(true, true, false),
                new Or(true, true, true)
        };
        SymbolTestMapper.SymbolTestMapperBuilder builder = new SymbolTestMapper.SymbolTestMapperBuilder(symbol);
        return builder.setValueExpected(new boolean[]{false, true, true, true, true, true, true, true})
                .setSymbol(symbol.symbol)
                .setValueEqualsNeededSymbols(symbols)
                .setValueEqualsNeededBinaryReference()
                .setValueEqualsNeededBooleanReference()
                .setValueEqualsInvalidBooleanReference(new boolean[]{false, false})
                .setValueEqualsInvalidStringReference("00")
                .setTruthTable("""
                        | 1 | 2 || y |
                        |---|---||---|
                        | 0 | 0 || 0 |
                        | 0 | 1 || 1 |
                        | 1 | 0 || 1 |
                        | 1 | 1 || 1 |
                        """)
                .build();
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
        assertTrue(or(false, true, false, false, true));
        assertTrue(or(true, false, false));
        assertTrue(or(true, true, true, true, true));
    }

    @Test
    void testExceptionThrownIfInvalidInputNoArguments() {
        assertThrows(NotEnoughInputValuesException.class, Or::or);
    }

    @Test
    void testExceptionThrownIfInvalidInputOneArguments() {
        assertThrows(NotEnoughInputValuesException.class, () -> or(true));
        assertThrows(NotEnoughInputValuesException.class, () -> or(false));
    }
}