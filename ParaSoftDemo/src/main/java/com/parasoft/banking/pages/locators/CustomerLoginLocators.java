package com.parasoft.banking.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginLocators {
	
	@FindBy(css="[name='username']")
	public WebElement fldUsername;
	@FindBy(css="[name='password']")
	public WebElement fldPassword;
	@FindBy(css="[value='Log In']")
	public WebElement btnLogin;
	@FindBy(linkText="Forgot login info?")
	public WebElement linkForgotLogin;
	@FindBy(linkText="Register")
	public WebElement linkRegister;
	
	@FindBy(css=".error")
	public WebElement loginErrorMsg;
	
	
	
}
