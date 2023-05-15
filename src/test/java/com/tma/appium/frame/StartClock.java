package com.tma.appium.frame;

import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;

import java.net.URL;
import java.util.List;

public class StartClock extends CommonFunction {

    @AndroidFindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc='Alarm']")
    public MobileElement alarmMenu;

    @AndroidFindBy(xpath = "//*[@content-desc='Clock']")
    public MobileElement clockMenu;

    @FindBy (xpath = "//*[@content-desc='Timer']")
    public MobileElement timerMenu;

    @FindBy (xpath = "//*[@content-desc='Stopwatch']")
    public MobileElement stopwatchMenu;

    @FindBy (id = "com.android.deskclock:id/fab")
    public MobileElement startPauseTimer;

    @FindBy(id="timer_setup_delete")
    public MobileElement delete_Digit_Button;

    @FindBy(xpath= "//*[@content-desc='Delete']")
    public MobileElement delete_Timer_Button;

    @FindBy(id = "timer_label")
    public MobileElement label_Timer;

    @FindBy(xpath = "//*[@content-desc='Add Timer']")
    public MobileElement add_Timer;

    @FindBy(xpath = "//*[@content-desc='Cancel']")
    public MobileElement cancel_Add_Timer;

    @FindBy(id = "hours")
    public MobileElement hourAlarm;

    @FindBy(id = "minutes")
    public MobileElement minutesAlarm;

    @FindBy(id = "am_label")
    public MobileElement selectAMAlarm;

    @FindBy(id = "pm_label")
    public MobileElement selectPMAlarm;

    @FindBy(id = "button1")
    public MobileElement selectOKAlarm;

    @FindBy(id = "button2")
    public MobileElement selectCancelAddAlarm;

    @FindBy(id = "toggle_mode")
    public MobileElement changeTypeAlarm;

    @FindBy(xpath = "//*[@content-desc='Add alarm']")
    public MobileElement addAlarm;

    public StartClock(AppiumDriver<MobileElement> driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(super.driver), this);
        System.out.println();
    }

    public void clickDigitTime(String digit){
        try {
            if(Integer.parseInt(digit) > 9){
                Assert.fail("Input number with format incorrectly");
            }
            String id = String.format("com.android.deskclock:id/timer_setup_digit_%s", digit);
            MobileElement digit_Element = findElementById(id);
            digit_Element.click();
        }
        catch (Exception e){
            Assert.fail("Can't find element and click it");
        }
    }

    public void selectNumberHours(int number){
        try {
            if(number > 12 || number < 1){
                Assert.fail("Input number with format incorrectly");
            }
            MobileElement number_Hours = findElementByXpath("//*[@content-desc='" + number + "']");
            number_Hours.click();
        }
        catch (Exception e){
            Assert.fail("Can't find element and select number hours");
        }
    }

    public void selectNumberMinutes(int number){
        try {

            if(number % 5 != 0 || number > 55){
                Assert.fail("Input number with format incorrectly");
            }
            MobileElement number_Minutes = findElementByXpath("//*[@content-desc='" + number + "']");
            number_Minutes.click();
        }
        catch (Exception e){
            Assert.fail("Can't find element and select number hours");
        }
    }

//    public void mobileBy(){
//        WebElement abc = driver.findElement(MobileBy.AccessibilityId(""));
//    }
}
