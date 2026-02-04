package com.kroll.Automation.Framework.Utils;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitUtility {
    
    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    private static WebDriverWait getWait() {
        return new WebDriverWait(DriverFactory.getDriver(), TIMEOUT);
    }

    public static WebElement waitForVisibility(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickability(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForVisibility(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}