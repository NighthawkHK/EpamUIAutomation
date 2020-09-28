package com.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.NewsPage;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.DriverSingleton.getDriver;

public class HeadlineArticleSteps {

    private final HomePage homePage = new HomePage(getDriver());
    private final NewsPage newsPage = new NewsPage(getDriver());

    @Given("the user opens BBC website")
    public void openBBC() {
        homePage.openBBCWebsite();
    }

    @When("the user goes to the News page")
    public void goToNewsPage() {
        homePage.goToNewsPage();
    }

    @Then("the headline article corresponds to expected {string}")
    public void verifyHeadlineArticle(String expectedArticle) {
        assertThat(newsPage.getTitleOfHeadlineArticle())
                .as("Actual and expected titles are different.")
                .isEqualTo(expectedArticle);
    }
}
