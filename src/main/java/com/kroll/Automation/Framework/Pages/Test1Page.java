package com.kroll.Automation.Framework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.kroll.Automation.Framework.config.ConfigReader;

public class Test1Page extends BasePage {


	    private By emailInput = By.xpath("//div[@id='test-1-div']//input[@type='email']");
	    private By passwordInput = By.xpath("//div[@id='test-1-div']//input[@type='password']");
	    private By loginButton = By.xpath("//div[@id='test-1-div']//button");

	    // Constructor
	    public Test1Page(WebDriver driver) {
	        super(driver);
	        
	    }

	    public WebElement getEmailInput() {
	        return driver.findElement(emailInput);
	    }

	    public WebElement getPasswordInput() {
	        return driver.findElement(passwordInput);
	    }

	    public WebElement getLoginButton() {
	        return driver.findElement(loginButton);
	    }        

	    public void enterEmail() {
	        getEmailInput().sendKeys(ConfigReader.getProperty("username"));
	    }

	    public void enterPassword() {
	        getPasswordInput().sendKeys(ConfigReader.getProperty("password"));
	    }

	    public void clickLogin() {
	        getLoginButton().click();
	    }

	    public boolean isEmailDisplayed() {
	        return getEmailInput().isDisplayed();
	    }

	    public boolean isPasswordDisplayed() {
	        return getPasswordInput().isDisplayed();
	    }

	    public boolean isLoginButtonDisplayed() {
	        return getLoginButton().isDisplayed();
	    }
	


}
