package com.cucumber.runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverSingleton;

public class CucumberHook {

    @Before
    public void setupDriver() {
        WebDriver driver = DriverSingleton.getDriver();
    }

    @After
    public void quitDriver() {
        DriverSingleton.quitDriver();
    }
}
