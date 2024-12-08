package PageObjectsTestCases;

import POM.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class POM_LoginPageTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @Test
    public void testUserCanLoginInWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        //Step 1. Navigate to the Login page
        loginPage.navigateToLoginPage();

        //Step 1.1. Verify the Login form title
        String expectedTitle = "Sign in";
        loginPage.verifyLoginFormTitle(expectedTitle);

        //Step 2. Provide user credentials
        //Step 2.1. Enter valid username
        String username = "Nikol VD";
        loginPage.provideUsername(username);

        //Step 2.2. Enter valid password
        String password = "EnteringMyPassword";
        loginPage.providePassword(password);

        //Step 3. Verify Remember me checkbox text
        String expectedText = "Remember me";
        loginPage.verifyRememberMeCheckBoxText(expectedText);

        //Step 3.1. Click on Remember me checkbox
        loginPage.clickOnRememberMeCheckbox();

        //Step 4. Click on Sign in submit button
        loginPage.clickOnSubmitButton();

        //Step 5. Verify toast message
        String expectedToastMessageText = "Successful login!";
        String actualToastMessageText = loginPage.getToastMessageText();
        Assert.assertEquals(actualToastMessageText, expectedToastMessageText);
    }

    @Test
    public void testUserCannotLoginInWithWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);

        //Step 1. Navigate to the Login page
        loginPage.navigateToLoginPage();

        //Step 2. Provide user credentials
        //Step 2.1. Enter valid username
        String username = "Nikol VD";
        loginPage.provideUsername(username);

        //Step 2.2. Enter wrong password
        String password = "WrongPassword";
        loginPage.providePassword(password);

        //Step 3. Click on Remember me checkbox
        loginPage.clickOnRememberMeCheckbox();

        //Step 4. Click on Sign in submit button
        loginPage.clickOnSubmitButton();

        //Step 5. Verify toast message
        String expectedToastMessageText = "Wrong username or password!";
        String actualToastMessageText = loginPage.getToastMessageText();
        Assert.assertEquals(actualToastMessageText, expectedToastMessageText);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}