package com.tma.appium.steps;

import com.tma.appium.frame.*;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Context {

    public final Logger log = LogManager.getLogger(Context.class);
    public AndroidDriver driver;
    public static StartClockApplicationPage StartClockObj;
    public static CommonFunction commonFunction;
    public static VelocityApplicationPage VelocityApplicationObj;
    public static HomePage HomePageObj;

}
