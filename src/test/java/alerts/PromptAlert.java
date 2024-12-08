package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class PromptAlert {
    private static final String ALERTS_URL = "https://the-internet.herokuapp.com/javascript_alerts";

    private static final String EXPECTED_ALERT_MESSAGE = "I am a JS prompt";
    private static final String MY_MESSAGE = "My first alert message!";
    private static final String RESULT_MESSAGE_ACCEPTED = "You entered: " + MY_MESSAGE;
    private static final String RESULT_MESSAGE_DISMISS = "You entered: null";


    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeTest
    public void initBrowser() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void promptAlertInteraction() {
        //1. Navigate to the alerts website
        driver.get(ALERTS_URL);

        //2. Verify "Click for JS Prompt" button is displayed and clickable
        WebElement promptAlertButton = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
        wait.until(ExpectedConditions.visibilityOf(promptAlertButton));
        wait.until(ExpectedConditions.elementToBeClickable(promptAlertButton));

        //2.1. Click the JS Prompt button
        promptAlertButton.click();

        //3. Interact with the alert
        //3.1. Wait for the alert to appear
        wait.until(ExpectedConditions.alertIsPresent());
        // 3.2. Switch focus to the alert
        Alert promptAlert = driver.switchTo().alert();
        //3.3. Read the alert text
        System.out.println("The prompt alert text is: " + promptAlert.getText());
        //3.3.1. Verify the alert message text
        Assert.assertEquals(promptAlert.getText(), EXPECTED_ALERT_MESSAGE);
        //3.4. Enter message in the prompt alert
        promptAlert.sendKeys(MY_MESSAGE);
        //3.5. Accept the message
        promptAlert.accept();

        //4. Check result message text is the same as entered
        WebElement resultMessageCheck = driver.findElement(By.cssSelector("#result"));
        String actualMessage = resultMessageCheck.getText();
        Assert.assertEquals(actualMessage, RESULT_MESSAGE_ACCEPTED);

        /*
        //3.5. Dismiss the message
        promptAlert.dismiss();

        //4. Check result message text is the same as entered
        WebElement resultMessageCheck = driver.findElement(By.cssSelector("#result"));
        String actualMessage = resultMessageCheck.getText();
        Assert.assertEquals(actualMessage, RESULT_MESSAGE_DISMISS);
         */
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
