package assertions;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertFalse;

public class AssertFalseDemonstration {
    @Test
    public void verifyLoginFailWithWrongPassword() {
        String expectedPassword = "S3cr3t password";
        String providedPassword = "Secret password";

        boolean isPasswordSame = expectedPassword.equals(providedPassword);

        assertFalse(isPasswordSame,
                "Login should fail when the provided password is incorrect.");
    }

    @Test
    public void verifyFirstNumberIsSmallestThanSecondNumber() {
        double firstNumber = 111.111;
        double secondNumber = 222.222;

        boolean isFirstNumBigger = firstNumber > secondNumber;

        assertFalse(isFirstNumBigger);
    }

    @Test
    public void verifyPasswordIsShorterThanRequired() {
        int requiredPasswordLength = 10;
        String userPassword = "password";

        int userPasswordLength = userPassword.length();

        boolean isUserPasswordLonger = userPasswordLength > requiredPasswordLength;

        assertFalse(isUserPasswordLonger,
                "Password should be shorter than the required length!");
    }

    public ArrayList<String> recipeElements() {
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("mushrooms");
        ingredients.add("gnocchi");
        ingredients.add("olive oil");
        ingredients.add("spinach");
        ingredients.add("blue cheese");
        return ingredients;
    }

    @Test
    public void verifyIngredientIsRemovedFromList() {
        ArrayList<String> recipeIngredients = recipeElements();
        recipeIngredients.remove("blue cheese");

        boolean isIngredientInRecipe = recipeIngredients.contains("blue cheese");

        assertFalse(isIngredientInRecipe,
                "'Blue cheese' should have been removed from the recipe!");
    }

    @Test
    public void verifyNumberIsNotNegative() {
        int number = 120;

        boolean isNumberNegative = number < 0;

        assertFalse(isNumberNegative, "Number should not be negative!");
    }
}