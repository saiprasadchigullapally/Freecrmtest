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
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	//To invoke the parent class (TestBase) constructor
	 public HomePageTest() {
		 super();
	 }

	 // Test cases should be independent with each other
	 
	 //Before each test case --Launch the browser and login
	 
	 //@test---Execute Test case
	 
	 //After execute the each test case --close the browser.
	 
	 @BeforeMethod
	 public void setUp() throws InterruptedException {
		 
		 intialization();
		 testutil=new TestUtil();
		 loginpage=new LoginPage();
		 contactspage=new ContactsPage();
		homepage= loginpage.login(prop.getProperty("username"),prop.getProperty("password"));	
	
		 }
	 
	 
	 @Test(priority=1)
	 public void verifyHomePageTitle() {
		 
		 String homepagetitle=homepage.verifyHomePageTitle();
		 Assert.assertEquals(homepagetitle, "CRMPRO","HomePage Title not matched");
	 }
	 
	 @Test(priority=2)
	 public void verifyUserNameTest() {
		 
		 testutil.switchToFrame();
		 Assert.assertTrue(homepage.verifyCorrectUserName());
	 }
	 
	 @Test(priority=3)
	 public void verifyContactLink() {
		 testutil.switchToFrame();
		 contactspage=homepage.clickOnContactsLink();
	 }
	 
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
	 
}
