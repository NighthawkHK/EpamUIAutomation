package tests;

import org.testng.annotations.Test;

public class Task2 extends BaseTest {

    @Test(priority = 1, dataProvider = "formSubmission-ValidData")
    public void checkTheAbilityToShareNews(String text, String name, String email, String phoneNumber, boolean isAdult, boolean acceptTerms) {
        getHomePage().goToNewsPage();
        getNewsPage().closeAuthorizationPopup();
        getNewsPage().goToCoronavirusPage();
        getCoronavirusPage().clickOnCoronavirusStoriesTab();
        getCoronavirusPage().goToNewsSharePage();
        getShareNewsPage().fillTheRegistrationForm(text, name, email, phoneNumber, isAdult, acceptTerms);
        getShareNewsPage().submitTheRegistrationForm();
        getShareNewsPage().assertThatSubmissionDidNotWork();
    }

    @Test(priority = 2, dataProvider = "formSubmission-InvalidData")
    public void checkTheAbilityToShareNewsWithInvalidData(String text, String name, String email, String phoneNumber, boolean isAdult, boolean acceptTerms) {
        getHomePage().goToNewsPage();
        getNewsPage().goToCoronavirusPage();
        getCoronavirusPage().clickOnCoronavirusStoriesTab();
        getCoronavirusPage().goToNewsSharePage();
        getShareNewsPage().fillTheRegistrationForm(text, name, email, phoneNumber, isAdult, acceptTerms);
        getShareNewsPage().submitTheRegistrationForm();
        getShareNewsPage().assertThatSubmissionDidNotWork();
    }

    @Test(priority = 2, dataProvider = "formSubmission-EmptyData")
    public void checkTheAbilityToShareNewsWithEmptyData(String text, String name, String email, String phoneNumber, boolean isAdult, boolean acceptTerms) {
        getHomePage().goToNewsPage();
        getNewsPage().goToCoronavirusPage();
        getCoronavirusPage().clickOnCoronavirusStoriesTab();
        getCoronavirusPage().goToNewsSharePage();
        getShareNewsPage().fillTheRegistrationForm(text, name, email, phoneNumber, isAdult, acceptTerms);
        getShareNewsPage().submitTheRegistrationForm();
        getShareNewsPage().assertThatSubmissionDidNotWork();
    }
}
