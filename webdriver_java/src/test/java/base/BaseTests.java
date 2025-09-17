package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import util.EventReporter;
import util.WindowNavigation;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public abstract class BaseTests {
    private WebDriver driver;
    private WebDriver decorated;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();

        /*
          Replace the driver with a decorated driver that uses an event listener to log actions.
          This is a new way to do it in Selenium 4.0+
          See util/EventReporter.java for the event listener class.
          I'm not using it in this project, but it's here to show how it works.
         */
        decorated = new EventFiringDecorator<>(new EventReporter()).decorate(driver);

        /*
          Set a default wait time for finding elements.
          It's better to use explicit waits, but this is included to show how it works.
          Implicit waits are set for the life of the WebDriver instance.
        */
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        goHome();
        homePage = new HomePage(decorated);
//        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() {
        decorated.get("https://the-internet.herokuapp.com/");
//        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void tearDown() {

        // Closes window and session vs. driver.close() that leaves sesssion open.
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
        }
    }

    public WindowNavigation getWindowNavigator() {
        return new WindowNavigation(driver);
    }
}
