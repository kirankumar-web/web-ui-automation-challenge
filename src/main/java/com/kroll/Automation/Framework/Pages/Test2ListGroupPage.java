package com.kroll.Automation.Framework.Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test2ListGroupPage extends BasePage{


    private By listItems = By.xpath("//*[@id='test-2-div']//li");
    private By badge = By.className("badge");

    public Test2ListGroupPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllListItems() {
        return driver.findElements(listItems);
    }

    public String getListItemText(int index) {
        WebElement item = getAllListItems().get(index);
        String badgeValue = item.findElement(badge).getText();
        return item.getText().replace(badgeValue, "").trim();
    }

    public String getBadgeValue(int index) {
        return getAllListItems().get(index).findElement(badge).getText();
    }

    public int getListItemCount() {
        return getAllListItems().size();
    }
}
