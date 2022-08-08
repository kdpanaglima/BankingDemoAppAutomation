package com.parasoft.banking.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPageLocators {
	
	@FindBy(css="[name='customer.firstName']")
	public WebElement fldFirstName;
	@FindBy(css="[name='customer.lastName']")
	public WebElement fldLastName;
	@FindBy(css="[name='customer.address.street']")
	public WebElement fldAddressStreet;
	@FindBy(css="[name='customer.address.city']")
	public WebElement fldCity;
	@FindBy(css="[name='customer.address.state']")
	public WebElement fldState;
	@FindBy(css="[name='customer.address.zipCode']")
	public WebElement fldZipCode;
	@FindBy(css="[name='customer.phoneNumber']")
	public WebElement fldPhoneNumber;
	@FindBy(css="[name='customer.ssn']")
	public WebElement fldSSN;
	@FindBy(css="[name='customer.username']")
	public WebElement fldUsername;
	@FindBy(css="[name='customer.password']")
	public WebElement fldPassword;
	@FindBy(css="[name='repeatedPassword']")
	public WebElement fldConfirmPassword;
	@FindBy(css="[value='Register']")
	public WebElement btnRegister;
	@FindBy(css="#rightPanel p")
	public WebElement registrationSuccessMsg;
	@FindBy(css="[id='customer.username.errors']")
	public WebElement usernameErrorMsg;
	
	
	
}
