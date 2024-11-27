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
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void initBrowser() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testRegistrationForm() throws InterruptedException {
        //Open ISkillo Registration URL
        driver.get("http://training.skillo-bg.com:4200/users/register");

        //Validate Sign up form is visible
        WebElement signUpElement = driver.findElement(By.xpath("//h4[text()='Sign up']"));
        Assert.assertTrue(signUpElement.isDisplayed(), "The 'Sign up' form is not displayed!");

        //Enter valid username
        WebElement userNameInputField = driver.findElement(By.xpath("//input[contains(@placeholder, 'Username')]"));
        userNameInputField.clear();
        userNameInputField.sendKeys("Nikol VD");
        Thread.sleep(1111);

        //Enter valid email address
        WebElement emailAddressInputField = driver.findElement(By.xpath("//input[contains(@placeholder, 'email')]"));
        emailAddressInputField.clear();
        emailAddressInputField.sendKeys("nikolvd3@abv.bg");
        Thread.sleep(1111);

        //Enter valid password
        WebElement passwordInputField = driver.findElement(By.id("defaultRegisterFormPassword"));
        passwordInputField.clear();
        passwordInputField.sendKeys("EnteringMyPassword");
        Thread.sleep(1111);

        //Confirm password
        WebElement confirmPasswordInputField = driver.findElement(By.id("defaultRegisterPhonePassword"));
        confirmPasswordInputField.clear();
        confirmPasswordInputField.sendKeys("EnteringMyPassword");
        Thread.sleep(1111);

        //Check sign in button is enabled
        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        Assert.assertTrue(signInButton.isEnabled(), "The 'Sign in' button is not enabled, so it cannot be clicked!");

        //Click on sign in button
        signInButton.click();

        Thread.sleep(3333);
    }

    //Shut down the browser
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}