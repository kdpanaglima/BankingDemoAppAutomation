package com.parasoft.banking.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	public static WebDriver initializeDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		System.out.println("Maximizing chrome");
		driver.manage().window().maximize();
		return driver;
		
	}
}