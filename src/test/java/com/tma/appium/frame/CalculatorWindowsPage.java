package com.tma.appium.frame;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CalculatorWindowsPage {
    AppiumDriver driver;

    @FindBy(xpath="//Button[@AutomationId='num0Button']")
    public WebElement zeroNumberBtn;

    @FindBy(xpath="//Button[@AutomationId='num1Button']")
    public WebElement oneNumberBtn;

    @FindBy(xpath="//Button[@AutomationId='num2Button']")
    public WebElement twoNumberBtn;

    @FindBy(xpath="//Button[@AutomationId='num3Button']")
    public WebElement threeNumberBtn;

    @FindBy(xpath="//Button[@AutomationId='num4Button']")
    public WebElement fourNumberBtn;

    @FindBy(xpath="//Button[@AutomationId='num5Button']")
    public WebElement fiveNumberBtn;

    @FindBy(xpath="//Button[@AutomationId='num6Button']")
    public WebElement sixNumberBtn;

    @FindBy(xpath="//Button[@AutomationId='num7Button']")
    public WebElement sevenNumberBtn;

    @FindBy(xpath="//Button[@AutomationId='num8Button']")
    public WebElement eightNumberBtn;

    @FindBy(xpath="//Button[@AutomationId='num9Button']")
    public WebElement nineNumberBtn;

    @FindBy(xpath="//Button[@AutomationId='num0Button']")
    public WebElement backSpaceBtn;

    @FindBy(xpath="//Button[@AutomationId='clearEntryButton']")
    public WebElement clearEntryBtn;

    @FindBy(xpath="//Button[@AutomationId='percentButton']")
    public WebElement percentBtn;

    @FindBy(xpath="//Button[@AutomationId='clearButton']")
    public WebElement clearBtn;

    @FindBy(xpath="//Button[@AutomationId='invertButton']")
    public WebElement invertBtn;

    @FindBy(xpath="//Button[@AutomationId='xpower2Button']")
    public WebElement xpower2Btn;

    @FindBy(xpath="//Button[@AutomationId='squareRootButton']")
    public WebElement squareRootBtn;

    @FindBy(xpath="//Button[@AutomationId='divideButton']")
    public WebElement divideBtn;

    @FindBy(xpath="//Button[@AutomationId='multiplyButton']")
    public WebElement multiplyBtn;

    @FindBy(xpath="//Button[@AutomationId='minusButton']")
    public WebElement minusBtn;

    @FindBy(xpath="//Button[@AutomationId='plusButton']")
    public WebElement plusBtn;

    @FindBy(xpath="//Button[@AutomationId='equalButton']")
    public WebElement equalBtn;

    @FindBy(xpath="//Button[@AutomationId='divideButton']")
    public WebElement decimalBtn;

    @FindBy(xpath="//Button[@AutomationId='negateButton']")
    public WebElement negateBtn;

    @FindBy(xpath="//Button[@AutomationId='HeaderButton']")
    public WebElement headerPage;

    @FindBy(xpath="//Button[@AutomationId='TogglePaneButton']")
    public WebElement togglePaneBtn;

    @FindBy(xpath="//Button[@AutomationId='HistoryButton']")
    public WebElement historyBtn;
    @FindBy(xpath="//Text[@AutomationId='CalculatorResults']")
    public WebElement result;


    public CalculatorWindowsPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
