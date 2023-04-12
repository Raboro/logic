package com.github.raboro.logic.propositional.utils;

import com.github.raboro.logic.propositional.symbols.Symbol;

import java.io.IOException;
import java.io.OutputStream;
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
        spaceRow = "|---".repeat(Math.max(0, symbol.length)) + "||---|\n";
    }

    private void buildHeader() {
        header = IntStream.range(1, symbol.length + 1)
                .mapToObj(i -> " " + i + " |")
                .collect(Collectors.joining("", "|", "| y " + "|\n"));
    }

    private void buildRows() {
        for (int row = 0; row < Math.pow(2, symbol.length); row++) {
            rows.add(buildRow(createBinary(row, symbol.length)));
        }
    }

    private String createBinary(int decimalNumber, int fillLength) {
        final StringBuilder binaryNumber = new StringBuilder(Integer.toBinaryString(decimalNumber));
        while (binaryNumber.length() < fillLength) {
            binaryNumber.insert(0, "0");
        }
        return binaryNumber.toString();
    }

    private String buildRow(String binaryNumber) {
        return IntStream.range(0, binaryNumber.length())
                .mapToObj(i -> " " + binaryNumber.charAt(i) + " |")
                .collect(Collectors.joining("", "|", createSuffix(binaryNumber)));
    }

    private String createSuffix(String binaryNumber) {
        return "| " + (symbol.valueOf(binaryNumber) ? "1" : "0") + " |\n";
    }

    public void print() {
        write(System.out);
    }

    public void write(OutputStream os) {
        try {
            writeTo(os);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private void writeTo(OutputStream os) throws IOException {
        os.write(header.getBytes());
        os.write(spaceRow.getBytes());
        rows.forEach(r -> {
            try {
                os.write(r.getBytes());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        });
    }
}
