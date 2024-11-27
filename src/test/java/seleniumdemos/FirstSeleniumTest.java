package seleniumdemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    @Test
    public void getStartedWithChromeDriver() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Nikol\\Downloads\\chromedriver-win64.zip\\chromedriver.exe");

        Thread.sleep(4444);

        driver.get("https://www.google.bg/");

        Thread.sleep(4444);
    }
}
