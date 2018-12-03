package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	
	//Define PageFactory or Object Repository
	
	@FindBy(xpath="//td[contains(text(), 'Contacts')]")
	WebElement contactsLable;
	
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@class='button' and @ value='Save']")
	WebElement savebtn;
	
	//To intilize WebElement or WebObjects we need to create constructor.
	
	
	
	public ContactsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	// Functionalities of Contacts Page
	
	public  boolean verifyContactsLabel() {
		
		return contactsLable.isDisplayed();
		
	}
	
	public void selectContactsByName(String name) {
		
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	
	public void createNewContact(String title,String ftname,String ltname,String comp) {
		
		Select s=new Select(driver.findElement(By.name("title")));
		s.selectByVisibleText(title);
		
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
	    company.sendKeys(comp);
		savebtn.click();
		
		
	}
	
	
	
}
