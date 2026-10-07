package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class LoginPage extends BasePage {

    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String usernameText) {
        driver.findElement(username).sendKeys(usernameText);
    }

    public void enterPassword(String passwordText) {
        driver.findElement(password).sendKeys(passwordText);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void login(String usernameText, String passwordText) {
        enterUsername(usernameText);
        enterPassword(passwordText);
        clickLogin();
    }

    public boolean isLoginPageDisplayed() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(username)
        ).isDisplayed();
    }
}