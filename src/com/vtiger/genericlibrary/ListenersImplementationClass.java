package com.vtiger.genericlibrary;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementationClass implements ITestListener
{
	@Override
	public void onFinish(ITestContext arg0) {
		
	System.out.println(arg0.getName()+"Execution finish");	
	}

	@Override
	public void onStart(ITestContext arg0) {
	System.out.println(arg0.getName()+"Execution Start");	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println(arg0.getName()+"failed with some percentage");	
	
	}

	@Override
	public void onTestFailure(ITestResult arg0) 
	{
		Date d= new Date();
		String currentDate=d.toString().replace(":", "");
		String testCaseName=arg0.getName();
		System.out.println(testCaseName+"Test Case Fail");
		EventFiringWebDriver efwd=new EventFiringWebDriver(BaseClassForVtiger.driver);
		File sourceFile=efwd.getScreenshotAs(OutputType.FILE);
        File destiFile=new File("./ScreenShot/"+testCaseName+currentDate+".png");
		
		try 
		{
			FileUtils.copyFile(sourceFile,destiFile);
		} 
		catch (IOException e) 
		{}
		 
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0)
	{
		System.out.println(arg0.getName()+"Test case skipped");		
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println(arg0.getName()+"Test case start");		
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println(arg0.getName()+"test case success");			
	}
}
