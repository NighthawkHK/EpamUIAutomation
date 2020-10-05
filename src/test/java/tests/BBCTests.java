package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class BBCTests extends BaseTest {

    @Test
    public void verifyThatNameOfHeadlineArticleEqualsToExpected() {
        final String EXPECTED_NAME_OF_HEADLINE_ARTICLE = "New fear grips Europe as Covid tops 30m worldwide";

        assertThat(steps.navigateToNewsPage().getTitleOfHeadlineArticle())
                .as("Actual and expected titles are different.")
                .isEqualTo(EXPECTED_NAME_OF_HEADLINE_ARTICLE);
    }

    @Test
    public void verifyThatSecondaryArticleTitlesOfHeadlineListAreEqualToExpected() {
        final ArrayList<String> EXPECTED_TITLES_OF_TIMELINE_LIST = new ArrayList<>();
        EXPECTED_TITLES_OF_TIMELINE_LIST.add("Another 4,044 new UK cases");
        EXPECTED_TITLES_OF_TIMELINE_LIST.add("US man given one year sentence for throwing parties");
        EXPECTED_TITLES_OF_TIMELINE_LIST.add("Scottish police break up 'at least' 300 house parties");

        assertThat(steps.navigateToNewsPage().getNewsTitlesOfTimelineList())
                .as("One or more news title does not match the expected.")
                .isEqualTo(EXPECTED_TITLES_OF_TIMELINE_LIST);
    }

    @Test
    public void verifyThatNameOfTheFirstArticleContainsValue() {
        final String textOfCategoryLinkOfMainNews = steps.navigateToNewsPage().getTextOfCategoryLinkOfMainNews();

        assertThat(steps.executeSearchByKeyword(textOfCategoryLinkOfMainNews).getFirstArticleHeadline())
                .as("First article does not contain specified value.")
                .contains(textOfCategoryLinkOfMainNews);
    }

    @Test(dataProvider = "formData")
    public void sendQuestionToBBC(HashMap<String, String> formData) {
        assertThat(steps.navigateToShareNewsPage()
                .fillForm(formData)
                .submitForm()
                .verifyThatFormWasSent())
                .as("Form was not sent on the server.")
                .isTrue();
    }

    @DataProvider
    public Object[][] formData() {
        HashMap<String, String> validData = new HashMap<>();
        HashMap<String, String> invalidData = new HashMap<>();

        validData.put("question", "Hi!");
        validData.put("name", "Test01");
        validData.put("email", "example@gmail.com");
        validData.put("phoneNumber", "0003338800");
        validData.put("ageConfirmation", "false");
        validData.put("termsConfirmation", "false");

        invalidData.put("question", "abc!@#$%^");
        invalidData.put("name", "Test02");
        invalidData.put("email", "example.gmail.com");
        invalidData.put("phoneNumber", "");
        invalidData.put("ageConfirmation", "false");
        invalidData.put("termsConfirmation", "false");

        return new Object[][]{
                {validData},
                {invalidData}
        };
    }
}