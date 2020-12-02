package PracticeTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoforWebTable {

	public static void main(String[] args)
	
	{ 
		WebDriver driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get("file:///C:/Users/Ishan%20Ratnaparkhi/Desktop/lockdown/ForPracticeWebTable.html");
	    driver.manage().window().maximize();
		List<WebElement> listOfSalary=driver.findElements(By.xpath(""));
		ArrayList al=new ArrayList();
		for(int i=0;i<listOfSalary.size();i++)
		{
			al.add(listOfSalary.get(i).getText());
		}

		Collections.sort(al);
		Collections.reverse(al);
		System.out.println(al);

		for(int i=0;i<5;i++)
		{
		   System.out.println(al.get(i));
		}

		for(int i=0;i<5;i++)
		{
			String sal=al.get(i).toString();
			WebElement loN=driver.findElement(By.xpath(""));
			System.out.println(loN);
		}


		
	}

}
