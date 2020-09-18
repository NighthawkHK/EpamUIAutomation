package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task2 extends BaseTest {

    @DataProvider(name = "formSubmission")
    public Object[][] formSubmission() {
        return new Object[][] {
                {"Hello! I am a Trainee QA Automation and this message is a spam :)",
                        "Test01", "example@gmail.com", "0123456789", true, false},
                {"Hello!",
                        "Test02", "example@gmail.com", "9876543210", false, true},
        };
    }

    @Test(dataProvider = "formSubmission")
    public void sendQuestionToBBC(String question, String name, String email, String contactNumber,
                                  boolean isAdult, boolean acceptTerms) {

        boolean questionWasSent = steps.navigateToNewsSharePage()
                .fillRegistrationForm(question, name, email, contactNumber)
                .toggleCheckboxes(isAdult, acceptTerms)
                .submitQuestion();

        assertThat(questionWasSent)
                .as("Form was not sent.")
                .isTrue();
    }
}
