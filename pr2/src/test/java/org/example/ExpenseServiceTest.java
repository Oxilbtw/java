package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseServiceTest {

    @Test
    public void testTop10Expenses() {
        List<Expense> list = Arrays.asList(
                new Expense("01-01-2023", -50, "Food"),
                new Expense("02-01-2023", -200, "Travel"),
                new Expense("03-01-2023", -10, "Food")
        );

        ExpenseService service = new ExpenseService(list);

        List<Expense> top = service.getTop10Expenses();
        assertEquals(-200, top.get(0).getAmount());
    }
}
