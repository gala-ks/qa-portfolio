package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {

    public WebDriver driver;
    public final By bikeLightAddToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    public final By backpackAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    public final By bikeLightRemoveFromCartButton = By.id("remove-sauce-labs-bike-light");
    public final By backpackRemoveFromCartButton = By.id("remove-sauce-labs-backpack");
    public final By cartLink = By.className("shopping_cart_link");
    public final By cartBadge = By.className("shopping_cart_badge");
    public final By pageTitle = By.cssSelector("span.title");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void addBikeLightToCart() {
        driver.findElement(bikeLightAddToCartButton).click();
    }

    public void addBackpackToCart() {
        driver.findElement(backpackAddToCartButton).click();
    }

    public void removeBikeLightFromCart() {
        driver.findElement(bikeLightRemoveFromCartButton).click();
    }

    public void removeBackpackFromCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(backpackRemoveFromCartButton));
        button.click();
//      driver.findElement(backpackRemoveFromCartButton).click();
    }

    public int getCartItemCount() {
        WebElement cartElement = driver.findElement(cartLink);
        List<WebElement> badgeElements = cartElement.findElements(cartBadge);
        if (badgeElements.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(badgeElements.get(0).getText());
    }

    public CartPage clickCartLink() {
        driver.findElement(cartLink).click();
        return new CartPage(driver);
    }
}
