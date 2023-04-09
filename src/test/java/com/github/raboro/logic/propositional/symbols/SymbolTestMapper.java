package com.github.raboro.logic.propositional.symbols;

import com.github.raboro.logic.propositional.exception.ValueNotSameSizeException;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
class SymbolTestMapper {

    private final Symbol symbol;
    private final String symbolString;
    private final boolean[] valueExpected;
    private final Symbol[] valueEqualsNeededSymbols;
    private final String[] valueEqualsNeededBinaryReference;
    private final boolean[][] valueEqualsNeededBooleanReference;

    SymbolTestMapper(SymbolTestMapperBuilder builder) {
        this.symbol = builder.symbol;
        this.symbolString = builder.symbolString;
        this.valueExpected = builder.valueExpected;
        this.valueEqualsNeededSymbols = builder.valueEqualsNeededSymbols;
        this.valueEqualsNeededBinaryReference = builder.valueEqualsNeededBinaryReference;
        this.valueEqualsNeededBooleanReference = builder.valueEqualsNeededBooleanReference;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public String getSymbolString() {
        return symbolString;
    }

    public boolean[] getValueExpected() {
        return valueExpected;
    }

    public Symbol[] getValueEqualsNeededSymbols() {
        return valueEqualsNeededSymbols;
    }

    public String[] getValueEqualsNeededBinaryReference() {
        return valueEqualsNeededBinaryReference;
    }

    public boolean[][] getValueEqualsNeededBooleanReference() {
        return valueEqualsNeededBooleanReference;
    }

    public static class SymbolTestMapperBuilder {

        private final Symbol symbol;
        private String symbolString;
        private boolean[] valueExpected;
        private Symbol[] valueEqualsNeededSymbols;
        private String[] valueEqualsNeededBinaryReference;
        private boolean[][] valueEqualsNeededBooleanReference;

        public SymbolTestMapperBuilder(Symbol symbol) {
            this.symbol = symbol;
        }

        public SymbolTestMapperBuilder setSymbol(String symbol) {
            this.symbolString = symbol;
            return this;
        }

        public SymbolTestMapperBuilder setValueExpected(boolean[] expected) {
            valueExpected = expected;
            return this;
        }

        public SymbolTestMapperBuilder setValueEqualsNeededSymbols(Symbol[] neededSymbols) {
            valueEqualsNeededSymbols = neededSymbols;
            return this;
        }

        public SymbolTestMapperBuilder setValueEqualsNeededBinaryReference() {
            valueEqualsNeededBinaryReference = new String[]{"000", "001", "010", "011", "100", "101", "110", "111"};
            return this;
        }

        public SymbolTestMapperBuilder setValueEqualsNeededBooleanReference() {
            valueEqualsNeededBooleanReference = new boolean[][]{
                    new boolean[]{false, false, false},
                    new boolean[]{false, false, true},
                    new boolean[]{false, true, false},
                    new boolean[]{false, true, true},
                    new boolean[]{true, false, false},
                    new boolean[]{true, false, true},
                    new boolean[]{true, true, false},
                    new boolean[]{true, true, true}
            };
            return this;
        }

        public SymbolTestMapper build() {
            verify();
            return new SymbolTestMapper(this);
        }

        private void verify() {
            if (valueExpected.length != 8 || symbolString.isBlank() || valueEqualsNeededSymbols.length != 8) {
                throw new ValueNotSameSizeException();
            }
        }
    }
}
