package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewsPage;
import pages.SearchResultPage;
import pages.ShareNewsPage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.DriverSingleton.getDriver;

public class BBCTests extends BaseTest {

    private final HomePage homePage = new HomePage(getDriver());
    private final NewsPage newsPage = new NewsPage(getDriver());
    private final SearchResultPage searchResultPage = new SearchResultPage(getDriver());

    @Test
    public void verifyThatNameOfHeadlineArticleEqualsToExpected() {
        String EXPECTED_NAME_OF_HEADLINE_ARTICLE = "New fear grips Europe as Covid tops 30m worldwide";

        assertThat(homePage.goToNewsPage().getTitleOfHeadlineArticle())
                .as("Actual and expected titles are different.")
                .isEqualTo(EXPECTED_NAME_OF_HEADLINE_ARTICLE);
    }

    @Test
    public void verifyThatSecondaryArticleTitlesOfHeadlineListAreEqualToExpected() {
        List<String> EXPECTED_TITLES_OF_TIMELINE_LIST = Arrays.asList(
                "Miss Sherlock actress Yuko Takeuchi found dead",
                "US city warned over brain-eating microbe in water",
                "Islamist militants kill 18 in north-eastern Nigeria",
                "Britons 'bubbling out of pubs' since curfew");

        assertThat(homePage.goToNewsPage().getTitles().equals(EXPECTED_TITLES_OF_TIMELINE_LIST))
                .as("One or more actual title does not match the expected.")
                .isTrue();
    }

    @Test
    public void verifyThatNameOfTheFirstArticleContainsValue() {
        String textOfCategoryLinkOfMainNews = homePage.goToNewsPage().getTextOfCategoryLinkOfMainNews();
        newsPage.executeSearchByKeyword(textOfCategoryLinkOfMainNews);
        assertThat(searchResultPage.getFirstArticleHeadline())
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
        testingFormData.put("ageConfirmation", "true");
        testingFormData.put("termsConfirmation", "true");

        ShareNewsPage shareNewsPage = new HomePage(getDriver())
                .goToNewsPage()
                .closeAuthorizationPopup()
                .goToCoronavirusPage()
                .clickOnCoronavirusStoriesTab()
                .goToShareSharePage()
                .fillForm(testingFormData)
                .submitForm();

        assertThat(shareNewsPage.verifyThatFormWasSent())
                .as("Form was not sent on the server.")
                .isTrue();
    }
}
