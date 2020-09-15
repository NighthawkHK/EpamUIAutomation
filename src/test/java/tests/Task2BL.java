package tests;

import org.testng.annotations.Test;

public class Task2BL extends BaseTest {

    @Test(priority = 1, dataProvider = "formSubmission-ValidData")
    public void checkTheAbilityToShareNews(String text, String name, String email, String phoneNumber, boolean isAdult, boolean acceptTerms) {
        steps.navigateToNewsPage()
                .closeAuthorizationPopup()
                .navigateToCoronavirusPage()
                .navigateToNewsSharePage()
                .shareTheNews(text, name, email, phoneNumber, isAdult, acceptTerms)
                .verifyThatTheNewsWasNotSent();
    }
}
