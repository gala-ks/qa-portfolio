package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {

    private final WebDriver driver;
    private final String editorIframeId = "mce_0_ifr";
    private final By textArea = By.id("tinymce");
    private final By increaseIndentButton = By.xpath(".//button[@title='Increase indent']");

    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clearTextArea() {
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text) {
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    public void increaseIndetation() {
        driver.findElement(increaseIndentButton).click();
    }

    private void switchToEditArea() {
        driver.switchTo().frame(editorIframeId);
    }

    /**
     * Switches back to the page from the iframe
     * for next operations
     */
    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }
}