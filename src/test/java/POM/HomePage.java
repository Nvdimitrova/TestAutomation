package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {
    private final String HOME_PAGE_URL = "/posts/all";

    //Home page locators
    String navigationBarHomeLink_locator = "nav-link-home";
    String navigationBarLoginLink_locator = "nav-link-login";
    String navigationBarProfileLink_locator = "nav-link-profile";
    String navigationBarNewPostLink_locator = "nav-link-new-post";
    String navigationBarSearchBarInputField_locator = "search-bar";
    String navigationBarLogOutButton_locator = "//i[contains(@class,'fas fa-sign-out-alt fa-lg')]";


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        navigateTo(HOME_PAGE_URL);
    }

    public void clickOnNavigationBarHomeLink() {
        WebElement navigationBarHomeLink = driver.findElement(By.id(navigationBarHomeLink_locator));
        wait.until(ExpectedConditions.visibilityOf(navigationBarHomeLink));
        navigationBarHomeLink.click();
    }

    public void clickOnNavigationBarLoginLink() {
        WebElement navigationBarLoginLink = driver.findElement(By.id(navigationBarLoginLink_locator));
        wait.until(ExpectedConditions.visibilityOf(navigationBarLoginLink));
        navigationBarLoginLink.click();
    }

    public void clickOnNavigationBarProfileLink() {
        WebElement navigationBarProfileLink = driver.findElement(By.id(navigationBarProfileLink_locator));
        wait.until(ExpectedConditions.visibilityOf(navigationBarProfileLink));
        navigationBarProfileLink.click();
    }

    public void clickOnNavigationBarNewPostLink() {
        WebElement navigationBarNewPostLink = driver.findElement(By.id(navigationBarNewPostLink_locator));
        wait.until(ExpectedConditions.visibilityOf(navigationBarNewPostLink));
        navigationBarNewPostLink.click();
    }

    public void provideTextInSearchBarInputField(String text) {
        WebElement searchBarInputField = driver.findElement(By.id(navigationBarSearchBarInputField_locator));
        wait.until(ExpectedConditions.visibilityOf(searchBarInputField));
        searchBarInputField.clear();
        searchBarInputField.sendKeys(text);
    }

    public void clickOnNavigationBarLogOutButton() {
        WebElement navigationBarLogOutButton = driver.findElement(By.id(navigationBarLogOutButton_locator));
        wait.until(ExpectedConditions.visibilityOf(navigationBarLogOutButton));
        navigationBarLogOutButton.click();
    }
}