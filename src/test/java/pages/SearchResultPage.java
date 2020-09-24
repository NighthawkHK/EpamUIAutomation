package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//ul[contains(@class, 'Stack')]/li[3]//p[contains(@class, 'PromoHeadline')]")
    private WebElement firstArticleHeadline;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getFirstArticleHeadline() {
        return firstArticleHeadline.getText();
    }
}
