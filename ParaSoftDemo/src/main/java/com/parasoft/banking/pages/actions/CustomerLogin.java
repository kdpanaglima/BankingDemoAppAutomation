package com.parasoft.banking.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.parasoft.banking.base.BasePage;
import com.parasoft.banking.pages.locators.CustomerLoginLocators;

public class CustomerLogin extends BasePage{
	
	public CustomerLoginLocators customerLogin;

	public CustomerLogin(WebDriver driver) {

		this.customerLogin = new CustomerLoginLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.customerLogin);

	}
	
	public CustomerLogin() {

		this.customerLogin = new CustomerLoginLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.customerLogin);

	}
	
	public CustomerLookupPage clickForgotLogin() {
		BasePage.click(customerLogin.linkForgotLogin);
		return new CustomerLookupPage();
	}
	
	public RegistrationPage clickRegister() {
		BasePage.click(customerLogin.linkRegister);
		return new RegistrationPage();
	}
	
	
	public void enterUsername(String username) {
		BasePage.type(customerLogin.fldUsername, username);
	}
	
	public void enterPassword(String password) {
		BasePage.type(customerLogin.fldPassword, password);
	}
	
	public void clickLogin() {
		BasePage.click(customerLogin.btnLogin);
	}

	public String getLoginErrorMsg() {
		return customerLogin.loginErrorMsg.getText();
	}
	
	
}
