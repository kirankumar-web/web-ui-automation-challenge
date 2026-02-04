package com.kroll.Automation.Framework.Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Test3DropdownPage extends BasePage {


    @FindBy(id = "dropdownMenuButton")
    private WebElement dropdownButton;

    @FindBy(xpath = "//div[@id='test-3-div']//a[@class='dropdown-item']")
    private List<WebElement> dropdownOptions;

    public Test3DropdownPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void scrollToDropdown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",
                dropdownButton
        );
    }

    public String getSelectedOption() {
        return dropdownButton.getText().trim();
    }

    public void openDropdown() {
        dropdownButton.click();
    }

    public void selectOption(String optionText) {
        for (WebElement option : dropdownOptions) {
            if (option.getText().equals(optionText)) {
                option.click();
                break;
            }
        }
    }
}
