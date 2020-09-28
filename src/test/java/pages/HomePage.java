package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertyReader;

import static utils.DriverSingleton.getDriver;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='orb-nav-links']//li[contains(@class, 'newsdotcom')]/a")
    private WebElement newsButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public NewsPage goToNewsPage() {
        newsButton.click();
        return new NewsPage(getDriver());
    }

    public void openBBCWebsite() {
        getDriver().get(PropertyReader.getUrl());
    }
}
