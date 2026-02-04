package com.kroll.Automation.Framework.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Test4ButtonsPage extends BasePage {


    @FindBy(xpath = "//div[@id='test-4-div']//button[1]")
    private WebElement firstButton;

    @FindBy(xpath = "//div[@id='test-4-div']//button[2]")
    private WebElement secondButton;

    public Test4ButtonsPage(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(driver, this);
    }

    public void scrollToButtons() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",
                firstButton
        );
    }

    public boolean isFirstButtonEnabled() {
        return firstButton.isEnabled();
    }

    public boolean isSecondButtonEnabled() {
        return secondButton.isEnabled();
    }
}
