package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

    private final WebDriver driver;
    private final By sliderRange = By.tagName("input");
    private final By sliderValue = By.tagName("span");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSliderRange(String range) {
        while (!getSliderValue().equals(range)) {
            driver.findElement(sliderRange).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getSliderValue() {
        return driver.findElement(sliderValue).getText();
    }
}
