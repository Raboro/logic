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
    private final boolean[] valueEqualsInvalidBooleanReference;
    private final String valueEqualsInvalidStringReference;
    private final String truthTable;

    SymbolTestMapper(SymbolTestMapperBuilder builder) {
        this.symbol = builder.symbol;
        this.symbolString = builder.symbolString;
        this.valueExpected = builder.valueExpected;
        this.valueEqualsNeededSymbols = builder.valueEqualsNeededSymbols;
        this.valueEqualsNeededBinaryReference = builder.valueEqualsNeededBinaryReference;
        this.valueEqualsNeededBooleanReference = builder.valueEqualsNeededBooleanReference;
        this.valueEqualsInvalidBooleanReference = builder.valueEqualsInvalidBooleanReference;
        this.valueEqualsInvalidStringReference = builder.valueEqualsInvalidStringReference;
        this.truthTable = builder.truthTable;
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

    public boolean[] getValueEqualsInvalidBooleanReference() {
        return valueEqualsInvalidBooleanReference;
    }

    public String getValueEqualsInvalidStringReference() {
        return valueEqualsInvalidStringReference;
    }

    public String getTruthTable() {
        return truthTable;
    }

    public static class SymbolTestMapperBuilder {

        private final Symbol symbol;
        private String symbolString;
        private boolean[] valueExpected;
        private Symbol[] valueEqualsNeededSymbols;
        private String[] valueEqualsNeededBinaryReference;
        private boolean[][] valueEqualsNeededBooleanReference;
        private boolean[] valueEqualsInvalidBooleanReference;
        private String valueEqualsInvalidStringReference;
        private String truthTable;

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

        public SymbolTestMapperBuilder setValueEqualsInvalidBooleanReference(boolean[] reference) {
            valueEqualsInvalidBooleanReference = reference;
            return this;
        }

        public SymbolTestMapperBuilder setValueEqualsInvalidStringReference(String reference) {
            valueEqualsInvalidStringReference = reference;
            return this;
        }

        public SymbolTestMapperBuilder setTruthTable(String truthTable) {
            this.truthTable = truthTable;
            return this;
        }

        public SymbolTestMapper build() {
            verify();
            return new SymbolTestMapper(this);
        }

        private void verify() {
            if (valueExpected.length != 8 || symbolString.isBlank() || valueEqualsNeededSymbols.length != 8 ||
                    valueEqualsInvalidBooleanReference.length != 2 || valueEqualsInvalidStringReference.length() != 2) {
                throw new ValueNotSameSizeException("values have not the required size");
            }
        }
    }
}
