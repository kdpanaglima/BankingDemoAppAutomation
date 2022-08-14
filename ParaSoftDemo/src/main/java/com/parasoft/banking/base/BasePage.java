package com.parasoft.banking.base;

import java.lang.reflect.Method;
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
	public static WebDriver driver;
	public static Logger log = Logger.getLogger("TestLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static Faker faker;
	public static String browser;
	public static TopNavigation topNav;
	public static CustomerLogin customerLogin;
	public static AccountServicesNavigation accountServicesNav;
	
	@BeforeMethod
	public static void initConfiguration(){
		
		if(Constants.browser.equals("firefox")){
			
			driver = new FirefoxDriver();
			logDebugMessage("Launching Firefox Browser...");
		}else if(Constants.browser.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");

			driver = new ChromeDriver(options);
			logDebugMessage("Launching Chrome Browser...");
		}else if(Constants.browser.equals("ie")){
			
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			
			driver = new InternetExplorerDriver();
			logDebugMessage("Launching IE Browser...");
		}else if(Constants.browser.equals("edge")){
			
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\msedgedriver.exe");

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			EdgeOptions options = new EdgeOptions();

			driver = new EdgeDriver(options);
			logDebugMessage("Launching Edge Browser...");
		}
		
		driver.get(Constants.testsiteurl);
		driver.manage().window().maximize();
		faker = new Faker();
	/*	driver.manage().timeouts().implicitlyWait(Constants.implicitwait, TimeUnit.SECONDS);
		wait = new WebDriverWait()*/
		topNav = new TopNavigation(driver);
		customerLogin = new CustomerLogin(driver);
		accountServicesNav = new AccountServicesNavigation(driver);
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
	
	public static String getPageTitle() {
		return driver.getTitle();
	}

	
	public static void quitBrowser(){
	
		driver.close();
		driver.quit();
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
