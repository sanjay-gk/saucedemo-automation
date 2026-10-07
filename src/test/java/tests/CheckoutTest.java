package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCompleteCheckout() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.addProductToCart();

        CartPage cartPage = new CartPage(driver);

        cartPage.openCart();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.clickCheckout();

        checkoutPage.enterCustomerDetails(
                "Sanjay",
                "GK",
                "560001"
        );

        checkoutPage.clickContinue();

        checkoutPage.clickFinish();

        Assert.assertEquals(
                checkoutPage.getSuccessMessage(),
                "Thank you for your order!"
        );
    }
}