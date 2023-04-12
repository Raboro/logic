package com.github.raboro.logic.propositional.utils;

import com.github.raboro.logic.propositional.symbols.And;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author Raboro
 * @since 1.0-SNAPSHOT
 */
class TruthTableTest {

    @Test
    void testPrintToConsole() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        TruthTable truthTable = new TruthTable(new And(true, true));
        truthTable.print();
        System.out.flush();
        System.setOut(old);
        assertFalse(baos.toString().isBlank());
    }

    @Test
    void testPrintToStream() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        TruthTable truthTable = new TruthTable(new And(true, true));
        truthTable.write(System.out);
        truthTable.print();
        System.out.flush();
        System.setOut(old);
        assertFalse(baos.toString().isBlank());
    }

    @Test
    void testExceptionWithOutputSteam() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        TruthTable truthTable = new TruthTable(new And(true, true));
        truthTable.write(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                throw new IOException("test");

            }
        });
        System.out.flush();
        System.setOut(old);
        assertFalse(baos.toString().isBlank());
    }
}