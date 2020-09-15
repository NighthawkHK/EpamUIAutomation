package steps;

import pages.ShareNewsPage;

public class ShareNewsSteps {

    private ShareNewsPage shareNewsPage = new ShareNewsPage();

    public ShareNewsSteps shareTheNews(String text, String name, String email, String phoneNumber, boolean isAdult, boolean acceptTerms) {
        shareNewsPage.fillTheRegistrationForm(text, name, email, phoneNumber, isAdult, acceptTerms);
        shareNewsPage.submitTheRegistrationForm();
        return this;
    }

    public ShareNewsSteps verifyThatTheNewsWasNotSent() {
        shareNewsPage.assertThatSubmissionDidNotWork();
        return this;
    }
}
