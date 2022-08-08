package com.parasoft.banking.testcases;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.parasoft.banking.base.Constants;
import com.parasoft.banking.base.BasePage;
import com.parasoft.banking.errorcollectors.ErrorCollector;
import com.parasoft.banking.pages.actions.CustomerLogin;
import com.parasoft.banking.pages.actions.OpenNewAccountPage;

public class OpenAccount {
	@BeforeTest
	public void setUp(){
		
		BasePage.initConfiguration();
		
	}
	
	@BeforeMethod
	public void startingTestCase(Method method) {
		BasePage.logDebugMessage("********** Start of Test Case:  " + method.getName()+ "  **********");
	}
	
	@Test(priority=1)
	public void TC_010_OpenNewAccountSuccessfully() throws InterruptedException {
		CustomerLogin login = new CustomerLogin();
		login.enterUsername(Constants.parasoftUser);
		login.enterPassword(Constants.parasoftPass);
		login.clickLogin();
	
		OpenNewAccountPage openNewAccount = BasePage.accountServicesNav.clickOpenNewAccountLink();
		openNewAccount.seletAccountType("SAVINGS");
		openNewAccount.seletAccountNum();
		openNewAccount.clickOpenNewAccount();
		
		/**
		 * Kevin Panaglima: Below code to be updated with better wait strategy
		 */
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ErrorCollector.verifyEquals(openNewAccount.getOpenAccountSuccessMsg(), "Account Opened!");
		
	}
	
	
	@AfterMethod
	public void endingTestCase(Method method) {
		BasePage.logDebugMessage("********** End of Test Case:  " + method.getName()+ "  **********");
	}
	
	@AfterTest
	public void tearDown(){
		if(BasePage.driver!=null){
			BasePage.quitBrowser();
		}
	}
}
