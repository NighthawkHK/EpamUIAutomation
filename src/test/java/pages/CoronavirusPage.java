package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronavirusPage extends BasePage {

    @FindBy(xpath = "//ul[contains(@class, 'secondary-sections')]/li[2]/a")
    private WebElement coronavirusStoriesTab;

    @FindBy(xpath = "//h3[text()='How to share with BBC News']/ancestor::a")
    private WebElement shareTheNewsLink;

    public void clickOnCoronavirusStoriesTab() {
        coronavirusStoriesTab.click();
    }

    public void goToNewsSharePage() {
        shareTheNewsLink.click();
    }
}
