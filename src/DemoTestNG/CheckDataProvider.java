package DemoTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckDataProvider 
{	
	@Test(dataProvider="datasupplyer")
	public void loginToApp(String username,String passward)
	{
		System.out.println("user name is : "+"admin");
		System.out.println("passward is : "+"manager");
	}
	@DataProvider
	public Object[][] dataSupplyer()
	{	
		Object[][] data=new Object[5][2];
		for(int i=1;i<=data.length;i++)
		{	
			int num=i+1;
			data[i][0]=getDataFromExcel("CredentialSheet",num,0);
			data[i][1]=getDataFromExcel("CredentialSheet",num,1);
		}
		return data;
	}
	public String getDataFromExcel(String string, int i, int j) 
	{
		
		return string;
	}
}
