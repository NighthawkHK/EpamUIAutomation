package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilPageIsComplete(long TimeOut) {
        new WebDriverWait(driver, TimeOut)
                .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public WebDriverWait initExplicitWait(long TimeOut) {
        WebDriverWait wait = new WebDriverWait(driver, TimeOut);
        return wait;
    }
}
