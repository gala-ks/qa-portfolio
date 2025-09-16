package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private final WebDriver driver;
    private final By box = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void rightClickBox() {
        WebElement hotSpot = driver.findElement(box);
//      new Actions(driver).moveToElement(hotSpot).contextClick().perform();

        // Could also be done this way:
        new Actions(driver).contextClick(hotSpot).perform();
    }

    public String getContextMenuText() {
        return driver.switchTo().alert().getText();
    }

    public void acceptContextMenu() {
        driver.switchTo().alert().accept();
    }
}
