package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class CheckoutCompletePage {

    private final WebDriver driver;
    private final By backHomeButton = By.id("back-to-products");
    private final By completeHeader = By.className("complete-header");
    private final By completeText = By.className("complete-text");
    private final By ponyExpressImage = By.className("pony_express");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductsPage clickBackHome() {
        driver.findElement(backHomeButton).click();
        return new ProductsPage(driver);
    }

    public String getCompleteHeader() {
        return driver.findElement(completeHeader).getText();
    }

    public String getCompleteText() {
        return driver.findElement(completeText).getText();
    }

    public boolean isPonyExpressImageDisplayed() {
        return driver.findElement(ponyExpressImage).isDisplayed();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isOnCheckoutCompletePage() {
        return Objects.requireNonNull(driver.getCurrentUrl()).contains("checkout-complete");
    }
}
