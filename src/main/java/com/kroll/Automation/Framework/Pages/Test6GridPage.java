package com.kroll.Automation.Framework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Test6GridPage extends BasePage {


    private By table = By.xpath("//div[@id='test-6-div']//table");

    public Test6GridPage(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(driver, this);
    }

    public void scrollToGrid() {
        WebElement gridTable = driver.findElement(table);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",
                gridTable
        );
    }

    public String getGridCellValue(int row, int col) {
        return driver.findElement(
                By.xpath("//div[@id='test-6-div']//table//tr[" + (row + 1) + "]//td[" + (col + 1) + "]")
        ).getText();
    }
}
