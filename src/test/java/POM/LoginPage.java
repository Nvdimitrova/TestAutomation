package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private final String LOGIN_PAGE_URL = "/users/login";

    String loginFormTitle_locator = "//p[contains(text(),'Sign in')]";
    String loginFormUsernameInputField_locator = "defaultLoginFormUsername";
    String loginFormPasswordInputField_locator = "defaultLoginFormPassword";
    String loginFormRememberMeCheckBoxLabelText_locator = "//span[contains(text(),'Remember me')]";
    String loginFormRememberMeCheckBox_locator = "//input[contains(@formcontrolname,'rememberMe')]";
    String loginFormSubmitButton_locator = "sign-in-button";
    String loginFormRegistrationLink_locator = "//a[contains(text(),'Register')]";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLoginPage() {
        navigateTo(LOGIN_PAGE_URL);
    }

    public String getLoginFormTitle() {
        WebElement loginFormTitle = driver.findElement(By.xpath(loginFormTitle_locator));
        return loginFormTitle.getText();
    }

    public void verifyLoginFormTitle(String expectedTitle) {
        String actualTitle = getLoginFormTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification successful!");
        } else {
            throw new AssertionError("Login form title mismatch! Expected: "
                    + expectedTitle + ", but found: " + actualTitle);
        }
    }

    public void provideUsername(String usernameOrEmail) {
        WebElement usernameInputField = driver.findElement(By.id(loginFormUsernameInputField_locator));
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        usernameInputField.clear();
        usernameInputField.sendKeys(usernameOrEmail);
    }

    public void providePassword(String password) {
        WebElement passwordInputField = driver.findElement(By.id(loginFormPasswordInputField_locator));
        wait.until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }

    public String getRememberMeCheckBoxText() {
        WebElement rememberMeCheckBoxText = driver.findElement(By.xpath(loginFormRememberMeCheckBoxLabelText_locator));
        return rememberMeCheckBoxText.getText();
    }

    public void verifyRememberMeCheckBoxText(String expectedText) {
        String actualText = getRememberMeCheckBoxText();
        if (actualText.equals(expectedText)) {
            System.out.println("Title verification successful!");
        } else {
            throw new AssertionError("Check box text mismatch! Expected: "
                    + expectedText + ", but found: " + actualText);
        }
    }

    public void clickOnRememberMeCheckbox() {
        WebElement rememberMeCheckbox= driver.findElement(By.xpath(loginFormRememberMeCheckBox_locator));
        rememberMeCheckbox.click();
    }

    public void clickOnSubmitButton() {
        WebElement signInFormSubmitButton = driver.findElement(By.id(loginFormSubmitButton_locator));
        wait.until(ExpectedConditions.elementToBeClickable(signInFormSubmitButton));
        signInFormSubmitButton.click();
    }
}