package PracticeTest;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice2 {

	public static void main(String[] args) 
	{
		String a="prachi";
		String b="chourasia";
		a=a+b;
		b=a.substring(0,a.length()-b.length());
		a=a.substring(b.length());
		System.out.println(a+"  "+b);
		
		String temp;
		String[] array= {"p","e","f","t"};
		int middle=array.length/2;
		int j=array.length-1;
		for(int i=0;i<middle;i++)
		{
			temp=array[i];
			array[i]=array[j];
			array[j]=temp;
			j--;
		}
		System.out.println(Arrays.toString(array));

	}

}
