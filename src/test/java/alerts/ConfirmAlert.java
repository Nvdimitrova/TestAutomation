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

public class ConfirmAlert {
    private static final String ALERTS_URL = "https://the-internet.herokuapp.com/javascript_alerts";
    private static final String EXPECTED_ALERT_MESSAGE = "I am a JS Confirm";

    private static final String RESULT_MESSAGE_ACCEPTED = "You clicked: Ok";
    private static final String RESULT_MESSAGE_DISMISS = "You clicked: Cancel";


    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeTest
    public void initBrowser() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void confirmAlertInteraction() {
        //1. Navigate to the alerts website
        driver.get(ALERTS_URL);

        //2. Verify "Click for JS Confirm" button is displayed and clickable
        WebElement confirmAlertButton = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
        wait.until(ExpectedConditions.visibilityOf(confirmAlertButton));
        wait.until(ExpectedConditions.elementToBeClickable(confirmAlertButton));

        //2.1. Click the JS Prompt button
        confirmAlertButton.click();

        //3. Interact with the alert
        //3.1. Wait for the alert to appear
        wait.until(ExpectedConditions.alertIsPresent());
        // 3.2. Switch focus to the alert
        Alert confirmAlert = driver.switchTo().alert();
        //3.3. Read the alert text
        System.out.println("The prompt alert text is: " + confirmAlert.getText());
        //3.3.1. Verify the alert message text
        Assert.assertEquals(confirmAlert.getText(), EXPECTED_ALERT_MESSAGE);
        //3.4. Accept the message
        confirmAlert.accept();

        //4. Check result message text
        WebElement resultMessageCheck = driver.findElement(By.cssSelector("#result"));
        String actualMessage = resultMessageCheck.getText();
        Assert.assertEquals(actualMessage, RESULT_MESSAGE_ACCEPTED);

        /*
        //3.4. Dismiss the message
        confirmAlert.dismiss();

        //4. Check result message text
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
