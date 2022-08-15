package com.parasoft.banking.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.parasoft.banking.base.BasePage;
import com.parasoft.banking.pages.locators.RegistrationPageLocators;

public class RegistrationPage extends BasePage{
	
	public RegistrationPageLocators registration;

	public RegistrationPage() {

		this.registration = new RegistrationPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(getDriver(), 10);
		PageFactory.initElements(factory, this.registration);

	}
	
	public void enterFirstName(String customerFirstName) {
		BasePage.type(registration.fldFirstName, customerFirstName);
	}
	
	public void enterLastName(String customerLastName) {
		BasePage.type(registration.fldLastName, customerLastName);
	}
	
	public void enterAddressStreet(String customerAddress) {
		BasePage.type(registration.fldAddressStreet, customerAddress);
	}
	
	public void enterCity(String customerCity) {
		BasePage.type(registration.fldCity, customerCity);
	}
	
	public void enterState(String customerState) {
		BasePage.type(registration.fldState, customerState);
	}
	
	public void enterZipCode(String customerZipCode) {
		BasePage.type(registration.fldZipCode, customerZipCode);
	}
	
	public void enterPhone(String customerPhoneNumber) {
		BasePage.type(registration.fldPhoneNumber, customerPhoneNumber);
	}
	
	public void enterSSN(String customerSSN) {
		BasePage.type(registration.fldSSN, customerSSN);
	}
	
	public void enterUsername(String customerUsername) {
		BasePage.type(registration.fldUsername, customerUsername);
	}
	
	public void enterPassword(String customerPass) {
		BasePage.type(registration.fldPassword, customerPass);
	}
	
	public void enterConfirmPassword(String confirmPass) {
		BasePage.type(registration.fldConfirmPassword, confirmPass);
	}
	
	public void clickRegister() {
		BasePage.click(registration.btnRegister);
	}
	
	public String getRegisterSuccessMsg() {
		return registration.registrationSuccessMsg.getText();
	}
	
	public String getUsernameErrorMsg() {
		return registration.usernameErrorMsg.getText();
	}

}
