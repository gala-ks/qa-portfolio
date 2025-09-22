package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxesPage {

    private final WebDriver driver;
    private final By checkbox1 = By.xpath("//form[@id='checkboxes']/input[1]");
    private final By checkbox2 = By.xpath("//form[@id='checkboxes']/input[2]");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setCheckbox1(boolean toCheck) {
        if (toCheck != isCheckbox1Checked()) {
            driver.findElement(checkbox1).click();
        }
    }

    public void setCheckbox2(boolean toCheck) {
        if (toCheck != isCheckbox2Checked()) {
            driver.findElement(checkbox2).click();
        }
    }

    public boolean isCheckbox1Checked() {
        return driver.findElement(checkbox1).isSelected();
    }

    public boolean isCheckbox2Checked() {
        return driver.findElement(checkbox2).isSelected();
    }
}
