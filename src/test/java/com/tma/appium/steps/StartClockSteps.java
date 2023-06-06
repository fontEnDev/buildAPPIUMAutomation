package com.tma.appium.steps;

import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class StartClockSteps extends Context {

    Context context;
    public final Logger log = LogManager.getLogger(StartClockSteps.class);

    public StartClockSteps(Context context){
        this.driver = context.driver;
        this.commonFunction = context.commonFunction;
        this.StartClockObj = context.StartClockObj;


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
    }
}
