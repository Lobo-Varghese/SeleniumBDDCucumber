package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;

public class LoginPage {
	
	private WebDriver driver = DriverFactory.getDriver();
	
	//1.By Locators Or OR
	
	private By emailId = By.id("email");
	private By password  = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?11");
	
	//2. Constructor of the page Class
	public LoginPage(WebDriver driver) {
		driver = this.driver;
	}
	
	
	//page actions : feature of the page that form the method
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean forgotPasswordLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}
}
