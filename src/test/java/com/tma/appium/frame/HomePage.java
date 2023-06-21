package com.tma.appium.frame;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonFunction{


    @FindBy(id ="com.android.launcher3:id/page_indicator")
    public WebElement pageIndicator;

    @FindBy(id ="com.android.quicksearchbox:id/search_widget_text")
    public WebElement searchWidget;

    @FindBy(id ="com.android.launcher3:id/search_container_all_apps")
    public WebElement searchApp;

    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }
}
