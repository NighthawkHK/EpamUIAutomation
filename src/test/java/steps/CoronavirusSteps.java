package steps;

import pages.CoronavirusPage;

public class CoronavirusSteps {

    private final CoronavirusPage coronavirusPage = new CoronavirusPage();

    public ShareNewsSteps navigateToNewsSharePage() {
        coronavirusPage.clickOnCoronavirusStoriesTab();
        coronavirusPage.goToNewsSharePage();
        return new ShareNewsSteps();
    }
}
