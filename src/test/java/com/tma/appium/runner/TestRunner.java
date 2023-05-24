package com.tma.appium.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/feature"},
        glue = {"com.tma.appium.steps"},
        tags = "@TestAppVelocity"
)
public class TestRunner {
}
