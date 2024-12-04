package skillowebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTests {
    private static final String HOME_PAGE_URL = "http://training.skillo-bg.com:4300/posts/all";
    private static final String LOGIN_PAGE_URL = "http://training.skillo-bg.com:4300/users/login";
    private static final String USERNAME = "Nikol VD";
    private static final String PASSWORD = "EnteringMyPassword";

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeMethod
    public void initBrowser() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testUserCanAccessLoginPage() {
        //Step 1. Navigate to the iSkillo home page
        driver.get(HOME_PAGE_URL);

        //Step 1.1. Click on the Login link in the navigation bar
        WebElement navigationBarLoginLink = driver.findElement(By.cssSelector("#nav-link-login"));
        navigationBarLoginLink.click();

        //Step 2. Verify the Login page is displayed
        wait.until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL);
    }

    @Test
    public void testUserCanSignInWithValidCredentials() {
        //Step 1. Navigate to the Login page
        driver.get(LOGIN_PAGE_URL);

        //Step 1.1. Verify the Sign in form title
        WebElement signInFormTitle = driver.findElement(By.xpath("//p[contains(text(),'Sign in')]"));
        String expectedSignInFormTitleText = "Sign in";
        String actualSignInFormTitleText = signInFormTitle.getText();
        Assert.assertEquals(actualSignInFormTitleText, expectedSignInFormTitleText);

        //Step 1.1.1. Verify placeholder for username or email
        WebElement usernameOrEmailInputFieldPlaceholder = driver.findElement(By.cssSelector("#defaultLoginFormUsername"));
        String expectedPlaceholderForUsernameOrEmail = "Username or email";
        String actualPlaceholderForUsernameOrEmail = usernameOrEmailInputFieldPlaceholder.getAttribute("placeholder");
        Assert.assertEquals(actualPlaceholderForUsernameOrEmail, expectedPlaceholderForUsernameOrEmail);

        //Step 1.1.2. Verify placeholder for password
        WebElement passwordInputFieldPlaceholder = driver.findElement(By.cssSelector("#defaultLoginFormPassword"));
        String expectedPlaceholderForPassword = "Password";
        String actualPlaceholderForPassword = passwordInputFieldPlaceholder.getAttribute("placeholder");
        Assert.assertEquals(actualPlaceholderForPassword, expectedPlaceholderForPassword);

        //Step 2. Provide user credentials
        //Step 2.1. Enter valid username
        WebElement usernameInputField = driver.findElement(By.id("defaultLoginFormUsername"));
        usernameInputField.clear();
        usernameInputField.sendKeys(USERNAME);

        //Step 2.2. Enter valid password
        WebElement passwordInputField = driver.findElement(By.id("defaultLoginFormPassword"));
        passwordInputField.clear();
        passwordInputField.sendKeys(PASSWORD);

        //Step 3. Verify Remember me checkbox is displayed and not selected by default
        WebElement rememberMeCheckbox = driver.findElement(By.xpath("//input[contains(@formcontrolname,'rememberMe')]"));
        Assert.assertTrue(rememberMeCheckbox.isDisplayed());
        Assert.assertFalse(rememberMeCheckbox.isSelected());

        //Step 3.1. Click on the Remember me checkbox
        rememberMeCheckbox.click();

        //Step 3.2. Verify Remember me checkbox is selected
        Assert.assertTrue(rememberMeCheckbox.isSelected());

        //Step 4. Click on Sign in submit button
        WebElement signInFormSubmitButton = driver.findElement(By.id("sign-in-button"));
        wait.until(ExpectedConditions.elementToBeClickable(signInFormSubmitButton));
        signInFormSubmitButton.click();

        //Step 5. Verify user is redirected to the Posts page
        wait.until(ExpectedConditions.urlToBe(HOME_PAGE_URL));
        Assert.assertEquals(driver.getCurrentUrl(), HOME_PAGE_URL);

        //Step 5.1. Verify Profile link is displayed
        WebElement navigationBarProfileLink = driver.findElement(By.id("nav-link-profile"));
        Assert.assertTrue(navigationBarProfileLink.isDisplayed());

        //Step 5.2. Verify New Post link is displayed
        WebElement navigationBarNewPostLink = driver.findElement(By.id("nav-link-new-post"));
        Assert.assertTrue(navigationBarNewPostLink.isDisplayed());

        //Step 5.3. Verify Search bar placeholder
        WebElement navigationBarSearchContainer = driver.findElement(By.id("search-bar"));
        String expectedNavBarSearchPlaceholder = "Search";
        String actualNavBarSearchPlaceholder = navigationBarSearchContainer.getAttribute("placeholder");
        Assert.assertEquals(actualNavBarSearchPlaceholder, expectedNavBarSearchPlaceholder);

        //Step 6. Sign out
        WebElement navigationBarSignOutLink = driver.findElement(By.xpath("//i[contains(@class,'fas fa-sign-out-alt fa-lg')]"));
        navigationBarSignOutLink.click();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
