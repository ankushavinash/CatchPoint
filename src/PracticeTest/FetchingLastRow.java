package PracticeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingLastRow {

	public static void main(String[] args) 
	{
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.get("file:///C:/Users/Ishan%20Ratnaparkhi/Desktop/lockdown/ForPracticeWebTable.html");
		  driver.manage().window().maximize();
		  
		  //last row last element
		  WebElement loS=driver.findElement(By.xpath("//table/tbody/tr[last()]/td[last()]"));
		  System.out.println(loS.getText());
		  //last row
		  WebElement loS2=driver.findElement(By.xpath("//table/tbody/tr[last()]"));
		 System.out.println(loS2.getText());
		 
		 //no of rows present in table
		 List<WebElement> listOfSalary=driver.findElements(By.xpath("//table/tbody/tr"));
		 
		 System.out.println(listOfSalary.size());
		 
		 
			ArrayList al=new ArrayList();
			for(int i=0;i<listOfSalary.size();i++)
			{
				al.add(listOfSalary.get(i).getText());
			}
			System.out.println("no of row : "+ (al.size()-1));
	      //
		  driver.close();
	}

}
