package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePageClass;
import com.qa.hubspot.contact.ContactsPage;

public class HomePage extends  BasePageClass {
	WebDriver driver;
	
	//h1[@class='private-page__title']  // for sales dashboard header of HP on leftside
	@FindBy(xpath="//h1[@class='private-page__title']")
	WebElement homepageheader;   // similar to driver.findelement
	
	
	@FindBy(xpath="//span[@class='account-name ']")//copy& paste otherwise typofor accnt name naveenautomation on right side
	WebElement homepageaccountname;
	
	@FindBy(xpath="//*[text()='Sales Performance']")
	WebElement  subheader1;
	
	@FindBy(id="nav-primary-contacts-branch")
	WebElement contactsmainmenu;
	
	@FindBy(id="nav-secondary-contacts")
	WebElement contactsubmenu;
	
	// constr' of HP
	
	public HomePage(WebDriver driver){   
		this.driver=driver;
		PageFactory.initElements(driver, this);         // pagefactory is a class of Se
	
	}
	
// define methods
	public String getHomePageTitle(){   // page title is on the top of page reports dashboard
		 return driver.getTitle();
	}
	 public String getHomePageHeader(){
		  return homepageheader.getText();   // returns string value
		 
	 }
	 
	 public String getAccountname(){
		 return homepageaccountname.getText();
		 
	 }
	
	public String getSubHeader(){
		return subheader1.getText();
	}
	
	public ContactsPage gotoContactsPage() throws InterruptedException{
		contactsmainmenu.click();
		Thread.sleep(6000);
		contactsubmenu.click();
		Thread.sleep(6000);//for error check
		
		return new ContactsPage(driver);
		
		
	}
	
	
}
