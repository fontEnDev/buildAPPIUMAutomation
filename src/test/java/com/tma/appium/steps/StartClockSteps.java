package com.tma.appium.steps;

import com.tma.appium.frame.CommonFunction;
import com.tma.appium.frame.StartClock;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

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

    @Given("Load App of SamSung real device")
    public void loadAppOfSamSungRealDevice() {
        commonFunction.sleepInSec(1);
        MobileElement dropdown = driver.findElement(By.id("com.sec.android.app.launcher:id/active"));
        MobileElement search_widget_text = driver.findElement(By.id("com.google.android.googlequicksearchbox:id/search_edit_frame"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(dropdown).moveToElement(search_widget_text).release().build().perform();
        commonFunction.sleepInSec(0.5);
    }

    @And("Go to {string} app")
    public void goToVelocityApp(String nameApp) {
        commonFunction.findElementById("app_search_edit_text").click();
        commonFunction.sleepInSec(1);
        commonFunction.findElementById("com.samsung.android.app.galaxyfinder:id/edit_search").sendKeys(nameApp);
        commonFunction.sleepInSec(1);
        commonFunction.findByAccessibilityId(nameApp).click();
        commonFunction.sleepInSec(5);
    }


    @When("Add new profile web name {string} and URL {string}")
    public void addNewProfileWeb(String nameProfile, String URL) {
        MobileElement menuOption = commonFunction.findElementByXpath("//*[@content-desc='☰']/android.widget.TextView");
        menuOption.click();
        commonFunction.findByAccessibilityId("Create Host Profile").click();
        commonFunction.sleepInSec(1);
        String xpathPW = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.EditText";
        MobileElement inputPassword = commonFunction.findElementByXpath(xpathPW);
        inputPassword.click();
        inputPassword.sendKeys("system");
//        commonFunction.findElementById("android:id/custom").click();
//        commonFunction.findElementById("android:id/custom").sendKeys("system");
        commonFunction.findElementById("android:id/button1").click();
        commonFunction.sleepInSec(1);
        String xpathWebOption = "//*/android.widget.CheckedTextView[2]";
        commonFunction.findElementByXpath(xpathWebOption).click();
        commonFunction.sleepInSec(1);
        commonFunction.findElementById("com.wavelink.velocity:id/host_profile_name_field").sendKeys(nameProfile);
        commonFunction.findElementById("com.wavelink.velocity:id/host_profile_address_field").sendKeys(URL);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        commonFunction.sleepInSec(0.5);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        commonFunction.sleepInSec(0.5);
        commonFunction.findElementById("android:id/button1").click();
    }

    @Then("Click profile name {string} and URL {string}")
    public void clickProfileName(String nameProfile, String URL) {
        commonFunction.sleepInSec(1);
        commonFunction.findByAccessibilityId("google https://youtube.com").click();
        commonFunction.sleepInSec(1);
        commonFunction.findElementById("android:id/button2").click();
        commonFunction.sleepInSec(1);
    }

    @And("Exit page and delete version")
    public void exitPageAndDeleteVersion() {
        commonFunction.findElementById("com.wavelink.velocity:id/toolbar_icon_3").click();
        commonFunction.findElementById("com.wavelink.velocity:id/exit").click();
    }

    @Given("Test log4j class {string}")
    public void printlnLog(String logReport){
        log.info(logReport);
    }
}
