package com.vtiger.testscript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.genericlibrary.BaseClassForVtiger;
import com.vtiger.genericlibrary.DataStorage;
@Listeners(com.vtiger.genericlibrary.ListenersImplementationClass.class)
public class CreateContactTest extends BaseClassForVtiger
{
	
	@Test
	public  void createContact() throws Exception 
	{
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.cssSelector("[title='Create Contact...']")).click();
		//here soft assert to validate contact page displaying or not
		String title=driver.getTitle();
		String expactedTitle=picker.getDataFromExcel("TestCaseData", 8,2 );
		soft.assertTrue(title.contains(expactedTitle));
		
		
		
		driver.findElement(By.name("lastname")).sendKeys(picker.getDataFromExcel("TestCaseData", 1, 2));
		//driver.findElement(By.name("company")).sendKeys(picker.getDataFromExcel("TestCaseData", 2, 2));
		driver.findElement(By.cssSelector("input[value='  Save  ']")).click();
		
		String actualResult = driver.findElement(By.cssSelector("span[class='dvHeaderText']")).getText();
		//System.out.println(actualResult);
		
		String result = actualResult.contains(picker.getDataFromExcel("TestCaseData", 3, 2)) ? "Test pass" : "Test fail";
		System.out.println(result);
		
		Assert.assertTrue(actualResult.contains(picker.getDataFromExcel("TestCaseData", 8, 2)));
		
		soft.assertAll();

	}

}
