package com.github.raboro.logic.propositional.utils;

import com.github.raboro.logic.propositional.symbols.Symbol;

import java.util.ArrayList;
import java.util.List;
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
    private final List<String> rows;

    public TruthTable(Symbol symbol) {
        this.symbol = symbol;
        rows = new ArrayList<>();
        buildSpaceRow();
        buildHeader();
        buildRows();
    }

    private void buildSpaceRow() {
        spaceRow = "|---".repeat(Math.max(0, symbol.LENGTH)) + "||---|";
    }

    private void buildHeader() {
        header = IntStream.range(1, symbol.LENGTH + 1)
                .mapToObj(i -> " " + i + " |")
                .collect(Collectors.joining("", "|", "| y " + "|"));
    }

    private void buildRows() {
        for (int row = 0; row < Math.pow(2, symbol.LENGTH); row++) {
            final String binaryNumber = createBinary(row, symbol.LENGTH);
            final String builder = IntStream.range(0, binaryNumber.length())
                    .mapToObj(i -> " " + binaryNumber.charAt(i) + " |")
                    .collect(Collectors.joining("", "|", "| " + (symbol.valueEquals(binaryNumber) ? "1" : "0") + " |"));
            rows.add(builder);
        }
    }

    private String createBinary(int decimalNumber, int fillLength) {
        final StringBuilder binaryNumber = new StringBuilder(Integer.toBinaryString(decimalNumber));
        while (binaryNumber.length() < fillLength) {
            binaryNumber.insert(0, "0");
        }
        return binaryNumber.toString();
    }

    public void print() {
        System.out.println(header);
        System.out.println(spaceRow);
        rows.forEach(System.out::println);
    }
}
