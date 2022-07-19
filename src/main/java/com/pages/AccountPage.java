package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.factory.DriverFactory;



public class AccountPage {
	
	private WebDriver driver = DriverFactory.getDriver();
	
	//By Locators or OR
	
	private By accountSections = By.cssSelector("div#center_column span");

	
	//constructor
	AccountPage(WebDriver driver){
		 this.driver = driver;
	}
	
	//page actions
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
	
	public int getAccountsSectioncount() {
		return driver.findElements(accountSections).size();
	}
	
	public List<String> getAccountsSectionsList() {
		List<String> accountsList = new ArrayList<>();
		List<WebElement> accountsHeaderList = driver.findElements(accountSections);
		for(WebElement e : accountsHeaderList) {
			String text = e.getText();
			accountsList.add(text);
		}
		return accountsList;
	}
}
