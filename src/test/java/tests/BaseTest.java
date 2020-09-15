package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import pages.*;
import steps.HomeSteps;
import utils.DriverFactory;
import utils.PropertyReader;

public abstract class BaseTest {

    private static WebDriver driver;
    HomeSteps steps;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver(PropertyReader.getBrowser());
        driver.get(PropertyReader.getUrl());
        steps = new HomeSteps();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void returnOnHomePage() {
        driver.get(PropertyReader.getUrl());
    }

    @DataProvider(name = "expectedHeadlineArticle")
    public Object[][] expectedHeadlineArticle() {
        return new Object[][]{{"Trump visits Kenosha to back police after shooting"}};
    }

    @DataProvider(name = "expectedSecondaryArticleTitle")
    public Object[][] expectedSecondaryArticleTitle() {
        return new Object[][]{{"They are accused of helping Islamist militants stage the 2015 Charlie Hebdo attack that killed 12."}};
    }

    @DataProvider(name = "formSubmission-ValidData")
    public Object[][] formSubmissionValidData() {
        return new Object[][]
                {{"Hello! I am a Trainee QA Automation and this message is a spam :)", "Test01", "example@gmail.com", "0123456789", true, false}};
    }

    @DataProvider(name = "formSubmission-InvalidData")
    public Object[][] formSubmissionInvalidData() {
        return new Object[][] {{"Negative test case #1", "!@#$%^", "example.gmail.com", "-99999999", false, false}};
    }

    @DataProvider(name = "formSubmission-EmptyData")
    public Object[][] formSubmissionEmptyData() {
        return new Object[][] {{"Negative test case #2", " ", " ", " ", true, true}};
    }

    public HomePage getHomePage() {
        return new HomePage();
    }

    public NewsPage getNewsPage() {
        return new NewsPage();
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage();
    }

    public CoronavirusPage getCoronavirusPage() {
        return new CoronavirusPage();
    }

    public ShareNewsPage getShareNewsPage() {
        return new ShareNewsPage();
    }
}
