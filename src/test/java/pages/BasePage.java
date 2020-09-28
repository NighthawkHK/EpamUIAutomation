package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait initExplicitWait(long TimeOut) {
        WebDriverWait wait = new WebDriverWait(driver, TimeOut);
        return wait;
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

}
