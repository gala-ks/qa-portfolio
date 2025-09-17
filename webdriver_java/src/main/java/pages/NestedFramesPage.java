package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {

    private final WebDriver driver;
    private final String outerFrameName = "frame-top";
    private final String leftFrameName = "frame-left";
    private final String bottomFrameName = "frame-bottom";

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLeftFrameText() {
        switchToFrame(outerFrameName);
        switchToFrame(leftFrameName);
        String text = driver.findElement(By.tagName("body")).getText();
        switchToParent();
        switchToParent();
        return text;
    }

    public String getBottomFrameText() {
        switchToFrame(bottomFrameName);
        String text = driver.findElement(By.tagName("body")).getText();
        switchToParent();
        return text;
    }

    private void switchToParent() {
        driver.switchTo().parentFrame();
    }

    private void switchToFrame(String frameName) {
        driver.switchTo().frame(frameName);
    }
}
