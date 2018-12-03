package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	//Define Page Factory or Object Repository (OR)
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
    WebElement password;	
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[text()='Sign Up'] ")
	WebElement signupBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	
	// To intilize the WebElemets/Page Objects we need to create constructor
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	// Functionalities of loginpage:
	
	
	public String validateLoginPageTitel(){
		
		
		return driver.getTitle();
		
	}
	
	
	public boolean validateCRMImage() {
		
		return crmLogo.isDisplayed();
			
	}
	
	public HomePage login(String un,String pwd) throws InterruptedException {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(2000);
		loginBtn.click();
		
		return new HomePage();
		
	}
	
	
	
	

}
