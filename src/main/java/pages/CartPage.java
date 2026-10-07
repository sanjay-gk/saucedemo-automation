package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CartPage extends BasePage {

    By cartButton = By.className("shopping_cart_link");
    By removeButton = By.id("remove-sauce-labs-backpack");
    By cartItem = By.className("cart_item");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCart() {
        driver.findElement(cartButton).click();
    }

    public void removeProduct() {

        try {
            driver.findElement(removeButton).click();

        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            driver.findElement(removeButton).click();
        }
    }

    public boolean isProductDisplayed() {
        return driver.findElements(cartItem).size() > 0;
    }
}