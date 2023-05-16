package com.tma.appium.steps;

import com.tma.appium.frame.CommonFunction;
import com.tma.appium.frame.StartClock;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;

public class StartClockSteps extends Context {

    Context context;

    public StartClockSteps(Context context){
        this.driver = context.driver;
        this.commonFunction = context.commonFunction;
        this.StartClockObj = context.StartClockObj;


    }

    @Test
    public void startTimer() {
        StartClockObj.timerMenu.click();
        commonFunction.sleepInSec(1);
        log.info("----------------set timer 12h45m68s------------------------");
        List<String> listDigits = Arrays.asList("12h45m68s".replaceAll(".", "\\d").split(""));
        for(String digit:listDigits){
            StartClockObj.clickDigitTime(digit);
        }
        commonFunction.sleepInSec(0.5);
        log.info("Start timer with start button");
        StartClockObj.startPauseTimer.click();
        commonFunction.sleepInSec(5);
        StartClockObj.startPauseTimer.click();
        commonFunction.sleepInSec(10);
        StartClockObj.delete_Timer_Button.click();
    }

    @Given("Load App by Appium")
    public void loadAppiumAndClockApp(){
        commonFunction.sleepInSec(1);
        MobileElement dropdown = driver.findElement(By.id("page_indicator"));
        MobileElement search_widget_text = driver.findElement(By.xpath("//*[@content-desc='Search']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(dropdown).moveToElement(search_widget_text).release().build().perform();
        commonFunction.sleepInSec(0.5);
    }

    @When("Add new timer and click Start")
    public void addNewTimerAndClickStart() {
        StartClockObj.timerMenu.click();
        log.info("----------------set timer 12h45m68s------------------------");
        List<String> listDigits = Arrays.asList("12h45m68s".replaceAll("[^\\d]", "").split(""));
        for(String digit:listDigits){
            StartClockObj.clickDigitTime(digit);
        }
        commonFunction.sleepInSec(0.5);
        log.info("Start timer with start button");
        commonFunction.findElementById("com.android.deskclock:id/fab").click();
        commonFunction.sleepInSec(10);
        commonFunction.findElementById("com.android.deskclock:id/fab").click();
        commonFunction.sleepInSec(10);
        commonFunction.findElementByXpath("//*[@content-desc='Delete']").click();
        commonFunction.sleepInSec(5);
        StartClockObj.clockMenu.click();
    }

    @When("Find and start {string} app")
    public void findAndStartClockApp(String app) {
        log.info("Search Clock App");
        commonFunction.findElementById("search_container_all_apps").sendKeys(app);
        commonFunction.sleepInSec(0.5);
        commonFunction.findElementByXpath("//*[@content-desc='Clock']").click();
        commonFunction.sleepInSec(2);
    }
}
