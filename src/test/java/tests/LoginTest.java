package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        Assert.assertEquals(
                driver.getTitle(),
                "Swag Labs"
        );
    }
    
    @Test
    public void testInvalidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("wrong_user", "wrong_password");

        String errorMessage = loginPage.getErrorMessage();

        Assert.assertTrue(errorMessage.contains("Username and password do not match"));
    }
}