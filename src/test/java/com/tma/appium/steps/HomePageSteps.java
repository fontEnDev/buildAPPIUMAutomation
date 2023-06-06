package com.tma.appium.steps;

import com.tma.appium.frame.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class HomePageSteps extends Context {
    Context context;

    public HomePageSteps(Context context) {
        this.driver = context.driver;
        this.commonFunction = context.commonFunction;
        this.StartClockObj = context.StartClockObj;
        this.HomePageObj = context.HomePageObj;
    }

    @When("Find and start {string} app")
    public void findAndStartClockApp(String app) {
        commonFunction.swipeDriver(0.5, 0.8, 0.5, 0.1);
        commonFunction.sleepInSec(2);
        log.info("Search App with name: " + app);
        HomePageObj.searchApp.click();
        HomePageObj.searchApp.sendKeys(app);
        commonFunction.sleepInSec(0.5);
        commonFunction.findElementByContentDesc(app).click();
        commonFunction.sleepInSec(2);
    }
}
