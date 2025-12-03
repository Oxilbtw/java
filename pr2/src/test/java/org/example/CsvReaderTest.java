package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CsvReaderTest {

    @Test
    public void testCsvRead() {
        List<Expense> expenses = CsvReader.readExpenses("src/test/resources/test.csv");
        assertEquals(3, expenses.size());
    }
}
