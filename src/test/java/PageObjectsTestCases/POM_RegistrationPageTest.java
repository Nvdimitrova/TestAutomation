package PageObjectsTestCases;

import POM.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class POM_RegistrationPageTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @Test
    public void testUserCanRegisterWithValidCredentials() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        //Step 1. Navigate to the registration page
        registrationPage.navigateToRegistrationPage();

        //Step 1.1. Verify the registration form title
        String expectedTitle = "Sign up";
        registrationPage.verifyRegistrationFormTitle(expectedTitle);

        //Step 2. Provide user credentials
        //Step 2.1. Enter valid username
        String username = "Nikol Test";
        registrationPage.provideUsername(username);

        //2.2. Enter valid email
        String email = "nikolTest@abv.bg";
        registrationPage.provideEmail(email);

        //2.3. Enter birthdate
        String birthdate = "07012000";
        registrationPage.provideBirthdate(birthdate);

        //Step 2.4. Enter password
        String password = "EnteringMyPassword1";
        registrationPage.providePassword(password);

        //Step 2.4. Confirm password
        String confirmPassword = "EnteringMyPassword1";
        registrationPage.confirmPassword(confirmPassword);

        //Step 2.5. Enter public info
        String publicInfo = "Public info test";
        registrationPage.providePublicInfo(publicInfo);

        //Step 3. Click on Sign in submit button
        registrationPage.clickOnSubmitButton();

        //Step 4. Verify toast message
        String expectedToastMessageText = "Successful register";
        String actualToastMessageText = registrationPage.getToastMessageText();
        Assert.assertEquals(actualToastMessageText, expectedToastMessageText);
    }

    @Test
    public void testUserCannotRegisterWithTakenEmail() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        //Step 1. Navigate to the registration page
        registrationPage.navigateToRegistrationPage();

        //Step 2. Provide user credentials
        //Step 2.1. Enter valid username
        String username = "Nikol V D";
        registrationPage.provideUsername(username);

        //2.2. Enter taken email
        String email = "nikolvd3@abv.bg";
        registrationPage.provideEmail(email);

        //2.3. Enter birthdate
        String birthdate = "07012000";
        registrationPage.provideBirthdate(birthdate);

        //Step 2.4. Enter password
        String password = "EnteringMyPassword1";
        registrationPage.providePassword(password);

        //Step 2.4. Confirm password
        String confirmPassword = "EnteringMyPassword1";
        registrationPage.confirmPassword(confirmPassword);

        //Step 2.5. Enter public info
        String publicInfo = "Hello, world!";
        registrationPage.providePublicInfo(publicInfo);

        //Step 3. Click on Sign in submit button
        registrationPage.clickOnSubmitButton();

        //Step 4. Verify toast message
        String expectedToastMessageText = "Email taken";
        String actualToastMessageText = registrationPage.getToastMessageText();
        Assert.assertEquals(actualToastMessageText, expectedToastMessageText);
    }

    @Test
    public void testUserCannotRegisterWithTakenUsername() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        //Step 1. Navigate to the registration page
        registrationPage.navigateToRegistrationPage();

        //Step 2. Provide user credentials
        //Step 2.1. Enter taken username
        String username = "Nikol";
        registrationPage.provideUsername(username);

        //2.2. Enter valid email
        String email = "nikol3@abv.bg";
        registrationPage.provideEmail(email);

        //2.3. Enter birthdate
        String birthdate = "07012000";
        registrationPage.provideBirthdate(birthdate);

        //Step 2.4. Enter password
        String password = "EnteringMyPassword1";
        registrationPage.providePassword(password);

        //Step 2.4. Confirm password
        String confirmPassword = "EnteringMyPassword1";
        registrationPage.confirmPassword(confirmPassword);

        //Step 2.5. Enter public info
        String publicInfo = "Hello, world!";
        registrationPage.providePublicInfo(publicInfo);

        //Step 3. Click on Sign in submit button
        registrationPage.clickOnSubmitButton();

        //Step 4. Verify toast message
        String expectedToastMessageText = "Username taken";
        String actualToastMessageText = registrationPage.getToastMessageText();
        Assert.assertEquals(actualToastMessageText, expectedToastMessageText);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}