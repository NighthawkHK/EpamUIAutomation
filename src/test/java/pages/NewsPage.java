package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'primary__story')]//h3")
    private WebElement headlineArticleTitle;

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#2']//p")
    private WebElement secondaryArticleSummary;

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#1']//ul/li[2]/a/span")
    private WebElement headlineArticleCategoryLink;

    @FindBy(id = "orb-search-q")
    private WebElement searchField;

    @FindBy(xpath = "//nav[@role='navigation']//li[3]/a/span[contains(text(), 'Coronavirus')]")
    private WebElement coronavirusTab;

    private By popupAuthorizationLocator = By.cssSelector("div.sign_in-container");
    private By popupCloseButtonLocator = By.cssSelector("button.sign_in-exit");

    public void closeAuthorizationPopup() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(popupAuthorizationLocator)));
        driver.findElement(popupCloseButtonLocator).click();
    }

    public void assertThatMainNewsTitleContainsExpectedText(String expectedTitle) {
        Assert.assertEquals(headlineArticleTitle.getText(), expectedTitle);
    }

    public void assertThatSecondaryNewsSummaryContainsExpectedText(String expectedSummary) {
        Assert.assertEquals(secondaryArticleSummary.getText(), expectedSummary);
    }

    public String getCategoryLinkTextOfMainNews() {
        return headlineArticleCategoryLink.getText();
    }

    public void executeSearchByKeyword(String keyword) {
        searchField.sendKeys(keyword, Keys.RETURN);
    }

    public void goToCoronavirusPage() {
        coronavirusTab.click();
    }
}
