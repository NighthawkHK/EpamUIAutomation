package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import businessLayer.Flows;
import utils.DriverSingleton;
import utils.PropertyReader;

public abstract class BaseTest {

    private static WebDriver driver;
    protected Flows flow;
    private final String URL = PropertyReader.getUrl();

    @BeforeClass
    public void setUp() {
        driver = DriverSingleton.getDriver();
        driver.get(URL);
        flow = new Flows();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void backToMainPage() {
        driver.get(URL);
    }
}
