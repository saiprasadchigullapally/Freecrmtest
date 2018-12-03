package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;  //Global Variable
    public static Properties prop;	  //Global Variable
     public static EventFiringWebDriver e_driver;
     public static WebEventListener eventlistner;
    
    
    
	public TestBase(){
		try {
		prop=new Properties();
		FileInputStream ip=new FileInputStream("E:\\myselenium\\freeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties ");
		prop.load(ip);
				
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void intialization() {//purpose of intialization method
		
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","E:\\Selenium softwares\\chromedriver.exe");
		     driver=new ChromeDriver();
		}
		
		else if( browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\SAI\\Desktop\\mindq practice\\webdriverbrowsers\\geckodriver.exe");
   		    driver=new FirefoxDriver();
		}
		
		
		 e_driver=new EventFiringWebDriver(driver);
		 
		 // Now create object of EvientlistnerHandler to register it with EventFiringWebDriver
		 
	      eventlistner=new WebEventListener();
		  e_driver.register(eventlistner);
		  driver=e_driver;
		  
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
}
