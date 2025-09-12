package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final WebDriver driver;
    private final By emailField = By.id("email");
    private final By retrieveButton = By.id("form_submit");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public EmailSentPage clickRetrieveButton() {
        driver.findElement(retrieveButton).click();
        return new EmailSentPage(driver);
    }
}
