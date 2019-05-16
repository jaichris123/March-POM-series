package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePageClass;
import com.qa.hubspot.contact.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.ExcelUtil;

public class ContactsPageTest {
	
	LoginPage loginPage;
	 WebDriver driver;   // make declarations global so that every mtd can use it
	 BasePageClass basePage;
	 Properties prop;
	 HomePage homepage;  // HP class(obj) refr' declarntn.,
	 ContactsPage contactspage;  // ContactsPage refr' 
	
	// first we need to login to go to HP
	//@BM,@test,@AM should be written here
	
	@BeforeMethod
	
	public void setUp() throws InterruptedException  {
		basePage=new BasePageClass();  
		prop= basePage.initialize_properties();
		     
		driver	=basePage.initialize_driver(prop);
		     
	    driver.get(prop.getProperty("url"));  
		Thread.sleep(8000);                        
		loginPage=new LoginPage(driver); 
		homepage =loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));  // first login
		// since do login mtd returns the obj., we need to store it in a ref' so we declare it before	
		Thread.sleep(8000); // since error came:  confign.,not found., BM set up
		
		contactspage =homepage.gotoContactsPage();   //contactspage is a refr' so that we call all its mtds
	
		
	}
	
	@DataProvider(name="getContactsData")    // to provide the data for test cases:DataProvider
	public Object[][] getContactsData(){
		Object contactsData[][]=ExcelUtil.getTestData("contacts");
		return contactsData;
	}
	
	
	
	
	
	@Test(dataProvider="getContactsData")   // to provide the data for test cases:DataProvider
	public void createContactsTest(String email,String firstname, String lastname,String jobtitle){
//contactspage.createNewContact("vivi@gmail.com", "Vivinna", "Chris", "QA manager");// first time run without ecel
		contactspage.createNewContact(email,firstname,lastname,jobtitle); // skipped test
	}
	
	
	@AfterMethod                      // should be written for executing the test case successfully
	public void teaDown(){
		driver.quit();                 // otherwise, null ptr exception
	}
		
	
	
	
	
	
	
	

}
