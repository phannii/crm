package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.testbase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends testbase {
  
	//page factory-OR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(linkText="Signup")
	WebElement SignUp;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement Logo;
	
	
	//Initializing the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateloginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean CrmLogovalidation()
	{
		return Logo.isDisplayed();
		
	}
	
	public HomePage login(String un, String pw)
	{
username.sendKeys(un);
password.sendKeys(pw);
//loginbtn.click();
TestUtil.clickonelement(driver,loginbtn);
return new HomePage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
