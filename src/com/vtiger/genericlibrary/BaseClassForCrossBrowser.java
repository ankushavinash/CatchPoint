package com.vtiger.genericlibrary;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClassForCrossBrowser 
{
	
		public  WebDriver driver ;
		public  DataStorage picker = new DataStorage();
		
		
		@BeforeSuite
		public void configBS()
		{
		System.out.println("DB connected");
		}
		@BeforeTest
		public void configBT()
		{
			System.out.println("Before test dependency");
		}
		@BeforeClass
		@Parameters("browserValue")
		public void configBC(String browserValue) throws IOException
		{
			if (browserValue.equals("chrome"))
			{
				driver = new ChromeDriver();
			}

			else if (browserValue.equals("firefox"))
			{
				driver = new FirefoxDriver();
			}
			
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get(picker.getDataFromProperty("url"));
			driver.manage().window().maximize();
			System.out.println("browser launched");
			
		}
		@BeforeMethod
		public void configBM() throws IOException
		{
			driver.findElement(By.name("user_name")).sendKeys(picker.getDataFromProperty("username"));
			driver.findElement(By.name("user_password")).sendKeys(picker.getDataFromProperty("password"));
			driver.findElement(By.id("submitButton")).click();
			System.out.println("login done");
		}
		@AfterMethod
		public void configAM()
		{	
			 WebElement icon=driver.findElement(By.xpath("(//td[@class='small'])[4]"));
			 Actions act=new Actions(driver);
			 act.moveToElement(icon).perform();
			 driver.findElement(By.linkText("CRM Settings")).click();
			 System.out.println("logout");
		}
		@AfterClass
		public void configAC()
		{	
			driver.quit();
			System.out.println("close browser");
		}
		@AfterTest
		public void configAT()
		{
			System.out.println("after testcase dependency");
		}
		@AfterSuite
		public void configAS()
		{
			System.out.println("disconnect DB");
		}	
	}


