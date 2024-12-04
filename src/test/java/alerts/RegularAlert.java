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

public class RegularAlert {
    private static final String ALERTS_URL = "https://the-internet.herokuapp.com/javascript_alerts";

    private static final String EXPECTED_ALERT_MESSAGE = "I am a JS Alert";
    private static final String RESULT_MESSAGE = "You successfully clicked an alert";

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeTest
    public void initBrowser() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void regularAlertInteraction() throws InterruptedException {
        //1. Navigate to the alerts website
        driver.get(ALERTS_URL);

        //2. Verify "Click for JS Alert" button is displayed and clickable
        WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
        wait.until(ExpectedConditions.visibilityOf(alertButton));
        wait.until(ExpectedConditions.elementToBeClickable(alertButton));
        Thread.sleep(777);

        //2.1. Click the JS Alert button
        alertButton.click();

        //3. Interact with the alert
        //3.1. Wait for the alert to appear
        wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(777);
        // 3.2. Switch focus to the alert
        Alert alert = driver.switchTo().alert();
        //3.3. Read the alert text
        System.out.println("The prompt alert text is: " + alert.getText());
        //3.3.1. Verify the alert message text
        Assert.assertEquals(alert.getText(), EXPECTED_ALERT_MESSAGE);
        //3.4. Accept the message
        alert.accept();
        Thread.sleep(777);

        //4 Check result message text
        WebElement resultMessageCheck = driver.findElement(By.cssSelector("#result"));
        String actualMessage = resultMessageCheck.getText();
        Assert.assertEquals(actualMessage, RESULT_MESSAGE);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
