package steps;

import pages.HomePage;
import pages.NewsPage;
import pages.SearchResultPage;
import pages.ShareNewsPage;

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

    public NewsPage navigateToNewsPage() {
        return homePage.goToNewsPage();
    }

    public SearchResultPage executeSearchByKeyword(String keyword) {
        return newsPage.searchByKeyword(keyword);
    }

}
