package com.vtiger.testscript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseClassForVtiger;
import com.vtiger.genericlibrary.DataStorage;
@Listeners(com.vtiger.genericlibrary.ListenersImplementationClass.class)
public class CreateNewLeadTest extends BaseClassForVtiger{
	@Test
		public void createLead() throws Exception {
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.cssSelector("[title='Create Lead...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(picker.getDataFromExcel("TestCaseData", 1, 2));
		driver.findElement(By.name("company")).sendKeys(picker.getDataFromExcel("TestCaseData", 2, 2));
		driver.findElement(By.cssSelector("input[value='  Save  ']")).click();
		
		String actualResult = driver.findElement(By.cssSelector("span[class='dvHeaderText']")).getText();
		System.out.println(actualResult);
		
		String result = actualResult.contains(picker.getDataFromExcel("TestCaseData", 3, 2)) ? "Test pass" : "Test fail";
		System.out.println(result);
	
	}
	
		
}
