package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class CartTest extends BaseTest {

    @Test
    public void testAddProductToCart() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.addProductToCart();

        Assert.assertEquals(
                productsPage.getCartCount(),
                "1"
        );
    }
}