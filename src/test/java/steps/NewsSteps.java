package steps;

import pages.NewsPage;

public class NewsSteps {

    private NewsPage newsPage = new NewsPage();

    public NewsSteps closeAuthorizationPopup() {
        newsPage.closeAuthorizationPopup();
        return this;
    }

    public CoronavirusSteps navigateToCoronavirusPage() {
        newsPage.goToCoronavirusPage();
        return new CoronavirusSteps();
    }
}