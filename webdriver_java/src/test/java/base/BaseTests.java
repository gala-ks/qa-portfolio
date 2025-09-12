package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

/**
 * JUnit 5
 */
public class BaseTests
{
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);

//        driver.manage().window().setSize(new Dimension(375, 667));
//
//        WebElement shiftingContentLink = driver.findElement(By.linkText("Shifting Content"));
//        shiftingContentLink.click();
//
//        WebElement exampleLink = driver.findElement(By.partialLinkText("Example 1"));
//        exampleLink.click();
//
//        List<WebElement> menuList = driver.findElements(By.tagName("li"));
//        System.out.println(menuList.size());
//        for(WebElement menuItem : menuList) {
//            System.out.println(menuItem.getText());
//        }
    }

    @AfterClass
    public void tearDown() {

        // Closes window and session vs. driver.close() that leaves sesssion open.
        driver.quit();
    }

    public static void main(String[] arg){
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
