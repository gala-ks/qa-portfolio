package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//todo This page is down, implementation will be completed later
public class EmailSentPage {

    private final WebDriver driver;
    private final By confirmMessage = By.id("???");

    public EmailSentPage(WebDriver driver) {
        this.driver = driver;
    }
}
