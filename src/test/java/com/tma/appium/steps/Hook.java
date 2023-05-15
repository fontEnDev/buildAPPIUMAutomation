package com.tma.appium.steps;

import com.tma.appium.frame.CommonFunction;
import com.tma.appium.frame.StartClock;
import com.tma.appium.lib.EnvSetup;
import com.tma.appium.lib.UtilityFun;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hook {
    private final Context context;

    public Hook(Context context) {
        this.context = context;
    }

    @BeforeAll(order = 10)
    public static void loadEnv() {
        EnvSetup.init();
    }

    @Before (order = 10)
    public void setUp() {
        context.driver = EnvSetup.connectAppium();
        context.commonFunction = new CommonFunction(context.driver);
        context.StartClockObj = new StartClock(context.driver);
    }

    @AfterAll(order = 10)
    public static void cleanUpLab() {
    }



    @After (order = 10)
    public void closeBrowser(){
        Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println("Close browser");
        EnvSetup.closeDriver(context.driver);
    }

}
