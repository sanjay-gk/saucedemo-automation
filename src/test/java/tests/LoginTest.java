package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
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
    
    @Test
    public void testEmptyLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLogin();

        String errorMessage = loginPage.getErrorMessage();

        Assert.assertTrue(
            errorMessage.contains("Username is required")
        );
    }
    
    @Test
    public void testLogout() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.logout();

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed()
        );
    }
}