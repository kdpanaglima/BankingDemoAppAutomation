package com.parasoft.banking.testcases;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.parasoft.banking.base.BasePage;
import com.parasoft.banking.base.Constants;
import com.parasoft.banking.errorcollectors.ErrorCollector;
import com.parasoft.banking.pages.actions.AccountsOverviewPage;
import com.parasoft.banking.pages.actions.CustomerLogin;
import com.parasoft.banking.utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyCustomerLogin extends BasePage{
	
	@BeforeTest
	public void setUp() {
		initConfiguration();
	}
	
	@BeforeMethod
	public void startingTestCase(Method method) {
		BasePage.logDebugMessage("****************************************************************************************");
		BasePage.logDebugMessage("********** Start of Test Case: " + method.getName() + "  **********");
		BasePage.logDebugMessage("****************************************************************************************");
	}
	
	@AfterMethod
	public void endingTestCase(Method method) {
		BasePage.logDebugMessage("****************************************************************************************");
		BasePage.logDebugMessage("********** End of Test Case: " + method.getName()+ "  **********");
		BasePage.logDebugMessage("****************************************************************************************");
		
	}
	
	@AfterTest
	public void tearDown(){
		if(getDriver()!=null){
			quitBrowser();
		}
	}
	
	@DataProvider(parallel = true)
	@Test
	public void TC_001_VerifyEmptyCredentialFields() {
		CustomerLogin customerLogin = new CustomerLogin();
		customerLogin.clickLogin();
		ErrorCollector.verifyEquals(customerLogin.getLoginErrorMsg(), "Please enter a username and password.");
		
	}
	@DataProvider(parallel = true)
	@Test
	public void TC_002_VerifyIncorrectCredentials() {
		CustomerLogin customerLogin = new CustomerLogin();
		customerLogin.enterUsername("Radwimps");
		customerLogin.enterPassword("j)881-+jsAs");
		customerLogin.clickLogin();
		ErrorCollector.verifyEquals(customerLogin.getLoginErrorMsg(), "The username and password could not be verified.");
		
		
	}
	@DataProvider(parallel = true)
	@Test
	public void TC_003_VerifyLoginSuccessful() {
		CustomerLogin login = new CustomerLogin();
		login.enterUsername(Constants.parasoftUser);
		login.enterPassword(Constants.parasoftPass);
		login.clickLogin();
//		AccountsOverviewPage accountsOverview = new AccountsOverviewPage();
		ErrorCollector.verifyEquals(getPageTitle(), "ParaBank | Accounts Overview");
		
	}
	
	
}
