package com.parasoft.banking.base;

import java.lang.reflect.Method;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.gargoylesoftware.htmlunit.util.StringUtils;
import com.github.javafaker.Faker;
import com.parasoft.banking.base.Constants;
import com.parasoft.banking.pages.actions.AccountServicesNavigation;
import com.parasoft.banking.pages.actions.CustomerLogin;
import com.parasoft.banking.pages.actions.TopNavigation;
import com.parasoft.banking.utilities.ExcelReader;
import com.parasoft.banking.utilities.ExtentManager;

public class BasePage {

	/*
	 * WebDriver
	 * 
	 * ExcelReader
	 * Logs
	 * WebDriverWait
	 * ExtentReports
	 * 
	 * 
	 * 
	 */

	public static Logger log = Logger.getLogger("TestLogger");
	public  ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public  WebDriverWait wait;
	public static ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public  Faker faker;
	public  String browser;
	public  TopNavigation topNav;
	public  CustomerLogin customerLogin;
	public  AccountServicesNavigation accountServicesNav;
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	
	
	@BeforeMethod
	public void initConfiguration(){
		System.out.println("From base page");
//		if(Constants.browser.equals("firefox")){
//			
//			driver = new FirefoxDriver();
//			logDebugMessage("Launching Firefox Browser...");
//		}else 
		if(Constants.browser.equals("chrome")){
			setDriver(new com.parasoft.banking.base.DriverManager().initializeDriver());
			
//			System.setProperty("webdriver.chrome.driver",
//					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
//
//			Map<String, Object> prefs = new HashMap<String, Object>();
//			prefs.put("profile.default_content_setting_values.notifications", 2);
//			prefs.put("credentials_enable_service", false);
//			prefs.put("profile.password_manager_enabled", false);
//			ChromeOptions options = new ChromeOptions();
//			options.setExperimentalOption("prefs", prefs);
//			options.addArguments("--disable-extensions");
//			options.addArguments("--disable-infobars");
//
//			driver = new ChromeDriver(options);
			logDebugMessage("Launching Chrome Browser...");
//		}else if(Constants.browser.equals("ie")){
//			
//			System.setProperty("webdriver.ie.driver",
//					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
//			
//			driver = new InternetExplorerDriver();
//			logDebugMessage("Launching IE Browser...");
//		}else if(Constants.browser.equals("edge")){
//			
//			System.setProperty("webdriver.edge.driver",
//					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\msedgedriver.exe");
//
//			Map<String, Object> prefs = new HashMap<String, Object>();
//			prefs.put("profile.default_content_setting_values.notifications", 2);
//			prefs.put("credentials_enable_service", false);
//			prefs.put("profile.password_manager_enabled", false);
//			EdgeOptions options = new EdgeOptions();
//
//			driver = new EdgeDriver(options);
//			logDebugMessage("Launching Edge Browser...");
//		}
		
		getDriver().get(Constants.testsiteurl);
//		driver.manage().window().maximize();
		faker = new Faker();
	/*	driver.manage().timeouts().implicitlyWait(Constants.implicitwait, TimeUnit.SECONDS);
		wait = new WebDriverWait()*/
		topNav = new TopNavigation(getDriver());
		customerLogin = new CustomerLogin(getDriver());
		accountServicesNav = new AccountServicesNavigation(getDriver());
	}
	}
	
	public synchronized static void setDriver(WebDriver driverRef) {
		driver.set(driverRef);
		
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void click(WebElement element) {

		element.click();
		logDebugMessage("Clicked element:"+trimElement(element.toString()));
		test.log(LogStatus.INFO, "Clicked element" + trimElement(element.toString()));
	}
	
	
	public static void type(WebElement element, String value) {

		element.sendKeys(value);

		logDebugMessage("Entered text " + value + " in element" + trimElement(element.toString()));
		
		test.log(LogStatus.INFO, "Entered text " + value + " in element" + trimElement(element.toString()));

	}
	
	public  String getPageTitle() {
		return getDriver().getTitle();
	}

	@AfterTest
	public synchronized void quitBrowser(){
	
		getDriver().close();
		getDriver().quit();
	}
	
	/**
	 * Use this to log a Debug message
	 * */
	public static void logDebugMessage(String debugMessage) {

		if (log.isDebugEnabled())
			log.debug(debugMessage);
			System.out.println(debugMessage);
	}
	
	/**
	 * Removed unnecessary platform text due from page factory
	 * @param element
	 * @return
	 */
	
	public static String trimElement(String element) {
		
		return element.replaceFirst("(.*)>","");
	}
	
	
}
