package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.DriverSingleton.getDriver;

public class CoronavirusPage extends BasePage {

    @FindBy(xpath = "//nav[@aria-label='Coronavirus pandemic']//a[contains(@href, 'have_your_say')]")
    private WebElement coronavirusStoriesTab;

    @FindBy(xpath = "//h3[text()='How to share with BBC News']/ancestor::a")
    private WebElement shareTheNewsLink;

    public CoronavirusPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CoronavirusPage clickOnCoronavirusStoriesTab() {
        coronavirusStoriesTab.click();
        return this;
    }

    public ShareNewsPage goToShareSharePage() {
        shareTheNewsLink.click();
        return new ShareNewsPage(getDriver());
    }
}
