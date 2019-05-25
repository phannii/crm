package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.testbase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends testbase {
public LoginPage loginpage;
public HomePage homepage;

	 public LoginPageTest() {
	super();//all the properties will be defined
	}
	
	
	
	
	@BeforeMethod
	public void Setup()
	{
		initialization(); 
		 loginpage = new LoginPage();
	}
	
//	@Test
//	public void validateloginpagetitle()
//	{
//		String title =loginpage.validateloginPageTitle();
//		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");;
//	}
	//test cases should be seperated--independent with each other
	//before each test case--launch the browseer and login
//@test-execute test case
	//after each test case close the browser
	@Test
	public void validateCrmLogo()
	{
		boolean logo =loginpage.CrmLogovalidation();
		Assert.assertTrue(logo);

		
	}
	
	@Test
	public void logintest()
	{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	
	
	
	
	
}
