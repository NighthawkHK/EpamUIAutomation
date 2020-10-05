package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static utils.DriverSingleton.getDriver;

public class NewsPage extends BasePage {

    private static boolean firstLoad = true;
    private final By popupCloseButtonLocator = By.cssSelector("button.sign_in-exit");

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

    @FindBy(xpath = "//ol[contains(@class, 'lx-c-timeline__list')]//span[contains(@class, 'heading-text')]")
    private List<WebElement> titlesOfTimelineList;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public NewsPage closeAuthorizationPopup() {
        if (firstLoad) {
            WebElement popupCloseButton = findElement(popupCloseButtonLocator);
            initExplicitWait(5).until(ExpectedConditions.elementToBeClickable(popupCloseButton)).click();
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

    public ArrayList<String> getNewsTitlesOfTimelineList() {
        ArrayList<String> textNewsTitles = new ArrayList<>();
        for (WebElement we : titlesOfTimelineList) {
            textNewsTitles.add(we.getText());
        }
        return textNewsTitles;
    }

    public SearchResultPage searchByKeyword(String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword, Keys.RETURN);
        return new SearchResultPage(getDriver());
    }

    public CoronavirusPage goToCoronavirusPage() {
        coronavirusTab.click();
        return new CoronavirusPage(getDriver());
    }
}
