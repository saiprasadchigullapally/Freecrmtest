package com.crm.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener{

	
	/**********************************Purpose of the webdrivereventlistener******************************************/
	
	@Override//1
	public void beforeNavigateTo(String url, WebDriver arg1) {
		System.out.println("Before navigating to:'" +url+ "'");
		
	}
	
	@Override//2
	public void afterNavigateTo(String url, WebDriver arg1) {
	System.out.println("Navigated to: '" +url+ "'");
		
	}
	
	
	
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		
		System.out.println("Before change value of the element:"+element.toString());
	
		
	}
	
    public void afterChangeValueOf(WebElement element, WebDriver driver) {
	
    	System.out.println("After change value of the element:"+element.toString());
    	
	}
	
	@Override//3
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		
		
	}
	
	@Override//4
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		
		
	}
	
	
	@Override//5
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on"+element.toString());
		
	}
	
	
	@Override//6
	public void afterClickOn(WebElement element, WebDriver driver) {
		
		System.out.println("Clicked on"+element.toString());
	}
	
	
	@Override//7
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
		
		
	}
	
	
	@Override//8
	public void afterNavigateBack(WebDriver arg0) {
		
		System.out.println("Navigated back to previous page");
	}
	
	
	@Override//9
	public void beforeNavigateForward(WebDriver arg0) {
		
		System.out.println(" Navigated forward to next page");
	}
	
	@Override//10
	public void afterNavigateForward(WebDriver arg0) {
		
		System.out.println("Navigated forward to next page");
	}
	
	@Override//11
	public void onException(Throwable error, WebDriver driver) {
		
		System.out.println("Exception occured:"+error);
	}	
	
	
	@Override//12
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find element By:"+by.toString());
		
		
	}
	
	@Override//13
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element by:"+by.toString());
		
	}

	@Override//14
	public void beforeScript(String arg0, WebDriver arg1) {
		
		
	}
	
	@Override//15
	public void afterScript(String arg0, WebDriver arg1) {
		
		
	}
	
	@Override//16
	public void beforeAlertAccept(WebDriver arg0) {
		
		
	}
	
	@Override//17
	public void afterAlertAccept(WebDriver arg0) {
		
		
	}
	
	@Override//18
	public void afterAlertDismiss(WebDriver arg0) {
	
		
	}
	
	
	
	@Override//19
	public void beforeNavigateRefresh(WebDriver arg0) {
	
		
	}
	
	
	
	
	
	
	
	@Override//20
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		
		
	}

	@Override//21
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
				
	}
	

	@Override//22
	public void afterNavigateRefresh(WebDriver arg0) {
				
	}

	

	

	@Override//23
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		
		
	}

	

	@Override//24
	public void beforeAlertDismiss(WebDriver arg0) {
		
		
	}	

	
	

	@Override//25
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		
		
	}

	@Override//26
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		
		
	}

	@Override//27
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	


	
	
	

}
