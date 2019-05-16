package com.qa.hubspot.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePageClass;

public class ContactsPage  extends BasePageClass{
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='Create contact']")
	WebElement createcontactbfr;
	
	@FindBy(xpath="//li//span[text() ='Create contact']")
	WebElement createcontactaftr;
	
	
	@FindBy(id="uid-ctrl-1")
	WebElement mail;
	
	
	@FindBy(id="uid-ctrl-2")
	WebElement FirstName;
	
	
	@FindBy(id="uid-ctrl-3")
	WebElement LastName;
	
	
	@FindBy(id="uid-ctrl-5")
	WebElement JobTtitle;
	
	
	
	
	public ContactsPage(WebDriver driver){      //constr'
		this.driver=driver;
		PageFactory.initElements(driver, this);         // pagefactory is a class of Se
	
	}

	// define methods
	public void createNewContact(String email,String firstname,String lastname,String jobtitle){
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		wait.until(ExpectedConditions.elementToBeClickable(createcontactbfr));
		createcontactbfr.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(mail));
		mail.sendKeys(email);
		
		wait.until(ExpectedConditions.elementToBeClickable(FirstName));
		FirstName.sendKeys(firstname);
		
		wait.until(ExpectedConditions.elementToBeClickable(LastName));
		LastName.sendKeys(lastname);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(JobTtitle));
		JobTtitle.sendKeys(jobtitle);
		
		wait.until(ExpectedConditions.elementToBeClickable(createcontactaftr));
		createcontactaftr.click();
		
		
		
	}
	

	
	
	

}
