package com.tma.appium.lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class EnvSetup {

    private static final Logger log = LogManager.getLogger(EnvSetup.class);
    public static String SUITE_PATH = System.getProperty("user.dir").replaceAll("\\\\", "/") + "/";
    public static final String LOGGER_PROPERTY_FILE = SUITE_PATH + "src/test/resources/config/log4j2_configure.xml";
    public static Properties prop;
    public static String DEVICE_NAME = "";
    public static String PLATFORM_NAME = "";
    public static String PLATFORM_VERSION = "";
    public static String APP_PACKAGE = "";
    public static String APP_ACTIVITY = "";
    public static String USER_PROPERTY_FILE_PATH = "";

    public EnvSetup() {
    }

    public static void init() {

        UtilityFun utilityFun = new UtilityFun();

        String configFile = System.getProperty("CONFIG_FILE", "");
        if (configFile.isEmpty()) {
            USER_PROPERTY_FILE_PATH = SUITE_PATH + "src/test/resources/config/" + utilityFun.readPropertyValue("CONFIG_FILE",
                    SUITE_PATH + "src/test/resources/config/default.properties");
        } else {
            USER_PROPERTY_FILE_PATH = SUITE_PATH + "src/test/resources/config/" + configFile;
        }
        log.info("Properties File Path: " + EnvSetup.USER_PROPERTY_FILE_PATH);
        prop = new Properties();
        try (InputStream input = Files.newInputStream(Paths.get(USER_PROPERTY_FILE_PATH))) {
            prop.load(input);
            prop.entrySet().removeIf(e -> e.getValue().toString().matches("[`'\"]\\s*[`'\"]|\\s+|[`'\"]\\s*|\\s*[`'\"]|^$"));
            prop.putAll(System.getProperties());
        } catch (Exception e) {
            log.info("Exception when load properties file");
            e.printStackTrace();
        }

        DEVICE_NAME = prop.getProperty("DEVICE_NAME", "Pixel 5 API 30");
        PLATFORM_NAME = prop.getProperty("PLATFORM_NAME", "Android");
        PLATFORM_VERSION = prop.getProperty("PLATFORM_VERSION", "11");
        APP_PACKAGE = prop.getProperty("APP_PACKAGE", "com.android.launcher3");
        APP_ACTIVITY = prop.getProperty("APP_ACTIVITY", ".uioverrides.QuickstepLauncher");

    }

    public static AndroidDriver connectAppium(){
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", DEVICE_NAME);
        cap.setCapability("platformName", PLATFORM_NAME);
        cap.setCapability("platformVersion", PLATFORM_VERSION);
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("appPackage", "");
        cap.setCapability("appActivity", "");
        cap.setCapability("noReset", "true");
        cap.setCapability("uiautomator2ServerInstallTimeout", "60000");
        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            AndroidDriver driver = new AndroidDriver(url, cap);
            log.info("Start Application..........");
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            return driver;
        } catch (Exception e) {
            log.info("Can not start Clock ");
            return null;
        }
    }


//    public static AppiumDriver<MobileElement> connectAppium(){
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("deviceName", DEVICE_NAME);
//        cap.setCapability("platformName", PLATFORM_NAME);
//        cap.setCapability("platformVersion", PLATFORM_VERSION);
//        cap.setCapability("automationName", "UiAutomator2");
//        cap.setCapability("appPackage", APP_PACKAGE);
//        cap.setCapability("appActivity", APP_ACTIVITY);
//        cap.setCapability("noReset", "true");
//        cap.setCapability("uiautomator2ServerInstallTimeout", "60000");
//        try {
//            URL url = new URL("http://127.0.0.1:4723/wd/hub");
//            AppiumDriver<MobileElement> driver = new AppiumDriver<MobileElement>(url, cap);
//            log.info("Start Application..........");
//            return driver;
//        } catch (Exception e) {
//            log.info("Can not start Clock ");
//            return null;
//        }
//    }

//    public static AppiumDriver<MobileElement> connectAppiumSaucelabs() {
//        String sSauceLabsUserName = "oauth-votruong020720-d63f4";
//        String sSauceLabsAccessKey = "566f6155-169e-493d-9174-8c1c3d49e746";
//        String sSauceLabsURL = "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
//        try {
//            URL url = new URL("https://" + sSauceLabsUserName + ":" + sSauceLabsAccessKey + sSauceLabsURL);
//            MutableCapabilities caps = new MutableCapabilities();
//            caps.setCapability("platformName", "Android");
//            caps.setCapability("appium:deviceName", "Samsung_Galaxy_S9_free");
//            caps.setCapability("appium:platformVersion", "10.0");
//            java.util.Map<String, Object> sauceOptions = new java.util.HashMap<>();
//            sauceOptions.put("extendedDebugging", "true");
//            sauceOptions.put("parentTunnel", "depottestautomation");;
//            sauceOptions.put("screenResolution", "320x534");
//            sauceOptions.put("idleTimeout", 600);
//            sauceOptions.put("extendedDebugging", true);
//            caps.setCapability("sauce:options", sauceOptions);
//            AppiumDriver<MobileElement> rDriver = new AppiumDriver(url, caps);
//            System.out.println("Driver is initialized...");
//            return rDriver;
//        } catch (Exception e) {
//            log.info("Can not start Clock ");
//            return null;
//        }
//    }
//
//    public static AndroidDriver<AndroidElement> connectAppiumWithAndroidElement() {
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("deviceName", DEVICE_NAME);
//        cap.setCapability("platformName", PLATFORM_NAME);
//        cap.setCapability("platformVersion", PLATFORM_VERSION);
//        cap.setCapability("automationName", "UiAutomator2");
//        cap.setCapability("appPackage", APP_PACKAGE);
//        cap.setCapability("appActivity", APP_ACTIVITY);
//        cap.setCapability("noReset", "true");
//        cap.setCapability("uiautomator2ServerInstallTimeout", "60000");
//        try {
//            URL url = new URL("http://127.0.0.1:4723/wd/hub");
//            AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, cap);
//            log.info("Start Application..........");
//            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//            return driver;
//        } catch (Exception e) {
//            log.info("Can not start Clock ");
//            return null;
//        }
//    }

//    public static void closeDriver(AppiumDriver<AndroidElement> driver) {
//        try {
//            if (driver != null) {
//                driver.close();
//            }
//        } catch (Exception e) {
//            log.info("No need to quit driver");
//        }
//
//    }
}
