package flows;

import pages.*;

public class CommonFlows {

    private final HomePage homePage = new HomePage();
    private final NewsPage newsPage = new NewsPage();
    private final CoronavirusPage coronavirusPage = new CoronavirusPage();
    private final ShareNewsPage shareNewsPage = new ShareNewsPage();

    public CommonFlows navigateToNewsSharePage() {
        homePage.goToNewsPage();
        newsPage.closeAuthorizationPopup();
        newsPage.goToCoronavirusPage();
        coronavirusPage.clickOnCoronavirusStoriesTab();
        coronavirusPage.goToNewsSharePage();
        return this;
    }

    public CommonFlows fillRegistrationForm(String question, String name, String email, String contactNumber) {
        shareNewsPage.typeQuestion(question);
        shareNewsPage.typeName(name);
        shareNewsPage.typeEmail(email);
        shareNewsPage.typeContactNumber(contactNumber);
        return this;
    }

    public CommonFlows toggleCheckboxes(boolean isAdult, boolean acceptTerms) {
        shareNewsPage.isAdultConfirmation(isAdult);
        shareNewsPage.acceptTermsConfirmation(acceptTerms);
        return this;
    }

    public boolean submitQuestion() {
        shareNewsPage.clickSubmitFormButton();
        return !shareNewsPage.submitButtonIsDisplayed(); // if submit button is displayed then the question was not sent
    }
















}
