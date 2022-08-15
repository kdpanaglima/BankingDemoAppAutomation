package com.parasoft.banking.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.parasoft.banking.base.BasePage;
import com.parasoft.banking.pages.locators.CustomerLookupPageLocators;

public class CustomerLookupPage extends BasePage{
	
	public CustomerLookupPageLocators customerLookup;

	public CustomerLookupPage() {

		this.customerLookup = new CustomerLookupPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(getDriver(), 10);
		PageFactory.initElements(factory, this.customerLookup);

	}
	
}

