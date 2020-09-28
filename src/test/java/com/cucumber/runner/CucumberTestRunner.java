package com.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags = "@Smoke",
        glue = "com.cucumber",
        features = "src/test/resources/features")

public class CucumberTestRunner extends AbstractTestNGCucumberTests { }
