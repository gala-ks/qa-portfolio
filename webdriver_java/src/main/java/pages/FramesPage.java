package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {

    private final WebDriver driver;
    private final By nestedFramesLink = By.linkText("Nested Frames");

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public NestedFramesPage clickNestedFrames() {
        driver.findElement(nestedFramesLink).click();
        return new NestedFramesPage(driver);
    }
}
