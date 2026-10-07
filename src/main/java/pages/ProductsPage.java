package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class ProductsPage extends BasePage {

    By sortDropdown = By.className("product_sort_container");
    By productPrices = By.className("inventory_item_price");
    By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    By cartCount = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void sortByPriceLowToHigh() {

        Select sort = new Select(driver.findElement(sortDropdown));

        sort.selectByVisibleText("Price (low to high)");
    }

    public double getFirstProductPrice() {

        List<WebElement> prices = driver.findElements(productPrices);

        String priceText = prices.get(0).getText();

        return Double.parseDouble(priceText.replace("$", ""));
    }

    public void addProductToCart() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.elementToBeClickable(addToCartButton)
        ).click();
    }

    public String getCartCount() {
        return driver.findElement(cartCount).getText();
    }
}