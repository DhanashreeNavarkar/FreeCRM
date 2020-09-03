package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	TestUtil testUtil;
	
	 public HomePageTest() {
		 super();
	}
	
	@BeforeMethod
	public void setUp() {
		initializtion();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void validatHomePageTitleTest() {
		String homeTitle = homePage.getHomeTitle();
		Assert.assertEquals(homeTitle, "Cogmento CRM", "Home Page Title not match");
	}
	
	
	@Test(priority = 2)
	public void verifyHomePageLogoTest() {
		Assert.assertTrue(homePage.verifyHomePageLogo());
	}
	
	@Test(priority = 3)
	public void verifyUserNameLabelTest() {
		Assert.assertTrue(homePage.verifyUserNameLabel());
	}
	
	@Test(priority = 4)
	public void verifyContactLinkPage() {
		contactPage = homePage.clickOnContactPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
