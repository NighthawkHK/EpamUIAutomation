package steps;

import pages.HomePage;

public class HomeSteps {

    private final HomePage homePage = new HomePage();

    public NewsSteps navigateToNewsPage() {
        homePage.goToNewsPage();
        return new NewsSteps();
    }
}
