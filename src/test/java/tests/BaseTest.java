package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utils.DriverSingleton;
import utils.PropertyReader;

public abstract class BaseTest {

    private static WebDriver driver;
    private final String URL = PropertyReader.getUrl();

    @BeforeClass
    public void setUp() {
        driver = DriverSingleton.getDriver();
        driver.get(URL);
    }

    @AfterClass
    public void tearDown() {
        DriverSingleton.quitDriver();
    }

    @AfterMethod
    public void backToMainPage() {
        driver.get(URL);
    }
}
