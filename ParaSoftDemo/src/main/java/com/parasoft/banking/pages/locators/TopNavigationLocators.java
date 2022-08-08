package com.parasoft.banking.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TopNavigationLocators {

	
	@FindBy(linkText="About Us")
	public WebElement linkAboutUs;
	@FindBy(linkText="Services")
	public WebElement linkServices;
	@FindBy(linkText="Products")
	public WebElement linkProducts;
	@FindBy(linkText="Locations")
	public WebElement linkLocations;
	@FindBy(linkText="Admin Page")
	public WebElement linkAdminPage;

	
}
