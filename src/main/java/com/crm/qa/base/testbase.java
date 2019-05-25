package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class testbase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener eventListener;
	public  static EventFiringWebDriver e_driver;

	public testbase(){
		
		try {
			
			 prop =new Properties();
			 FileInputStream ip =new FileInputStream("C:\\code reprository\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa"
			 		+ "\\configuration\\config.properties");
	prop.load(ip);	
			
		} catch (FileNotFoundException e) {
		 
		e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
	}	
		
		
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\selenium drivers\\chromedriver_win32 (1)\\chromedriver.exe");
	driver = new ChromeDriver();
	}
	else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\mozilladriver\\geckodriver-v0.22.0-win64 (1)\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	e_driver = new EventFiringWebDriver(driver);
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver=e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait,TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	
	
	}
	
	
	
}
