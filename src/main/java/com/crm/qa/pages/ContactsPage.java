package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//div[text()='Contacts']")
	WebElement contactLabel;
	
	@FindBy(xpath = "//input[contains(@name,'first_name')]")
	WebElement firstName;
	
	@FindBy(xpath = "//input[contains(@name,'last_name')]")
	WebElement lastName;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Email address')]")
	WebElement email;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Street Address')]")
	WebElement address;
	
	@FindBy(xpath = "//button[contains(@class,'ui linkedin button')]")
	WebElement saveBtn;
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean contactLabel() {
		return contactLabel.isDisplayed();
	}
	
	public void createNewContact(String fName, String lName, String mail, String add) {
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(mail);
		address.sendKeys(add);
		saveBtn.click();
	}
	
	

}
