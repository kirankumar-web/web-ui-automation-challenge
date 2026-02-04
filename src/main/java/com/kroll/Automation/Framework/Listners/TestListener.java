package com.kroll.Automation.Framework.Listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.kroll.Automation.Framework.Utils.ExtentManager;
import com.kroll.Automation.Framework.Utils.ScreenshotUtils;

import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {

    private static final ExtentReports extent = ExtentManager.getInstance();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test.set(
                extent.createTest(result.getMethod().getMethodName())
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        // Take screenshot once
        String screenshotPath =
                ScreenshotUtils.takeScreenshot(result.getMethod().getMethodName());
        byte[] screenshotBytes =
                ScreenshotUtils.takeScreenshotAsBytes();

        // Attach to Extent
        test.get().fail(
                result.getThrowable(),
                MediaEntityBuilder
                        .createScreenCaptureFromPath(screenshotPath)
                        .build()
        );

        // Attach to Allure
        Allure.addAttachment(
                "Failure Screenshot - " + result.getMethod().getMethodName(),
                new ByteArrayInputStream(screenshotBytes)
        );
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
