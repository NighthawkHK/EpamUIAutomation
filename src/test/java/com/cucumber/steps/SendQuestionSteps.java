package com.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ShareNewsPage;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.DriverSingleton.getDriver;

public class SendQuestionSteps {

    private Map<String, String> formData = new HashMap<>();
    private final HomePage homePage = new HomePage(getDriver());
    private final ShareNewsPage shareNewsPage = new ShareNewsPage(getDriver());

    @Given("data to test: {string}, {string}, {string}, {string}, {string}, {string}")
    public void setFormData(String question, String name, String contactNumber, String emailAddress,
                            String ageConfirmation, String termsConfirmation) {
        formData.put("question", question);
        formData.put("name", name);
        formData.put("contactNumber", contactNumber);
        formData.put("email", emailAddress);
        formData.put("ageConfirmation", ageConfirmation);
        formData.put("termsConfirmation", termsConfirmation);
    }

    @When("the user goes to Share news page")
    public void navigateToShareNewsPage() {
        homePage.goToNewsPage()
                .closeAuthorizationPopup()
                .goToCoronavirusPage()
                .clickOnCoronavirusStoriesTab()
                .goToShareSharePage();
    }

    @And("fills in the form")
    public void fillForm() {
        shareNewsPage.fillForm(formData);
    }

    @Then("the user submits the form")
    public void submitForm() {
        shareNewsPage.submitForm();
    }

    @And("the form successfully sent on the server")
    public void verifyThatFormWasSubmitted() {
        assertThat(shareNewsPage.verifyThatFormWasSent())
                .as("Form was not sent.")
                .isTrue();
    }
}
