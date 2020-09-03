	package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

//how to improve script performance - use cache lookup

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//div[contains(@class,'header item')]")
	WebElement logo;
	
	@FindBy(xpath = "//span[contains(text(),'Dhanashree Navarkar')]")
	@CacheLookup	
	WebElement userNameLabel;
	
	@FindBy(xpath = "//div[@id='main-nav']//a[3]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//div[@id='main-nav']//a[5]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//div[@id='main-nav']//a[6]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement newContactLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getHomeTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyHomePageLogo() {
		return logo.isDisplayed();
	}
	
	public boolean verifyUserNameLabel() {
		return userNameLabel.isDisplayed();
	}
	
	
	public ContactsPage clickOnContactPage() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealPage() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTaskPage() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContact() {
		newContactLink.click();
	}
	
	

}
