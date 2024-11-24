package homework;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.testng.Assert.assertEquals;

public class AssertEqualsDemonstration {
    @Test
    public void verifyExpectedPaymentIsTheSameAsActual() {
        int expectedPayment = 2700;
        int contractSalary = 2700;

        assertEquals(contractSalary, expectedPayment,
                "Expected payment does not match the contract!");
    }

    @Test
    public void verifyStringLengthMatchesExpectedValue() {
        String greeting = "Hello";
        int stringLength = greeting.length();
        int expectedLength = 5;

        assertEquals(stringLength, expectedLength, "String length does not match!");
    }

    @Test
    public void verifySuccessfulLoginWhenGivenValidPassword() {
        String userPassword = "S3cr3t password";
        String inputPassword = "S3cr3t password";

        assertEquals(inputPassword, userPassword, "Wrong password!");
    }

    public int sumCalculation() {
        int firstNum = 27;
        int secondNum = 31;
        return firstNum + secondNum;
    }

    @Test
    public void verifyCorrectSumCalculation() {
        int expectedSum = 58;
        int actualSum = sumCalculation();

        assertEquals(actualSum, expectedSum, "The sum calculation is incorrect");
    }

    @Test
    public void verifyTheChefHasAllTheIngredientsToCook() {
        ArrayList<String> recipeIngredients = new ArrayList<>();
        ArrayList<String> chefIngredients = new ArrayList<>();

        recipeIngredients.add("mushrooms");
        recipeIngredients.add("gnocchi");
        recipeIngredients.add("olive oil");
        recipeIngredients.add("spinach");
        recipeIngredients.add("blue cheese");

        chefIngredients.add("blue cheese");
        chefIngredients.add("spinach");
        chefIngredients.add("olive oil");
        chefIngredients.add("gnocchi");
        chefIngredients.add("mushrooms");

        Collections.sort(recipeIngredients);
        Collections.sort(chefIngredients);

        assertEquals(chefIngredients, recipeIngredients,
                "Chef's ingredients do not match the recipe ingredients.");
    }
}