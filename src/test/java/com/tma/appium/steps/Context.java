package com.tma.appium.steps;

import com.tma.appium.frame.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Context {

    public final Logger log = LogManager.getLogger(Context.class);
    public AppiumDriver<MobileElement> driver;
    public static StartClock StartClockObj;
    public static CommonFunction commonFunction;

}
