package com.tma.appium.frame;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class CommonFunction {

    protected AppiumDriver<MobileElement> driver;
    private final Logger log = LogManager.getLogger(CommonFunction.class);

    public CommonFunction(AppiumDriver<MobileElement> driver){
        this.driver = driver;
    }

    public void sleepInSec(double sec) {
        try {
            Thread.sleep((long) (sec * 1000));
        } catch (Exception ignored) {
        }
    }

    public MobileElement findElementById(String id){
        System.out.println("Entering Step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        MobileElement elementID = driver.findElementById(id);
        return elementID;
    }

    public MobileElement findElementByXpath(String xpath){
        System.out.println("Entering Step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        MobileElement elementXpath = driver.findElement(By.xpath(xpath));
        return elementXpath;
    }
}
