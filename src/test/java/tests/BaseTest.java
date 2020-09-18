package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.*;
import flows.CommonFlows;
import utils.DriverSingleton;
import utils.PropertyReader;

public abstract class BaseTest {

    private static WebDriver driver;
    protected CommonFlows steps;
    private final String URL = PropertyReader.getUrl();

    @BeforeClass
    public void setUp() {
        driver = DriverSingleton.getDriver();
        driver.get(URL);
        steps = new CommonFlows();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void returnOnMainPage() {
        driver.get(URL);
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
}
