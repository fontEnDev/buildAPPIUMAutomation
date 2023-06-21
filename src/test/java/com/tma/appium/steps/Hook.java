package com.tma.appium.steps;

import com.tma.appium.frame.*;
import com.tma.appium.lib.EnvSetup;
import com.tma.appium.lib.Log4J2;
import io.cucumber.java.*;

public class Hook {
    private final Context context;

    public Hook(Context context) {
        this.context = context;
    }

    @BeforeAll(order = 10)
    public static void loadEnv() {
        EnvSetup.init();
        Log4J2.init();
    }

    @Before (order = 10)
    public void setUp() {
//        context.driver = EnvSetup.connectAppium();
        context.wDriver = EnvSetup.connectWithWinAppDriver();
//        context.commonFunction = new CommonFunction(context.driver);
//        context.StartClockObj = new StartClockApplicationPage(context.driver);
//        context.HomePageObj = new HomePage(context.driver);
//        context.VelocityApplicationObj = new VelocityApplicationPage(context.driver);
        context.CalculatorWindowsPageObj = new CalculatorWindowsPage(context.wDriver);
    }

    @AfterAll(order = 10)
    public static void cleanUpLab() {
    }



    @After (order = 10)
    public void closeBrowser(){
        Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println("Close browser");
        EnvSetup.closeDriver(context.wDriver);
    }

}
