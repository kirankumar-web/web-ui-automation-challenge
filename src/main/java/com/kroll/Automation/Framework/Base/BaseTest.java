package com.kroll.Automation.Framework.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.kroll.Automation.Framework.Utils.BrowserFactory;
import com.kroll.Automation.Framework.Utils.DriverFactory;
import com.kroll.Automation.Framework.config.ConfigReader;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        String browser = ConfigReader.getProperty("browser");

        driver = BrowserFactory.createBrowser(browser);
        DriverFactory.setDriver(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(
                Integer.parseInt(ConfigReader.getProperty("timeout"))
        ));

        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        String url = ConfigReader.getProperty("url");
        DriverFactory.getDriver().get(url); // Always use ThreadLocal driver
    }

    
    @AfterMethod
    public void afterMethod() {
        DriverFactory.getDriver().manage().deleteAllCookies();
    }

   
    @AfterClass
    public void afterClass() {
        DriverFactory.removeDriver(); // Safely quits and removes ThreadLocal
    }
}
