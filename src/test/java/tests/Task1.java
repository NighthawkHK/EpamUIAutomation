package tests;

import org.testng.annotations.Test;

public class Task1 extends BaseTest {

    @Test(dataProvider = "expectedHeadlineArticle")
    public void checkTheNameOfHeadlineArticle(String expectedName) {
        getHomePage().goToNewsPage();
        getNewsPage().assertThatMainNewsTitleContainsExpectedText(expectedName);
    }

    @Test(dataProvider = "expectedSecondaryArticleTitle")
    public void checkTheSummaryOfSecondaryArticle(String expectedSummary) {
        getHomePage().goToNewsPage();
        getNewsPage().assertThatSecondaryNewsSummaryContainsExpectedText(expectedSummary);
    }

    @Test
    public void checkTheNameOfTheFirstArticleAgainstSpecifiedValue() {
        getHomePage().goToNewsPage();
        String text = getNewsPage().getCategoryLinkTextOfMainNews();
        getNewsPage().executeSearchByKeyword(text);
        getSearchResultPage().assertThatFirstArticleHeadlineContainsSpecifiedValue(text);
    }
}
