package homework;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class AssertFalseDemonstration {
    @Test
    public void verifyNumberIsNotEven() {
        int number = 9;

        boolean isNumberEven = (number % 2 == 0);

        assertFalse(isNumberEven, "Condition should be false!");
    }

    @Test
    public void verifyStringIsNotEmpty() {
        String greeting = "Welcome";

        boolean isEmpty = greeting.isEmpty();

        assertFalse(isEmpty, "The string should not be empty");
    }
}