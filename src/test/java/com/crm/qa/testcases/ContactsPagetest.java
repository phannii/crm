package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.crm.qa.base.testbase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

class ContactsPagetest extends testbase{
	
	LoginPage loginpage;
	ContactsPage contactpage;
	HomePage homepage;
	TestUtil testutil;
	
	String sheetName="contacts";

	public ContactsPagetest()
	{
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();
		contactpage = new ContactsPage();
		homepage = new HomePage();
		testutil=new TestUtil();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchtoframe();
		contactpage =homepage.clickOnContacts();
		
	}
	
	@Test
	public void verifycontactspagelabel()
	{
		Assert.assertTrue(contactpage.contactslabel());
     
     
 	}
	@Test(priority=1)
	public void SelectContactstest()
	{
		contactpage.selectContactsByName("pjr reddy");
	}
	@DataProvider
	public Object[][] getcrmtestdata()
	{
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
	}
	
	@Test(dataProvider="getcrmtestdata")
	public void validatecreatenewcontact(String title,String firstname, String lastname,String company)
	{
		homepage.clickonnewcontactlink();
		//contactpage.createNewContact("Mr.", "Tom", "peter", "virtusa");
contactpage.createNewContact(title, firstname, lastname, company );	

	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}

	
	
}
