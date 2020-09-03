package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	TestUtil testUtil;
	
	String sheetName = "contact";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initializtion();
		testUtil = new TestUtil();
		contactPage= new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homePage.clickOnContactPage();
	}
	
	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactPage.contactLabel(), "Contacts label missing on page");
	}
	
	@Test(priority = 2)
	public void validateNewContact() {
		homePage.clickOnNewContact();
		contactPage.createNewContact("Rishi", "Muni", "rishimuni@gamil.com", "Chennai");
	}
	
	
//	@DataProvider
//	public Object[][] getCRMTestData(){
//		
//		Object data[][] = TestUtil.getTestData(sheetName);
//		return data;
//		
//	}
//	
//	@Test(priority = 2, dataProvider = "getCRMTestData")
//	public void validateNewContact(String firstName, String lastName, String email, String address) {
//		homePage.clickOnNewContact();
//		//contactPage.createNewContact("Dhanashree", "Navarkar", "dsn@gamil.com", "Pune");
//		contactPage.createNewContact(firstName, lastName, email, address);
//	}
//	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
