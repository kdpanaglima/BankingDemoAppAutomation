package com.parasoft.banking.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenNewAccountPageLocators {
	
	@FindBy(css="#type")
	public WebElement dropdownAccountType;
	@FindBy(css="#fromAccountId")
	public WebElement dropdownAccountNum;
	@FindBy(css="[value='Open New Account']")
	public WebElement btnOpenNewAccount;
	@FindBy(css=".title")
	public WebElement accountOpenSuccessMsg;
}
