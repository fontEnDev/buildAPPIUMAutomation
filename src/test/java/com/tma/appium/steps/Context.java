package com.tma.appium.steps;

import com.tma.appium.frame.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.windows.WindowsDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Context {

    public final Logger log = LogManager.getLogger(Context.class);
    public AppiumDriver driver;
    public AppiumDriver wDriver;
    public static StartClockApplicationPage StartClockObj;
    public static CommonFunction commonFunction;
    public static VelocityApplicationPage VelocityApplicationObj;
    public static HomePage HomePageObj;

    public static CalculatorWindowsPage CalculatorWindowsPageObj;

}
