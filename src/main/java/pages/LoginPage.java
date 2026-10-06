package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class LoginPage extends BasePage {

    private By usernameTextBox = By.id("user-name");
    private By passwordTextBox = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        type(usernameTextBox, username);
    }

    public void enterPassword(String password) {
        type(passwordTextBox, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String username, String password) {

        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}