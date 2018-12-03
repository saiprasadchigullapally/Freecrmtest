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
import com.crm.qa.util.WebEventListener;

public class ContactsPageTest extends TestBase {
	
	//To invoke the parent class (TestBase) constructor
	public ContactsPageTest() {
		super();
	}
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetname="contacts";
	
	@BeforeMethod
	 public void setUp() throws InterruptedException {
		 
		 intialization();
		 testutil=new TestUtil();
		 loginpage=new LoginPage();
		 homepage= loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		contactspage=new ContactsPage();
		testutil.switchToFrame();
		contactspage=homepage.clickOnContactsLink();
	
		 }
	
	
	
@Test(priority=1)
public void verifyContactsPageLabel() {
	
	Assert.assertTrue(contactspage.verifyContactsLabel()," Contacts label is missing on the page");
}


@Test(priority=2)
public void selectSingleContactsTest() {
	
   contactspage.selectContactsByName("chigullapally Sreenivasulu");
}

@Test(priority=3)
public void selectMultipleContactsTest() {
	
   contactspage.selectContactsByName("chigullapally Sreenivasulu");
   contactspage.selectContactsByName("Gubba Padma");
   
   
}

@DataProvider
public Object[][] getCrmTestData() {
	Object data[][]=TestUtil.getTestData("contact");
	return data;
	
}


@Test(priority=4,dataProvider="getCrmTestData")
public void validateCreateNewContact(String title,String firstName,String lastName,String company) {
	
	homepage.clickOnNewContactLink();;
	//contactspage.createNewContact("Mr.", "sai", "chigullapally", "Google");
	contactspage.createNewContact(title, firstName, lastName, company);
	
	
	
}

	
	
	
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
	 
	

}
