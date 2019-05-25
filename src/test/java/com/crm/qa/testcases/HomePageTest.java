package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.testbase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends testbase {

	LoginPage loginpage;
	 HomePage homepage;
	 TestUtil testutil;
	 ContactsPage contactspage;
public HomePageTest()
{
	super();
	
}

@BeforeMethod
public void Setup()
{
	initialization(); 
	loginpage = new LoginPage();
    testutil = new TestUtil();
    contactspage=new ContactsPage();
homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
}

@Test(priority=1)
public void verifyhomepagetitletest()
{
	String homepagetitle=homepage.verifyHomepagetitle();
	Assert.assertEquals(homepagetitle, "CRMPRO","homepage title not matched");
	
}

@Test(priority=2)
public void verifyusernametest()
{
	testutil.switchtoframe();
	boolean user = homepage.verifyusername();
	Assert.assertTrue(user);
}      
@Test
public void VerifyContactslist()
{
	testutil.switchtoframe();
	contactspage = homepage.clickOnContacts();
}

@AfterMethod
public void TearDown()
{
	driver.quit();
}






}
