package com.parasoft.banking.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountServicesNavigationLocators {
	
	
	@FindBy(linkText="Open New Account")
	public WebElement linkOpenNewAccount;
	@FindBy(linkText="Accounts Overview")
	public WebElement linkAccountsOverview;
	@FindBy(linkText="Transfer Funds")
	public WebElement linkTransferFunds;
	@FindBy(linkText="Bill Pay")
	public WebElement linkBillPay;
	@FindBy(linkText="Find Transactions")
	public WebElement linkFindTransactions;
	@FindBy(linkText="Update Contact Info")
	public WebElement linkUpdateContactInfo;
	@FindBy(linkText="Request Loan")
	public WebElement linkRequestLoan;
	@FindBy(linkText="Log Out")
	public WebElement linkLogOut;
}
