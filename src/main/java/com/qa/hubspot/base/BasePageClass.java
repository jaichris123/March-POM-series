package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePageClass {
	WebDriver driver;
	Properties prop;
	
	
	public WebDriver initialize_driver(Properties prop){ // initialize the driver; use underscore_
		// for cross browser testing
		String browsername =prop.getProperty("browser");  //first get the name of browser and check it
		
		if(browsername.equals("Chrome")){   // always copy paste from properties file,if any typo, then error
			System.setProperty("webdriver.chrome.driver", "/Users/vivinna/Downloads/chromedriver");//launch chrome
			driver = new ChromeDriver();     
		}
		else if(browsername.equals("firefox")){
				
			System.setProperty("webdriver.gecko.driver", "/Users/vivinna/Downloads/geckodriver");//launch FF
			driver = new FirefoxDriver(); 
		}
		else{
			System.out.println("Browser not defined in the properties file");
	}
		
		//System.setProperty("webdriver.chrome.driver", "/Users/vivinna/Downloads/chromedriver");//launch chrome
		//driver = new ChromeDriver(); 
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit. SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		return driver;
		
	}
	
	public Properties initialize_properties(){
		prop= new Properties();
		try {
			FileInputStream ip=new FileInputStream("/Users/vivinna/Documents/JavTraining/MarchPOMSeries"
					+ "/src/main/java/com/qa/hubspot/configuration/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
		
	}

}
