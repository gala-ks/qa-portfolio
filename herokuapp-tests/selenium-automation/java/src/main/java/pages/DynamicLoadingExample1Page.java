package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class DynamicLoadingExample1Page {

    private final WebDriver driver;
    private final By startButton = By.cssSelector("#start button");
    private final By loadingIndicator = By.id("loading");
    private final By loadedText = By.id("finish");

    public DynamicLoadingExample1Page(WebDriver driver) {
        this.driver  = driver;
    }

    public void clickStartButton() {
        driver.findElement(startButton).click();

        /*
          Option 1: Waits up to 5 seconds for the loading indicator to disappear.
          If it disappears sooner, execution continues immediately.
          If still visible after 5 seconds, a TimeoutException is thrown.
         */
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIndicator));

        /*
          Option 2: Waits up to 5 seconds for the loading indicator to disappear.
          Checks every 1 second to see if the condition is met.
          Specify the type of exception to ignore while waiting: NoSuchElementException.
         */
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIndicator));
    }

    public String getLoadedText() {
        return driver.findElement(loadedText).getText();
    }
}
