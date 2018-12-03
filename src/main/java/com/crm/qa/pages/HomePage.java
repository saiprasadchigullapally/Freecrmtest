package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Define PageFactory or Object Repository OR
	
	@FindBy(xpath="//td[contains(text(),'User: SaiPrasad Chigullapally')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//*[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[contains(text(),'New Contact')]")
	WebElement newcontactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//To intiallize WebElement/PageObject  we  need to create constructor
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Functionalities of homepage
	
	
	
	
	public String verifyHomePageTitle() {
		
		return driver.getTitle();
	}
	
	
   public boolean verifyCorrectUserName() {
		
	return userNameLabel.isDisplayed();
	}
	

	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
		
	}

	
	public DealsPage clickOnDealsLink() {
		
		return new DealsPage();
	}
	
	
	public TaskPage clickOnTaskLink() {
		
		return new TaskPage();
	}
	
	
	public void clickOnNewContactLink() {
		
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newcontactLink.click();
	}
	
}
