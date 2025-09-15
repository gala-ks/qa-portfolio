package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {

    private final WebDriver driver;

    // Locators
    private final By figureBox = By.className("figure");
    private final By boxCaption = By.className("figcaption");

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @param index starts at 1 but the List index starts with 0
     */
    public FigureCaption hoverOverFigure(int index) {
        WebElement figure = driver.findElements(figureBox).get(index - 1);

        // Actions class uses Building pattern - chaining multiple methods and
        // executing them at once by calling .perform();
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();

        // Find a child element from a parent
        return new FigureCaption(figure.findElement(boxCaption));
    }

    /**
     * This class covers the following Web Element:
     * <div class="figcaption">
     *      <h5>name: user2</h5>
     *      <a href="/users/2">View profile</a>
     * </div>
     */
    public class FigureCaption{

        private final WebElement caption;
        private final By header = By.tagName(("h5"));
        private final By link = By.tagName("a");

        public FigureCaption(WebElement caption) {
            this.caption = caption;
        }

        public boolean isCaptionDisplayed() {
            return caption.isDisplayed();
        }

        public String getTitle() {
            return caption.findElement(header).getText();
        }

        public String getLink() {
            return caption.findElement(link).getAttribute("href");
        }

        public String getLinkText() {
            return caption.findElement(link).getText();
        }
    }
}
