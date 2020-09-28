package steps;

import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.NewsPage;

import static utils.DriverSingleton.getDriver;

public class HeadlineArticleSteps {

    private final HomePage homePage = new HomePage(getDriver());
    private final NewsPage newsPage = new NewsPage(getDriver());

    @Given("the user opens BBC website")
    public void openBBC() {

    }
}
