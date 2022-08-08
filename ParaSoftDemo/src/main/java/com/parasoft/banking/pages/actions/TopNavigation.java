package com.parasoft.banking.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.parasoft.banking.base.BasePage;
import com.parasoft.banking.pages.locators.TopNavigationLocators;

public class TopNavigation {

	public TopNavigationLocators topNavigation;

	public TopNavigation(WebDriver driver) {

		this.topNavigation = new TopNavigationLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.topNavigation);

	}

	public void clickAboutUs() {
		BasePage.click(topNavigation.linkAboutUs);
	}

	public void clickToServices() {
		BasePage.click(topNavigation.linkServices);
	}

	public void clickProducts() {
		BasePage.click(topNavigation.linkProducts);
	}

	public void clickLocations() {
		BasePage.click(topNavigation.linkLocations);
	}

	public void clickAdminPage() {
		BasePage.click(topNavigation.linkAdminPage);
	}
}
