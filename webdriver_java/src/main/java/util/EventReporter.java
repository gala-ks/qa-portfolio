package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class EventReporter implements WebDriverListener{

    @Override
    public void beforeClick(WebElement element) {
        System.out.println("Clicking on: " + element.getText());
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println("Typing in : " + String.join("", keysToSend));
    }

    @Override
    public void beforeIsDisplayed(WebElement element) {
        System.out.println("Checking visibility of: " + element.getText());
    }
}
