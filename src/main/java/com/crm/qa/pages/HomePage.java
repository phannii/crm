package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.testbase;

public class HomePage extends testbase{

	@FindBy(xpath = "//td[contains(text(),'User: phani reddy')]")
	
	WebElement userNameLabel;
	
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	@CacheLookup//to improve the performance of the script
	WebElement contactslink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslink;
	
	//Initializing the page objects
	 public HomePage() {
		 PageFactory.initElements(driver, this);
	 }
	
	public String verifyHomepagetitle()
	{
		return driver.getTitle();
	}
	
	
	public boolean verifyusername()
	{
		return userNameLabel.isDisplayed();
	}
	
	
	public ContactsPage clickOnContacts()
	{
		contactslink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDeals()
	{
		dealslink.click();
		return new DealsPage();
	}
	
	
	public Taskspage clickOnTasks()
	{
		taskslink.click();
		return new Taskspage();
	}
	public void clickonnewcontactlink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactslink).build().perform();
	    newContactLink.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
