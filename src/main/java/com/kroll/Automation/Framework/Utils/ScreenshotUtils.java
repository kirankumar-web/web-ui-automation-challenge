package com.kroll.Automation.Framework.Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import com.kroll.Automation.Framework.config.ConfigReader;

public class ScreenshotUtils {

    static //private static final String SCREENSHOT_DIR = "reports/screenshots/";
    String SCREENSHOT_DIR=ConfigReader.getProperty("SCREENSHOT_DIR");


    public static String takeScreenshot(String testName) {
        WebDriver driver = DriverFactory.getDriver();

        if (driver == null) {
            throw new RuntimeException("WebDriver is null. Cannot take screenshot.");
        }

        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File folder = new File(SCREENSHOT_DIR);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String path = SCREENSHOT_DIR + testName + ".png";
            FileUtils.copyFile(source, new File(path));

            return path;

        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot for: " + testName, e);
        }
    }


    public static byte[] takeScreenshotAsBytes() {
        WebDriver driver = DriverFactory.getDriver();

        if (driver == null) {
            throw new RuntimeException("WebDriver is null. Cannot take screenshot.");
        }

        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
