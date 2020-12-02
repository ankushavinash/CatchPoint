package com.vtiger.genericlibrary;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.vtiger.objectRepository.LoginPageMembers;

public class BaseClassForVtiger 
{		
	public  static WebDriver driver ;
	public  DataStorage picker = new DataStorage();
	public SoftAssert soft=new SoftAssert();
	
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
	public void configBC() throws IOException
	{	
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(picker.getDataFromProperty("url"));
		driver.manage().window().maximize();
		System.out.println("browser launched");
		
	}
	@BeforeMethod
	public void configBM() throws IOException
	{
		LoginPageMembers login =PageFactory.initElements(driver, LoginPageMembers.class);
		login.loginToApp(picker.getDataFromProperty("username"),picker.getDataFromProperty("password"));
		System.out.println("login done");
		
	}	
		
		
		
		/*LoginPageMembers login = new LoginPageMembers(driver);
		login.loginToApp(picker.getDataFromProperty("username"), picker.getDataFromProperty("password"));
		login.getUsernameField().sendKeys(picker.getDataFromProperty("username"));
		login.getPasswordField().sendKeys(picker.getDataFromProperty("password"));
		login.getLoginBtn().click();
		System.out.println("Login done");		
		driver.findElement(By.name("user_name")).sendKeys(picker.getDataFromProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(picker.getDataFromProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		System.out.println("login done");*/
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
	/*@BeforeMethod
	public void configBM() throws IOException
	{
		LoginPageMembers login = new LoginPageMembers(driver);
		login.loginToApp(picker.getDataFromProperty("username"), picker.getDataFromProperty("password"));
		login.getUsernameField().sendKeys(picker.getDataFromProperty("username"));
		login.getPasswordField().sendKeys(picker.getDataFromProperty("password"));
		login.getLoginBtn().click();
		System.out.println("Login done");
	}	
	*/
	
	
	
	
	
	
	
	
	
	
}
