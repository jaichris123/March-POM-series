package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePageClass;

public class LoginPage extends BasePageClass {
	
	WebDriver driver;
	
	
	@FindBy(id="username" )                   // for every page, acc., to POM,
	WebElement emailId;                      // 1.a) define the page objects by using page factory or By locators
	                                         // similar to driver.findElement
	
	@FindBy(id="password" )
	WebElement password;
	
	
	@FindBy(id="loginBtn" )
	WebElement loginButton;
	

	@FindBy(linkText="Sign up" )
	WebElement signuplink;
	
	//1)b) create  Constructor with parameter
	
	public LoginPage(WebDriver driver){     
		this.driver=driver;
		PageFactory.initElements(driver, this);         // pagefactory is a class of Se
	
	}
	
//2.  define the methods/actions              // get title,signup and login 
	public String getLoginPageTitle(){       // to get the login page title
		String title=driver.getTitle();    // return driver.getTitle(); can also be written
		return title;
	}
	public Boolean verifySignUpLink(){
		Boolean yes =signuplink.isDisplayed();         // element is there;just check whther it's displayed/not
		return yes;
		
	}
			
	public HomePage doLogin(String UN,String PWD){
		                                                  // do the login action
		emailId.sendKeys(UN);
		password.sendKeys(PWD);
		loginButton.click();
		//HomePage homepage=new HomePage();    // returning the HP class obj.,
		return new HomePage(driver);   // cross browser testing alone; no need driver
		// after while moving to Hp, we need it ,since we created the consrt' there in HP
		
		
	}
			
	
	
	
	
	
	

}
