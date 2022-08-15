package com.parasoft.banking.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.parasoft.banking.base.BasePage;
import com.parasoft.banking.pages.locators.AccountServicesNavigationLocators;

public class AccountServicesNavigation extends BasePage {
	
	public AccountServicesNavigationLocators accountServicesNavigation;

	public AccountServicesNavigation(WebDriver driver) {

		this.accountServicesNavigation = new AccountServicesNavigationLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.accountServicesNavigation);

	}
	
	public AccountServicesNavigation() {

		this.accountServicesNavigation = new AccountServicesNavigationLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(getDriver(), 10);
		PageFactory.initElements(factory, this.accountServicesNavigation);

	}
	
	public OpenNewAccountPage clickOpenNewAccountLink(){
	
			BasePage.click(accountServicesNavigation.linkOpenNewAccount);
			
		return new OpenNewAccountPage();
	}
	
	

}
