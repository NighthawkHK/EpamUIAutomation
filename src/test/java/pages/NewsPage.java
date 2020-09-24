package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

import static utils.DriverSingleton.getDriver;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'primary__story')]//h3")
    private WebElement titleOfHeadlineArticle;

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#2']//p")
    private WebElement summaryOfSecondaryArticle;

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#1']//a[contains(@class, 'section-link')]/span")
    private WebElement categoryLinkOfHeadlineArticle;

    @FindBy(id = "orb-search-q")
    private WebElement searchField;

    @FindBy(xpath = "//nav[@aria-label='news']//a[contains(@href, 'coronavirus')]")
    private WebElement coronavirusTab;

    @FindBy(xpath = "//li[contains(@id, 'item--0')]//span[contains(@class, 'heading-text')]")
    private WebElement firstArticleOfTimelineList;

    @FindBy(xpath = "//li[contains(@id, 'item--1')]//span[contains(@class, 'heading-text')]")
    private WebElement secondArticleOfTimelineList;

    @FindBy(xpath = "//li[contains(@id, 'item--2')]//span[contains(@class, 'heading-text')]")
    private WebElement thirdArticleOfTimelineList;

    private final By popupCloseButtonLocator = By.cssSelector("button.sign_in-exit");
    private static boolean firstLoad = true;

    public NewsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public NewsPage closeAuthorizationPopup() {
        if (firstLoad)
        {
            WebDriverWait wait = initExplicitWait(5);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(popupCloseButtonLocator)));
            driver.findElement(popupCloseButtonLocator).click();
            firstLoad = false;
        }
        return this;
    }

    public String getTextOfCategoryLinkOfMainNews() {
        return categoryLinkOfHeadlineArticle.getText();
    }

    public String getTitleOfHeadlineArticle() {
        return titleOfHeadlineArticle.getText();
    }

    public List<String> getAllTitlesFromTimelineList() {
        List<String> allTitles = Arrays.asList(
                getFirstArticleOfTimelineList(),
                getSecondArticleOfTimelineList(),
                getThirdArticleOfTimelineList()
        );
        return allTitles;
    }

    public String getFirstArticleOfTimelineList() {
        return firstArticleOfTimelineList.getText();
    }

    public String getSecondArticleOfTimelineList() {
        return secondArticleOfTimelineList.getText();
    }

    public String getThirdArticleOfTimelineList() {
        return thirdArticleOfTimelineList.getText();
    }

    public SearchResultPage executeSearchByKeyword(String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword, Keys.RETURN);
        return new SearchResultPage(getDriver());
    }

    public CoronavirusPage goToCoronavirusPage() {
        coronavirusTab.click();
        return new CoronavirusPage(getDriver());
    }
}
