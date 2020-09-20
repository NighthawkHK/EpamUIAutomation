package businessLayer;

import pages.*;

public class Flows {

    private final ShareNewsPage shareNewsPage = new ShareNewsPage();

    public Flows navigateToNewsSharePage() {
        new HomePage()
                .goToNewsPage()
                .closeAuthorizationPopup()
                .goToCoronavirusPage()
                .clickOnCoronavirusStoriesTab()
                .goToShareSharePage();
        return this;
    }

    public Flows fillForm(String question, String name, String email, String contactNumber) {
        new ShareNewsPage()
                .typeQuestion(question)
                .typeName(name)
                .typeEmail(email)
                .typeContactNumber(contactNumber);
        return this;
    }

    public Flows toggleCheckboxes(boolean isAdultCondition, boolean acceptTermsCondition) {
        new ShareNewsPage()
                .isAdultConfirmation(isAdultCondition)
                .acceptTermsConfirmation(acceptTermsCondition);
        return this;
    }

    public boolean submitQuestion() {
        new ShareNewsPage().clickSubmitFormButton();
        return !shareNewsPage.submitButtonIsDisplayed(); // if submit button is displayed then the question was not sent
    }
















}
