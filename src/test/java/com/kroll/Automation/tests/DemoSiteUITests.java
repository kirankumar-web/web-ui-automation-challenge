package com.kroll.Automation.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.kroll.Automation.Framework.Base.BaseTest;
import com.kroll.Automation.Framework.Constants.Framework_Constants;
import com.kroll.Automation.Framework.Constants.Message_constants;
import com.kroll.Automation.Framework.Pages.Test1Page;
import com.kroll.Automation.Framework.Pages.Test2ListGroupPage;
import com.kroll.Automation.Framework.Pages.Test3DropdownPage;
import com.kroll.Automation.Framework.Pages.Test4ButtonsPage;
import com.kroll.Automation.Framework.Pages.Test5WaitButtonPage;
import com.kroll.Automation.Framework.Pages.Test6GridPage;
import com.kroll.Automation.Framework.Listners.TestListener;

@Listeners(TestListener.class)
public class DemoSiteUITests extends BaseTest {

    @Test
    public void test1_verifyLoginForm() {

        Test1Page loginPage = new Test1Page(driver);

        Assert.assertTrue(loginPage.isEmailDisplayed(), Message_constants.EMAIL_NOT_DISPLAYED);
        Assert.assertTrue(loginPage.isPasswordDisplayed(), Message_constants.PASSWORD_NOT_DISPLAYED);
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), Message_constants.LOGIN_BUTTON_NOT_DISPLAYED);

        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.clickLogin();
    }
    @Test
    public void test2_verifyListGroup()
    {
    Test2ListGroupPage listGroupPage = new Test2ListGroupPage(driver);

    Assert.assertEquals(listGroupPage.getListItemCount(), 3, Message_constants.LIST_ITEM_COUNT_MISMATCH);
    Assert.assertEquals(listGroupPage.getListItemText(1), Framework_Constants.LIST_ITEM_2_TEXT, Message_constants.LIST_ITEM_TEXT_MISMATCH);
    
    }
    
    @Test
    public void test3_verifyDropdown() {

    Test3DropdownPage dropdownPage = new Test3DropdownPage(driver);

    dropdownPage.scrollToDropdown();

    Assert.assertEquals(dropdownPage.getSelectedOption(), Framework_Constants.GET_SELECTED_OPTION);

    dropdownPage.openDropdown();
    dropdownPage.selectOption(Framework_Constants.DROPDOWN_OPTION_3);

    Assert.assertEquals(dropdownPage.getSelectedOption(), Framework_Constants.DROPDOWN_OPTION_3);
}
    @Test
    public void test4_verifyButtonsState()
    {
    	 Test4ButtonsPage buttonsPage = new Test4ButtonsPage(driver);

         buttonsPage.scrollToButtons();

         
         Assert.assertTrue(buttonsPage.isFirstButtonEnabled(),
        		 Message_constants.FIRST_BUTTON_ENABLED_ERROR);

         Assert.assertFalse(buttonsPage.isSecondButtonEnabled(),Message_constants.SECOND_BUTTON_DISABLED_ERROR);

    }
    
    @Test
    public void test5_waitForButtonAndClick()
    {
    Test5WaitButtonPage test5Page = new Test5WaitButtonPage(driver);

    test5Page.scrollToButton();

    test5Page.clickButton();

    Assert.assertTrue(test5Page.isSuccessMessageDisplayed(),
    		Message_constants.SUCCESS_MESSAGE_NOT_DISPLAYED);

    Assert.assertTrue(test5Page.isButtonDisabled(),
    		Message_constants.BUTTON_NOT_DISABLED);
    }
    
    @Test
    public void test6_verifyGridValue() {

        Test6GridPage gridPage = new Test6GridPage(driver);

        gridPage.scrollToGrid();

        String cellValue = gridPage.getGridCellValue(2, 2);        
        Assert.assertEquals(cellValue, "Ventosanzap");

    }
    



}
