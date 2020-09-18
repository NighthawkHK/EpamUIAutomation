package tests;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1 extends BaseTest {

    private final String EXPECTED_NAME_OF_HEADLINE_ARTICLE
            = "New fear grips Europe as Covid tops 30m worldwide";

    private final List<String> EXPECTED_TITLES_OF_TIMELINE_LIST = Arrays.asList(
            "Israel goes into second lockdown as new year begins",
            "One more Covid death in Wales and 185 new cases",
            "'Don't have one more night out', warn leaders in North West"
    );

    @Test
    public void verifyThatNameOfHeadlineArticleEqualsToExpected() {
        getHomePage().goToNewsPage();
        
        assertThat(getNewsPage().getTitleOfHeadlineArticle())
                .as("Actual and expected titles are different.")
                .isEqualTo(EXPECTED_NAME_OF_HEADLINE_ARTICLE);
    }

    @Test
    public void verifyThatSecondaryArticleTitlesOfHeadlineListAreEqualToExpected() {
        getHomePage().goToNewsPage();
        assertThat(getNewsPage().getAllTitlesFromTimelineList().equals(EXPECTED_TITLES_OF_TIMELINE_LIST))
                .as("One or more actual title does not match the expected.")
                .isTrue();
    }

    @Test
    public void verifyThatNameOfTheFirstArticleContainsValue() {
        getHomePage().goToNewsPage();
        String textOfCategoryLinkOfMainNews = getNewsPage().getTextOfCategoryLinkOfMainNews();
        getNewsPage().executeSearchByKeyword(textOfCategoryLinkOfMainNews);
        assertThat(getSearchResultPage().getFirstArticleHeadline())
                .as("First article does not contain specified value.")
                .contains(textOfCategoryLinkOfMainNews);
    }
}
