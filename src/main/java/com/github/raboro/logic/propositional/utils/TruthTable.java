package com.github.raboro.logic.propositional.utils;

import com.github.raboro.logic.propositional.symbols.Symbol;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
public class TruthTable {

    private final Symbol symbol;
    private String header;
    private String spaceRow;

    public TruthTable(Symbol symbol) {
        this.symbol = symbol;
        buildSpaceRow();
        buildHeader();
    }

    private void buildSpaceRow() {
        spaceRow = "|---".repeat(Math.max(0, symbol.LENGTH)) + "||---|";
    }

    private void buildHeader() {
        header = IntStream.range(1, symbol.LENGTH + 1)
                .mapToObj(i -> " " + i + " |")
                .collect(Collectors.joining("", "|", "| y " + "|"));
    }
}
