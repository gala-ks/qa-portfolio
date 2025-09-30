package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;
    private final By checkoutButton = By.id("checkout");
    private final By continueShoppingButton = By.id("continue-shopping");
    private final By cartItems = By.className("cart_item");
    private final By cartBadge = By.className("shopping_cart_badge");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContinueShopping() {
        driver.findElement(continueShoppingButton).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public int getCartItemsCount() {
        return driver.findElements(cartItems).size();
    }

    public boolean isCartBadgeDisplayed() {
        return !driver.findElements(cartBadge).isEmpty();
    }

    public String getCartBadgeText() {
        return isCartBadgeDisplayed() ? driver.findElement(cartBadge).getText() : "";
    }

    public boolean isCheckoutButtonEnabled() {
        return driver.findElement(checkoutButton).isEnabled();
    }

}
