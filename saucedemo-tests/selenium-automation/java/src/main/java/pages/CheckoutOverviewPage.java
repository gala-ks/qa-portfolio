package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

    private final WebDriver driver;
    private final By finishButton = By.id("finish");
    private final By cancelButton = By.id("cancel");
    private final By itemTotalLabel = By.className("summary_subtotal_label");
    private final By taxLabel = By.className("summary_tax_label");
    private final By totalLabel = By.className("summary_total_label");
    private final By cartItems = By.className("cart_item");
    private final By pageTitle = By.className("title");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

}
