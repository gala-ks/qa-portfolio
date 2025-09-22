package util;

import org.openqa.selenium.WebDriver;

public class WindowNavigation {

    private final WebDriver driver;
    private final WebDriver.Navigation navigator;

    public WindowNavigation(WebDriver driver) {
        this.driver = driver;
        this.navigator = driver.navigate();
    }

    public void goBack() {
        navigator.back();
    }

    public void goForward() {
        navigator.forward();
    }

    public void refreshPage() {
        navigator.refresh();
    }

    public void goTo(String url) {
        navigator.to(url);
    }

    public void switchToTab(String tabTitle) {
        var windows = driver.getWindowHandles();
        System.out.println("Number of tabs: " + windows.size());
        System.out.println("Window handles:");
        windows.forEach(System.out::println);

        for(String window : windows) {
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);

            System.out.println("Current window title: " + driver.getTitle());
            if(driver.getTitle().equals(tabTitle)) {
                break;
            }
        }
    }

    public void switchToNewTab(){
        var windows = driver.getWindowHandles();
        windows.forEach(driver.switchTo()::window);
    }
}
