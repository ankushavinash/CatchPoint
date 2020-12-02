package PracticeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingLastRow {

	public static void main(String[] args) {
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.get("file:///C:/Users/Ishan%20Ratnaparkhi/Desktop/lockdown/ForPracticeWebTable.html");
		  driver.manage().window().maximize();
		  
		  //fetch slaray from table
		  WebElement loS=driver.findElement(By.xpath("//table/tbody/tr[last()]/td[last()]"));
		/* // WebElement loS=driver.findElement(By.xpath("//table/tbody/tr[\"+lastRowcount+\"]"));
		 
	      System.out.println(loS.getText());
		  driver.close();*/
	}

}
