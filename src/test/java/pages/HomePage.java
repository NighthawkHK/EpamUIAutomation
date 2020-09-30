package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.DriverSingleton.getDriver;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='orb-nav-links']//li[contains(@class, 'newsdotcom')]/a")
    private WebElement newsButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public NewsPage goToNewsPage() {
        newsButton.click();
        return new NewsPage(getDriver());
    }
}
