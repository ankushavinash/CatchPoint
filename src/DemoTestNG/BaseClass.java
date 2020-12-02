package DemoTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

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
	public void configBC()
	{
		System.out.println("Launch browser");
	}
	@BeforeMethod
	public void configBM()
	{
		System.out.println("login done");
	}
	@AfterMethod
	public void configAM()
	{
		System.out.println("logout");
	}
	@AfterClass
	public void configAC()
	{
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
