package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	
	public WebDriver driver;
	//test git
	//to run the feature in parallel mode
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	
	//method to initialize the ThreadLocal driver based on given browser.
	public WebDriver init_driver(String browser) {
		System.out.println("Browser value is :"+ browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}else if(browser.equals("safari")) {
			tldriver.set(new SafariDriver());
		}else {
			System.out.println("Please enter the corrcet browser");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().fullscreen();
		return getDriver();		
	}	
	/**
	 * This is used to get the driver using ThreadLocal
	 * */
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	
}
