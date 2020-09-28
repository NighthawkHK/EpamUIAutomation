package tests;

import org.testng.annotations.Test;
import steps.BBCSteps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BBCTests extends BaseTest {

    private final BBCSteps steps = new BBCSteps();

    @Test
    public void verifyThatNameOfHeadlineArticleEqualsToExpected() {
        String EXPECTED_NAME_OF_HEADLINE_ARTICLE = "New fear grips Europe as Covid tops 30m worldwide";

        assertThat(steps.getTitleOfHeadlineArticle())
                .as("Actual and expected titles are different.")
                .isEqualTo(EXPECTED_NAME_OF_HEADLINE_ARTICLE);
    }

    @Test
    public void verifyThatSecondaryArticleTitlesOfHeadlineListAreEqualToExpected() {
        List<String> EXPECTED_TITLES_OF_TIMELINE_LIST = Arrays.asList(
                "Another 4,044 new UK cases",
                "US man given one year sentence for throwing parties",
                "Scottish police break up 'at least' 300 house parties"
        );

        assertThat(steps.getAllTitlesOfTimelineList())
                .as("One or more news title does not match the expected.")
                .isEqualTo(EXPECTED_TITLES_OF_TIMELINE_LIST);
    }

    @Test
    public void verifyThatNameOfTheFirstArticleContainsValue() {
        String textOfCategoryLinkOfMainNews = steps.getTextOfCategoryLinkOfMainNews();

        assertThat(steps.executeSearchByKeyword(textOfCategoryLinkOfMainNews).getFirstArticleHeadline())
                .as("First article does not contain specified value.")
                .contains(textOfCategoryLinkOfMainNews);
    }

    @Test
    public void sendQuestionToBBC() {
        Map<String, String> testingFormData = new HashMap<>();
        testingFormData.put("question", "Hi!");
        testingFormData.put("name", "Test01");
        testingFormData.put("email", "example@gmail.com");
        testingFormData.put("phoneNumber", "0003338800");
        testingFormData.put("ageConfirmation", "false");
        testingFormData.put("termsConfirmation", "false");

        assertThat(steps.navigateToShareNewsPage()
                .fillForm(testingFormData)
                .submitForm()
                .verifyThatFormWasSent())
                .as("Form was not sent on the server.")
                .isTrue();
    }
}
