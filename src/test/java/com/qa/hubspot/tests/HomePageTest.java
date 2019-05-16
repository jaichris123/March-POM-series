package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePageClass;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class HomePageTest {
	
	LoginPage loginPage;
	 WebDriver driver;   // make declarations global so that every mtd can use it
	 BasePageClass basePage;
	 Properties prop;
	 HomePage homepage;  // HP class(obj) refr' declarntn.,
	
	// first we need to login to go to HP
	//@BM,@test,@AM should be written here
	
	@BeforeMethod
	
	public void setUp() throws InterruptedException  {
		basePage=new BasePageClass();  
		prop= basePage.initialize_properties();
		     
		driver	=basePage.initialize_driver(prop);
		     
	    driver.get(prop.getProperty("url"));  
		Thread.sleep(6000);                        
		loginPage=new LoginPage(driver); 
		homepage =loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));  // first login
		// since do login mtd returns the obj., we need to store it in a ref' so we declare it before	
		Thread.sleep(6000);  
	}
	
	@Test
	public void verifyHomePageTitle(){
		String title=homepage.getHomePageTitle();
		System.out.println("Title of Home Page is :" +title);
		Assert.assertEquals(title, "Reports dashboard");
		
	}
	
	@Test
	public void verifyHomePageHeader(){
		String header=homepage.getHomePageHeader();
		System.out.println("Header of Home Page is :" +header);
		Assert.assertEquals(header, "Sales Dashboard");
	}
	@Test
	public void verifyAccountName(){
		String accountname=homepage.getAccountname();
		System.out.println("Accnt name after log in  Home Page is :" +accountname);
		Assert.assertEquals(accountname,"NaveenAutomationLabs");// copy paste otherwise typo error
	}
	
	@Test
	public void verifySubHeadername(){
		String subheader=homepage.getSubHeader();
		System.out.println("Subheader of Home Page is :" +subheader);
		Assert.assertEquals(subheader,"Sales Performance");
		
	}
	
	
	
		
	@AfterMethod                      // should be written for executing the test case successfully
	public void teaDown(){
		driver.quit();                 // otherwise, null ptr exception
	}
		
		
		
		
		
	
	
	
	
	

}
