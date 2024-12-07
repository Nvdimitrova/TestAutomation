package POM;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final String HOME_PAGE_URL = "/posts/all";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        navigateTo(HOME_PAGE_URL);
    }
}