package com.tma.appium.frame;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.vi.Nhưng;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonFunction {

    protected AndroidDriver driver;

    private final static PointerInput FINGER = new PointerInput(TOUCH, "finger");
    private final Logger log = LogManager.getLogger(CommonFunction.class);

    public CommonFunction(AndroidDriver driver){
        this.driver = driver;
    }

    public void sleepInSec(double sec) {
        try {
            Thread.sleep((long) (sec * 1000));
        } catch (Exception ignored) {
        }
    }

    public WebElement findElementById(String id){
        System.out.println("Entering Step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        WebElement elementID = driver.findElement(By.id(id));
        return elementID;
    }

    public WebElement findElementByXpath(String xpath){
        System.out.println("Entering Step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        WebElement elementXpath = driver.findElement(By.xpath(xpath));
        return elementXpath;
    }
    public int countNumberElementByXpath(String xpath){
        System.out.println("Entering Step: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        int numberElement;
        try{
            List <WebElement> element= driver.findElements(By.xpath(xpath));
            numberElement = element.size();
        }
        catch (Exception e){
            log.info("No find element by xpath: " + xpath );
            numberElement = 0;
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return numberElement;
    }



    public void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {
        Sequence swipe = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
                .addAction(FINGER.createPointerDown(LEFT.asArg()))
                .addAction(FINGER.createPointerMove(ofMillis(duration), viewport(), end.getX(), end.getY()))
                .addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
    }

    public void doTap(AppiumDriver driver, Point point, int duration) {
        Sequence tap = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), point.getX(), point.getY()))
                .addAction(FINGER.createPointerDown(LEFT.asArg()))
                .addAction(new Pause(FINGER, ofMillis(duration)))
                .addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
    }

    public void swipeDriver(double startWidth, double startHeight, double endWidth, double endHeight ){
        Dimension dimension = driver.manage().window().getSize();
        Point start = new Point((int)(dimension.width*startWidth), (int)(dimension.height*startHeight));
        Point end = new Point((int)(dimension.width*endWidth), (int)(dimension.height*endHeight));
        this.doSwipe(driver, start, end, 200);  //with duration 1s
    }

    public void tapDriver(double width, double height ){
        Dimension dimension = driver.manage().window().getSize();
        Point forTap = new Point((int)(dimension.width*width), (int)(dimension.height*height));
        this.doTap(driver, forTap, 200); //with duration 200ms
    }

    public WebElement findElementByContentDesc(String contentDesc){
        WebElement element = driver.findElement(By.xpath("//*[@content-desc='" + contentDesc + "']"));
        return element;
    }
}
