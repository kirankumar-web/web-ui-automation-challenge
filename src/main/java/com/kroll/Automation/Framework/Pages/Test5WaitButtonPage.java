package com.kroll.Automation.Framework.Pages;

import com.kroll.Automation.Framework.Utils.WaitUtility; 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Test5WaitButtonPage extends BasePage {

    @FindBy(xpath = "//div[@id='test-5-div']//button")
    private WebElement button;

    @FindBy(xpath = "//div[@id='test-5-div']//div[contains(@class,'alert-success')]")
    private WebElement successMessage;

    public Test5WaitButtonPage(WebDriver driver) {
        super(driver);
    }

    public void scrollToButton() {
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",
            button
        );
    }

    public void clickButton() {
        WaitUtility.waitForClickability(button).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return WaitUtility.waitForVisibility(successMessage).isDisplayed();
    }

    public boolean isButtonDisabled() {
        return !button.isEnabled();
    }
}
