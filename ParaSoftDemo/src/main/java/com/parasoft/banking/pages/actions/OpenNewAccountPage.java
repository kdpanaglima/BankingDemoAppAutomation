package com.parasoft.banking.pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import com.parasoft.banking.base.BasePage;
import com.parasoft.banking.pages.locators.OpenNewAccountPageLocators;

public class OpenNewAccountPage extends BasePage {
	
	public OpenNewAccountPageLocators openNewAccountLocators;

	public OpenNewAccountPage() {

		this.openNewAccountLocators = new OpenNewAccountPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.openNewAccountLocators);

	}
	
	public void seletAccountType(String accountType) {
		Select dropdownType = new Select(openNewAccountLocators.dropdownAccountType);
		dropdownType.selectByVisibleText(accountType);
	}
	
	public void seletAccountNum() {
		Select dropdownAccNum = new Select(openNewAccountLocators.dropdownAccountNum);
		dropdownAccNum.selectByIndex(0);
	}
	
	public void clickOpenNewAccount() {
		BasePage.click(openNewAccountLocators.btnOpenNewAccount);
	}
	
	public String getOpenAccountSuccessMsg() {
		return openNewAccountLocators.accountOpenSuccessMsg.getText();
	}
	

}
