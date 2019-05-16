package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePageClass;
import com.qa.hubspot.pages.LoginPage;

public class LoginTest {
	LoginPage loginPage;
	 WebDriver driver;   // make declarations global so that every mtd can use it
	 BasePageClass basePage;
	 Properties prop;
	
	@BeforeMethod
	public void setUp() throws InterruptedException  {
		 basePage=new BasePageClass();  // create the refr' for object of base page class to call its mtds (non static) by obj.refr'
	    
	     prop= basePage.initialize_properties();// first properties call;
	     
	     driver	=basePage.initialize_driver(prop);// second driver call and give "prop"only to cross browser
	     
	     driver.get(prop.getProperty("url"));   // to open url
	     Thread.sleep(6000);                        // we've to use medium wait in future ; not yet studied
	     loginPage=new LoginPage(driver);  // create obj.,refr. to call those mtds by obj.refr.,
		
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitle(){
		String title =loginPage.getLoginPageTitle();
		System.out.println("login Page Title is: "+ title);
		Assert.assertEquals(title, "HubSpot Login");   // later change this hard code value
	}
	
	@Test(priority=2)
	public void verifySignUpLinkTest(){
		boolean yes =loginPage.verifySignUpLink();
		System.out.println("sign up lik is displayed or not" +yes);
		Assert.assertTrue(yes, "signup link is not visible");
	
	}
	@Test(priority=3)
	public void verifySignUpLink() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod                      // should be written for executing the test case successfully
	public void teaDown(){
		driver.quit();                 // otherwise, null ptr exception
	}
	
	
	
	
}
