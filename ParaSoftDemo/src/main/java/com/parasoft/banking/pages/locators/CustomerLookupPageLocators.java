package com.parasoft.banking.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerLookupPageLocators {

	@FindBy(css="#firstName")
	public WebElement fldFirstName;
	@FindBy(css="#lastName")
	public WebElement fldLastName;
	@FindBy(css="[name='address.street']")
	public WebElement fldAddress;
	@FindBy(css="[name='address.city']")
	public WebElement fldCity;
	@FindBy(css="[name='address.state']")
	public WebElement fldState;
	@FindBy(css="[name='address.zipcode']")
	public WebElement fldZipCode;
	@FindBy(css="#ssn")
	public WebElement fldSSN;
	
}
