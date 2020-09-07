package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//ul[contains(@class, 'Stack')]/li[3]//p[contains(@class, 'PromoHeadline')]")
    private WebElement firstArticleHeadline;

    public void assertThatFirstArticleHeadlineContainsSpecifiedValue(String text) {
        Assert.assertTrue(firstArticleHeadline.getText().contains(text));
    }
}
