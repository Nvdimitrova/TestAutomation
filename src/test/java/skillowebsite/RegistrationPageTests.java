package skillowebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationPageTests {
    public static final String HOME_PAGE_URL = "http://training.skillo-bg.com:4200/posts/all";
    public static final String REGISTRATION_FORM_URL = "http://training.skillo-bg.com:4200/users/register";

    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void initBrowser() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testUserCanAccessRegistrationForm() throws InterruptedException {
        //Step 1. Go to iSkillo home page
        driver.get(HOME_PAGE_URL);

        //Step 1.1. Click on navigation bar 'Login' link
        WebElement loginLink = driver.findElement(By.cssSelector("#nav-link-login"));
        loginLink.click();

        //Step 1.2. Click on 'Register' link
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        //Step 2. Verify that the registration form is displayed
        String expectedURL = REGISTRATION_FORM_URL;
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void testUnregisteredUserCanRegister() throws InterruptedException {
        //Step 1. Go to sign up page
        driver.get(REGISTRATION_FORM_URL);

        //Step 1.1. Verify sign up form is visible
        WebElement signUpFormTitle = driver.findElement(By.xpath("//h4[contains(text(),'Sign up')]"));
        String expectedSignUpFormTitle = "Sign up";
        String actualSignUpFormTitle = signUpFormTitle.getText();
        Assert.assertEquals(actualSignUpFormTitle, expectedSignUpFormTitle, "The 'Sign up' form title is not displayed!");

        //Step 1.1.1. Verify placeholder for username
        WebElement usernameInputFieldPlaceholder = driver.findElement(By.xpath("//input[contains(@placeholder, 'Username')]"));
        String expectedPlaceholderForUsername = "Username";
        String actualPlaceholderForUsername = usernameInputFieldPlaceholder.getAttribute("placeholder");
        Assert.assertEquals(actualPlaceholderForUsername, expectedPlaceholderForUsername);

        //Step 1.1.2. Verify placeholder for email
        WebElement emailInputFieldPlaceholder = driver.findElement(By.xpath("//input[contains(@placeholder, 'email')]"));
        String expectedPlaceholderForEmail = "email";
        String actualPlaceholderForEmail = emailInputFieldPlaceholder.getAttribute("placeholder");
        Assert.assertEquals(actualPlaceholderForEmail, expectedPlaceholderForEmail);

        //Step 1.1.3. Verify placeholder for password
        WebElement passwordInputFieldPlaceholder = driver.findElement(By.id("defaultRegisterFormPassword"));
        String expectedPlaceholderForPassword = "Password";
        String actualPlaceholderForPassword = passwordInputFieldPlaceholder.getAttribute("placeholder");
        Assert.assertEquals(actualPlaceholderForPassword, expectedPlaceholderForPassword);

        //Step 1.1.4. Verify placeholder for confirm password
        WebElement confirmPasswordInputFieldPlaceholder = driver.findElement(By.id("defaultRegisterPhonePassword"));
        String expectedPlaceholderForConfirmPassword = "Confirm Password";
        String actualPlaceholderForConfirmPassword = confirmPasswordInputFieldPlaceholder.getAttribute("placeholder");
        Assert.assertEquals(actualPlaceholderForConfirmPassword, expectedPlaceholderForConfirmPassword);


        //Step 2. Provide user credentials
        //Step 2.1. Provide username
        WebElement usernameInputField = driver.findElement(By.xpath("//input[contains(@placeholder, 'Username')]"));
        String USERNAME = "Nikol VD";
        usernameInputField.clear();
        usernameInputField.sendKeys(USERNAME);

        //Step 2.2. Provide email address
        WebElement emailAddressInputField = driver.findElement(By.xpath("//input[contains(@placeholder, 'email')]"));
        String EMAIL = "nikolvd3@abv.bg";
        emailAddressInputField.clear();
        emailAddressInputField.sendKeys(EMAIL);

        //Step 2.3. Provide password
        WebElement passwordInputField = driver.findElement(By.id("defaultRegisterFormPassword"));
        String PASSWORD = "EnteringMyPassword";
        passwordInputField.clear();
        passwordInputField.sendKeys(PASSWORD);

        //Step 2.4. Confirm the password
        WebElement confirmPasswordInputField = driver.findElement(By.id("defaultRegisterPhonePassword"));
        String CONFIRM_PASSWORD = "EnteringMyPassword";
        confirmPasswordInputField.clear();
        confirmPasswordInputField.sendKeys(CONFIRM_PASSWORD);

        //Step 2.5. Click on the sign in form submit button
        WebElement signInFormSubmitButton = driver.findElement(By.id("sign-in-button"));
        signInFormSubmitButton.click();

        //*****************************************************************
        //Step 3. Verify the error message with duplicate username
        WebElement generalAlertMessage = driver.findElement(By.xpath("//div[contains(@class,'toast-message ng-star-inserted')]"));
        String expectedGeneralAlertMessage = "Username taken";
        String actualGeneralAlertMessage = generalAlertMessage.getText();
        Assert.assertEquals(actualGeneralAlertMessage, expectedGeneralAlertMessage);

        Thread.sleep(3000);
    }

    @Test
    public void testRegistrationFailsWithMissingRequiredFields() throws InterruptedException {
        //Step 1. Go to sign up page
        driver.get(REGISTRATION_FORM_URL);

        //Step 2. Provide user credentials partially
        //Step 2.1. Provide username
        WebElement usernameInputField = driver.findElement(By.xpath("//input[contains(@placeholder, 'Username')]"));
        String USERNAME = "Nikol";
        usernameInputField.clear();
        usernameInputField.sendKeys(USERNAME);

        //Step 2.2. Provide password
        WebElement passwordInputField = driver.findElement(By.id("defaultRegisterFormPassword"));
        String PASSWORD = "EnteringMyPassword";
        passwordInputField.clear();
        passwordInputField.sendKeys(PASSWORD);

        //Step 2.3. Confirm the password
        WebElement confirmPasswordInputField = driver.findElement(By.id("defaultRegisterPhonePassword"));
        String CONFIRM_PASSWORD = "EnteringMyPassword";
        confirmPasswordInputField.clear();
        confirmPasswordInputField.sendKeys(CONFIRM_PASSWORD);

        //Step 3. Click on the 'Sign in' button
        WebElement signInFormSubmitButton = driver.findElement(By.id("sign-in-button"));
        signInFormSubmitButton.click();

        //Step 4. Check general alert message
        WebElement generalAlertMessage = driver.findElement(By.xpath("//div[contains(@class,'toast-message ng-star-inserted')]"));
        String expectedGeneralAlertMessage = "Registration failed!";
        String actualGeneralAlertMessage = generalAlertMessage.getText();
        Assert.assertEquals(actualGeneralAlertMessage, expectedGeneralAlertMessage);

        Thread.sleep(3000);
    }

    //Shut down the browser
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}