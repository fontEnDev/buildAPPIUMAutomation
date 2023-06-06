package com.tma.appium.steps;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VelocityApplicationSteps extends Context{

    Context context;
    public final Logger log = LogManager.getLogger(StartClockSteps.class);

    public VelocityApplicationSteps(Context context){
        this.driver = context.driver;
        this.commonFunction = context.commonFunction;
        this.StartClockObj = context.StartClockObj;
        this.VelocityApplicationObj = context.VelocityApplicationObj;


    }

    @When("Add new profile web name {string} and URL {string} if it does not exist")
    public void addNewProfileWeb(String nameProfile, String URL) {
        int numberProfile = commonFunction.countNumberElementByXpath(String.format(VelocityApplicationObj.xpathProfileURL, nameProfile, URL));
        if (numberProfile == 0) {
            log.info("Add profile with name " + nameProfile + " and " + URL);
            VelocityApplicationObj.optionApp.click();
            commonFunction.sleepInSec(0.5);
            VelocityApplicationObj.createNewProfile.click();
            commonFunction.sleepInSec(0.5);
            commonFunction.sleepInSec(1);
            VelocityApplicationObj.inputPassWord.click();
            VelocityApplicationObj.inputPassWord.sendKeys("system");
            VelocityApplicationObj.btnOk_Save.click();
            commonFunction.sleepInSec(1);
            VelocityApplicationObj.webOption.click();
            commonFunction.sleepInSec(1);
            VelocityApplicationObj.inputProfile.sendKeys(nameProfile);
            VelocityApplicationObj.inputAddress.sendKeys(URL);
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            commonFunction.sleepInSec(0.5);
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            commonFunction.sleepInSec(0.5);
            VelocityApplicationObj.btnOk_Save.click();
            commonFunction.sleepInSec(1);
        } else {
            log.info("Profile with name " + nameProfile + " and URL " + URL + " was exits");
        }
    }

    @Then("Click profile name {string} and URL {string}")
    public void clickProfileName(String nameProfile, String URL) {
        commonFunction.sleepInSec(1);
        commonFunction.findElementByXpath(String.format(VelocityApplicationObj.xpathProfileURL, nameProfile, URL)).click();
        commonFunction.sleepInSec(1);
        VelocityApplicationObj.btnDemo.click();
        commonFunction.sleepInSec(1);
    }
}
