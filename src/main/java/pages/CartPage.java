package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class CartPage extends BasePage {

	By cartButton = By.className("shopping_cart_link");
	By removeButton = By.id("remove-sauce-labs-backpack");
	By cartItem = By.className("cart_item");

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public void openCart() {

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(
	            ExpectedConditions.elementToBeClickable(cartButton)
	    ).click();

	    wait.until(
	            ExpectedConditions.urlContains("cart.html")
	    );
	}

	public void removeProduct() {
	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(
	            ExpectedConditions.elementToBeClickable(removeButton)
	    ).click();
	}

	public boolean isProductDisplayed() {
	    return driver.findElements(cartItem).size() > 0;
	}
}