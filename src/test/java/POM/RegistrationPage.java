package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {
    private final String REGISTRATION_PAGE_URL = "/users/register";

    String registrationFormTitle_locator = "//h4[contains(text(),'Sign up')]";
    String registrationFormUsernameInputField_locator = "//input[contains(@placeholder,'Username')]";
    String registrationFormEmailInputField_locator = "//input[contains(@placeholder,'email')]";
    String registrationFormBirthdateInputField_locator = "//input[contains(@placeholder,'Birth date')]";
    String registrationFormPasswordInputField_locator = "defaultRegisterFormPassword";
    String registrationFormConfirmPasswordInputField_locator = "defaultRegisterPhonePassword";
    String registrationFormPublicInfoField_locator = "//textarea[contains(@placeholder,'Public info')]";
    String registrationFormSubmitButton_locator = "sign-in-button";

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToRegistrationPage() {
        navigateTo(REGISTRATION_PAGE_URL);
    }

    public String getRegistrationFormTitle() {
        WebElement registrationFormTitle = driver.findElement(By.xpath(registrationFormTitle_locator));
        return registrationFormTitle.getText();
    }

    public void verifyRegistrationFormTitle(String expectedTitle) {
        String actualTitle = getRegistrationFormTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification successful!");
        } else {
            throw new AssertionError("Registration form title mismatch! Expected: "
                    + expectedTitle + ", but found: " + actualTitle);
        }
    }

    public void provideUsername(String username) {
        WebElement usernameInputField = driver.findElement(By.xpath(registrationFormUsernameInputField_locator));
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        usernameInputField.clear();
        usernameInputField.sendKeys(username);
    }

    public void provideEmail(String email) {
        WebElement emailInputField = driver.findElement(By.xpath(registrationFormEmailInputField_locator));
        wait.until(ExpectedConditions.visibilityOf(emailInputField));
        emailInputField.clear();
        emailInputField.sendKeys(email);
    }

    public void provideBirthdate(String birthdate) {
        WebElement birthdateInputField = driver.findElement(By.xpath(registrationFormBirthdateInputField_locator));
        wait.until(ExpectedConditions.visibilityOf(birthdateInputField));
        birthdateInputField.clear();
        birthdateInputField.sendKeys(birthdate);
    }

    public void providePassword(String password) {
        WebElement passwordInputField = driver.findElement(By.id(registrationFormPasswordInputField_locator));
        wait.until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }

    public void confirmPassword(String confirmPassword) {
        WebElement confirmPasswordInputField = driver.findElement(By.id(registrationFormConfirmPasswordInputField_locator));
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordInputField));
        confirmPasswordInputField.clear();
        confirmPasswordInputField.sendKeys(confirmPassword);
    }

    public void providePublicInfo(String publicInfo) {
        WebElement publicInfoInputField = driver.findElement(By.xpath(registrationFormPublicInfoField_locator));
        wait.until(ExpectedConditions.visibilityOf(publicInfoInputField));
        publicInfoInputField.clear();
        publicInfoInputField.sendKeys(publicInfo);
    }

    public void clickOnSubmitButton() {
        WebElement registrationFormSubmitButton = driver.findElement(By.id(registrationFormSubmitButton_locator));
        wait.until(ExpectedConditions.elementToBeClickable(registrationFormSubmitButton));
        registrationFormSubmitButton.click();
    }
}