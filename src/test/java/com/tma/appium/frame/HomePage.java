package com.tma.appium.frame;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonFunction{


    public @FindBy(id ="com.android.launcher3:id/page_indicator")
    WebElement pageIndicator;

    public @FindBy(id ="com.android.quicksearchbox:id/search_widget_text")
    WebElement searchWidget;

    public @FindBy(id ="com.android.launcher3:id/search_container_all_apps")
    WebElement searchApp;

    public HomePage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }
}
