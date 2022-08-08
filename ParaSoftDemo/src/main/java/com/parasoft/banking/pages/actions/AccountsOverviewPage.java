package com.parasoft.banking.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.parasoft.banking.base.BasePage;
import com.parasoft.banking.pages.locators.AccountsOverviewPageLocators;

public class AccountsOverviewPage extends BasePage{

	public AccountsOverviewPageLocators accountsOverview;

	public AccountsOverviewPage() {

		this.accountsOverview = new AccountsOverviewPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.accountsOverview);

	}
	
	
}
