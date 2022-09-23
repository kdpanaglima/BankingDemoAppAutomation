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
import com.parasoft.banking.errorcollectors.ErrorCollector;
import com.parasoft.banking.pages.actions.CustomerLogin;
import com.parasoft.banking.pages.actions.RegistrationPage;
import com.parasoft.banking.utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyCustomerRegistration extends BasePage{

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
	public void TC_004_RegisterCustomerSuccessfully() {

		RegistrationPage registration = customerLogin.clickRegister();
		registration.enterFirstName("John");
		registration.enterLastName("Doe");
		registration.enterAddressStreet("light street");
		registration.enterCity("Dallas");
		registration.enterState("Texas");
		registration.enterZipCode("5122");
		registration.enterPhone("0001");
		registration.enterSSN("4123-1233");
		registration.enterUsername(faker.name().firstName().toString());
		registration.enterPassword("rain");
		registration.enterConfirmPassword("rain");
		registration.clickRegister();

		ErrorCollector.verifyEquals(registration.getRegisterSuccessMsg(),
				"Your account was created successfully. You are now logged in.");

	}


	public void TC_005_VerifyUsernameFieldExists() {

		RegistrationPage registration = customerLogin.clickRegister();
		registration.enterFirstName("John");
		registration.enterLastName("Doe");
		registration.enterAddressStreet("light street");
		registration.enterCity("Dallas");
		registration.enterState("Texas");
		registration.enterZipCode("5122");
		registration.enterPhone("0001");
		registration.enterSSN("4123-1233");
		registration.enterUsername("travis");
		registration.enterPassword("rain");
		registration.enterConfirmPassword("rain");
		registration.clickRegister();
		ErrorCollector.verifyEquals(registration.getUsernameErrorMsg(), "This username already exists.");

	}

}
