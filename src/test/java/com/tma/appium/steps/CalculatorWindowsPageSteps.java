package com.tma.appium.steps;

import com.tma.appium.frame.CalculatorWindowsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class CalculatorWindowsPageSteps extends Context{
    Context context;
    public final Logger log = LogManager.getLogger(StartClockSteps.class);

    public CalculatorWindowsPageSteps(Context context) {
        this.wDriver = context.wDriver;
        this.CalculatorWindowsPageObj = context.CalculatorWindowsPageObj;
    }

    @Given("Delete all data display on screen")
    public void clearAllDataDisplayScreen() throws InterruptedException {
        CalculatorWindowsPageObj.clearEntryBtn.click();
        Thread.sleep((long) (2 * 1000));
    }

    @When("Input simple math to screen")
    public void inputSimpleMathToScreen() throws InterruptedException {
        log.info("Practice 8 + 8 x 6");
        CalculatorWindowsPageObj.eightNumberBtn.click();
        CalculatorWindowsPageObj.plusBtn.click();
        CalculatorWindowsPageObj.eightNumberBtn.click();
        CalculatorWindowsPageObj.multiplyBtn.click();
        CalculatorWindowsPageObj.sixNumberBtn.click();
        Thread.sleep((long) (2 * 1000));
        CalculatorWindowsPageObj.equalBtn.click();
    }

    @Then("Result display correctly")
    public void resultDisplayCorrectly() {
        log.info("Verify result display correctly");
        int expectedResult = (8+8) * 6;
        int actualResult = Integer.parseInt(CalculatorWindowsPageObj.result.getText().replaceAll("\\D+", ""));
        Assert.assertEquals("Calculator work incorrectly", expectedResult, actualResult);
    }
}
