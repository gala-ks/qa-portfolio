package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public final WebDriver driver;
    public final By usernameField = By.id("user-name");
    public final By passwordField = By.id("password");
    public final By loginButton = By.id("login-button");
    public final By errorInsert = By.cssSelector("div.error-message-container h3");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username){
          driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public ProductsPage clickLoginButtonSuccessfullFlow() {
        driver.findElement(loginButton).click();
        return new ProductsPage(driver);
    }

    public void clickLoginButtonFailedFlow() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorInsert));
        return error.getText();
    }
}
