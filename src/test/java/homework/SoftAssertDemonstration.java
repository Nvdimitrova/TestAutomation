package homework;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemonstration {
    @Test
    public void verifyBooleanConditions() {
        SoftAssert assertions = new SoftAssert();

        assertions.assertTrue(5 > 10, "First condition failed");
        assertions.assertTrue(10 > 5, "Second condition failed");
        assertions.assertFalse(2 > 1, "Third condition failed");

        assertions.assertAll();
    }

    public boolean isSignUpButtonVisible() {
        return false;
    }

    public boolean isLoginButtonVisible() {
        return true;
    }

    public boolean isLogoutButtonVisible() {
        return false;
    }

    @Test
    public void verifyAllButtonsAreVisible() {
        SoftAssert assertions = new SoftAssert();

        assertions.assertTrue(isSignUpButtonVisible(), "Sign Up button should be visible");
        assertions.assertTrue(isLoginButtonVisible(), "Login button should be visible");
        assertions.assertTrue(isLogoutButtonVisible(), "Logout button should be visible");

        assertions.assertAll();
    }

    @Test
    public void verifyCalculations() {
        SoftAssert assertions = new SoftAssert();

        assertions.assertEquals(13 + 37, 50, "Addition test failed");
        assertions.assertEquals(5 * 10, 50, "Multiplication test failed");
        assertions.assertEquals(50 / 10, 5, "Division test failed");

        assertions.assertAll();
    }

    @Test
    public void verifyURLs() {
        SoftAssert assertions = new SoftAssert();

        String firstWebsiteURL = "https://github.com";
        String secondWebsiteURL = "http://httpforever.com";


        assertions.assertTrue(firstWebsiteURL.startsWith("https"),
                "First URL should start with 'https': " + firstWebsiteURL);
        assertions.assertTrue(secondWebsiteURL.startsWith("https"),
                "Second URL should start with 'https': " + secondWebsiteURL);

        assertions.assertAll();
    }

    public String getLoginMessage() {
        return "Hello!";
    }

    public String getLogoutMessage() {
        return "Goodbye!";
    }

    @Test
    public void verifyStringsAreEqual() {
        SoftAssert assertions = new SoftAssert();

        assertions.assertEquals(getLoginMessage(), "Welcome!",
                "Login message does not match the expected value");
        assertions.assertEquals(getLogoutMessage(), "Goodbye!",
                "Logout message does not match the expected value");

        assertions.assertAll();
    }
}