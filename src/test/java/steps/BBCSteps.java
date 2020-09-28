package steps;

import pages.HomePage;
import pages.NewsPage;
import pages.SearchResultPage;
import pages.ShareNewsPage;

import java.util.List;

import static utils.DriverSingleton.getDriver;

public class BBCSteps {

    private final HomePage homePage = new HomePage(getDriver());
    private final NewsPage newsPage = new NewsPage(getDriver());

    public ShareNewsPage navigateToShareNewsPage() {
        homePage.goToNewsPage()
                .closeAuthorizationPopup()
                .goToCoronavirusPage()
                .clickOnCoronavirusStoriesTab()
                .goToShareSharePage();
        return new ShareNewsPage(getDriver());
    }

    public String getTextOfCategoryLinkOfMainNews() {
        return homePage.goToNewsPage().getTextOfCategoryLinkOfMainNews();
    }

    public SearchResultPage executeSearchByKeyword(String keyword) {
        SearchResultPage resultPage = newsPage.searchByKeyword(keyword);
        return resultPage;
    }

    public List<String> getAllTitlesOfTimelineList() {
        return homePage.goToNewsPage().getNewsTitlesOfTimelineList();
    }

    public String getTitleOfHeadlineArticle() {
        return homePage.goToNewsPage().getTitleOfHeadlineArticle();
    }
}
