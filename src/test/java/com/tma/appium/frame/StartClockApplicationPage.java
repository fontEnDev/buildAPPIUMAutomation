package com.tma.appium.frame;

//import io.appium.java_client.MobileElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
        import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartClockApplicationPage extends CommonFunction {
    private final Logger log = LogManager.getLogger(StartClockApplicationPage.class);

    @FindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc='Alarm']")
    public WebElement alarmMenu;

    @FindBy(xpath = "//*[@content-desc='Clock']")
    public WebElement clockMenu;

    @FindBy (xpath = "//*[@content-desc='Timer']")
    public WebElement timerMenu;

    @FindBy (xpath = "//*[@content-desc='Stopwatch']")
    public WebElement stopwatchMenu;

    @FindBy (id = "com.android.deskclock:id/fab")
    public WebElement startPauseTimer;

    @FindBy(id="timer_setup_delete")
    public WebElement delete_Digit_Button;

    @FindBy(xpath= "//*[@content-desc='Delete']")
    public WebElement delete_Timer_Button;

    @FindBy(id = "timer_label")
    public WebElement label_Timer;

    @FindBy(xpath = "//*[@content-desc='Add Timer']")
    public WebElement add_Timer;

    @FindBy(xpath = "//*[@content-desc='Cancel']")
    public WebElement cancel_Add_Timer;

    @FindBy(id = "hours")
    public WebElement hourAlarm;

    @FindBy(id = "minutes")
    public WebElement minutesAlarm;

    @FindBy(id = "am_label")
    public WebElement selectAMAlarm;

    @FindBy(id = "pm_label")
    public WebElement selectPMAlarm;

    @FindBy(id = "button1")
    public WebElement selectOKAlarm;

    @FindBy(id = "button2")
    public WebElement selectCancelAddAlarm;

    @FindBy(id = "toggle_mode")
    public WebElement changeTypeAlarm;

    @FindBy(xpath = "//*[@content-desc='Add alarm']")
    public WebElement addAlarm;

    public StartClockApplicationPage(AppiumDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickDigitTime(String digit){
        try {
            if(Integer.parseInt(digit) > 9){
                Assert.fail("Input number with format incorrectly");
            }
            String id = String.format("com.android.deskclock:id/timer_setup_digit_%s", digit);
            WebElement digit_Element = findElementById(id);
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
            WebElement number_Hours = findElementByXpath("//*[@content-desc='" + number + "']");
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
            WebElement number_Minutes = findElementByXpath("//*[@content-desc='" + number + "']");
            number_Minutes.click();
        }
        catch (Exception e){
            Assert.fail("Can't find element and select number hours");
        }
    }
}
