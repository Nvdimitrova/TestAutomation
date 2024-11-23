package testnghomework;

import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;

public class AssertNotEquals {
    @Test
    public void verifyReversedStringDoesNotEqualOriginal() {
        String greeting = "Hello";
        String reversedGreeting = new StringBuilder(greeting).reverse().toString();

        assertNotEquals(reversedGreeting, greeting,
                "The reversed string should not be equal to the original string!");
    }


    double electricity = 117.28;
    double water = 34.45;
    double food = 347.77;
    double internet = 33.99;
    double otherExpenses = 621.89;

    double salary = 1557.12;
    double additionalIncome = 770;

    public double expenses() {
        return electricity + water + food + internet + otherExpenses;
    }

    public double income() {
        return salary + additionalIncome;
    }

    @Test
    public void verifyExpensesDoesNotEqualIncome() {
        double totalExpenses = expenses();
        double totalIncome = income();

        assertNotEquals(totalIncome, totalExpenses,
                "Expenses should not be equal to income");

    }

    @Test
    public void verifySubtractionIsNotEqualToZero() {
        double expenses = expenses();
        double income = income();

        double remainingAmount = income - expenses;

        assertNotEquals(remainingAmount, 0.0, "Remaining amount should not be zero!");
    }
}