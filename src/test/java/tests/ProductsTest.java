package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class ProductsTest extends BaseTest {

    @Test
    public void testSortProductsLowToHigh() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.sortByPriceLowToHigh();

        double firstPrice = productsPage.getFirstProductPrice();

        Assert.assertEquals(firstPrice, 7.99);
    }
}