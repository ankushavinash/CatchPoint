package PracticeTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CatchPointProg 
{
	public static void main(String[] args)
	{
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.get("file:///C:/Users/Ishan%20Ratnaparkhi/Desktop/lockdown/ForPracticeWebTable.html");
		  driver.manage().window().maximize();
		  
		  //fetch slaray from table
		  List<WebElement> loS=driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
		  //add salary to array list
			ArrayList al=new ArrayList();
			for(int i=1;i<loS.size();i++)
			{
			   al.add(loS.get(i).getText());
			}
			//sort array
			Collections.sort(al);
			//reverse array
			Collections.reverse(al);
			//find max salary
			Object obj=Collections.max(al);
			System.out.println("print the max sal"+obj);
			
			//print array
			System.out.println(al);
			System.out.println("===================");
			System.out.println("highest salary of employees");
			//getting 5 highest salary
			for(int i=0;i<5;i++)
			{
				System.out.println(al.get(i));
			}
			System.out.println("===================");
			System.out.println("Name of the person who which getting higest salary");
       for(int i=0;i<5;i++)
       {
    	    String sal = al.get(i).toString();
    	    WebElement listOfName=driver.findElement(By.xpath("//td[text()='"+sal+"']/preceding-sibling::td[1]"));
    	    String name=listOfName.getText();
    	    System.out.println(name);
       }
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
}
}
