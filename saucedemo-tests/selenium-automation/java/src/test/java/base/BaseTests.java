package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProductsPage;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public abstract class BaseTests {
    private WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    private final String url = "https://www.saucedemo.com/";

    @BeforeClass
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        // Run Chrome in the background.
        //options.addArguments("--headless=new");
        // Disable Chrome’s credential services and password popup prompt
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-password-manager-reauthentication");
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false
        ));

        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void tearDown() {
        // Close the browser and end the session
        driver.quit();
    }

    @BeforeMethod
    public void setupLoginPage() {
        driver.get(url);
        loginPage = new LoginPage(driver);
        setupChildPage();
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

    protected void setupChildPage() {
    }
}
