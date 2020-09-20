package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='orb-nav-links']//li[contains(@class, 'newsdotcom')]/a")
    private WebElement newsButton;

    public NewsPage goToNewsPage() {
        newsButton.click();
        return new NewsPage();
    }
}
