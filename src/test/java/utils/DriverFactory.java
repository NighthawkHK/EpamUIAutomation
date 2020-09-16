package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private final static String DRIVER_PATH = "src/test/resources/";
    private static WebDriver driver;

    public static WebDriver getDriver(Browser browser) {

        File file;

        switch (browser) {
            case CHROME:
                file = new File(DRIVER_PATH + "chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                driver = new ChromeDriver();
                break;
            case OPERA:
                file = new File(DRIVER_PATH + "opera.exe");
                System.setProperty("webdriver.opera.driver", file.getAbsolutePath());
                driver = new OperaDriver();
                break;
            case EDGE:
                file = new File(DRIVER_PATH + "edge.exe");
                System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
                driver = new EdgeDriver();
                break;
            case FIREFOX:
                file = new File(DRIVER_PATH + "firefox.exe");
                System.setProperty("webdriver.firefox.driver", file.getAbsolutePath());
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
}
