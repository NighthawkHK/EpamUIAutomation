package businessLayer;

import pages.*;

import static utils.DriverSingleton.getDriver;

public class Flows {

    public Flows navigateToNewsSharePage() {
        new HomePage(getDriver())
                .goToNewsPage()
                .closeAuthorizationPopup()
                .goToCoronavirusPage()
                .clickOnCoronavirusStoriesTab()
                .goToShareSharePage();
        return this;
    }

    public Flows fillForm(String question, String name, String email, String contactNumber) {
        new ShareNewsPage(getDriver())
                .typeQuestion(question)
                .typeName(name)
                .typeEmail(email)
                .typeContactNumber(contactNumber);
        return this;
    }

    public Flows toggleCheckboxes(boolean isAdultCondition, boolean acceptTermsCondition) {
        new ShareNewsPage(getDriver())
                .isAdultConfirmation(isAdultCondition)
                .acceptTermsConfirmation(acceptTermsCondition);
        return this;
    }

    public boolean submitQuestion() {
        return new ShareNewsPage(getDriver()).clickSubmitFormButton().getFormState();
    }
















}
