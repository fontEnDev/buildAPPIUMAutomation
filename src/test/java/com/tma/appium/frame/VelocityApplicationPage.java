package com.tma.appium.frame;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VelocityApplicationPage extends CommonFunction{
    private final Logger log = LogManager.getLogger(VelocityApplicationPage.class);
    public String xpathProfileURL = "//android.view.View[@content-desc='%s %s']";

    @FindBy(xpath = "//*[@content-desc='☰']/android.widget.TextView")
    public WebElement optionApp;

    @FindBy(xpath = "//*[@content-desc='Create Host Profile']/android.widget.TextView")
    public WebElement createNewProfile;

    @FindBy(xpath = "//*/android.widget.FrameLayout/android.widget.EditText")
    public WebElement inputPassWord;

    @FindBy(id = "android:id/button1")
    public WebElement btnOk_Save;

    @FindBy(xpath = "//*/android.widget.CheckedTextView[2]")
    public WebElement webOption;

    @FindBy(id = "com.wavelink.velocity:id/host_profile_name_field")
    public WebElement inputProfile;

    @FindBy(id = "com.wavelink.velocity:id/host_profile_address_field")
    public WebElement inputAddress;

    @FindBy(id = "android:id/button2")
    public WebElement btnDemo;

    public VelocityApplicationPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
}
