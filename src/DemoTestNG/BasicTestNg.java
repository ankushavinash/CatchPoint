package DemoTestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class BasicTestNg 
{	
	@Test
	public void createUser()
	{
		//System.out.println("user created");
		Reporter.log("user created");
		
	}
	@Test
	public void modifyUser()
	{
		//System.out.println("user modified");
		Reporter.log("user created");
	}
	@Test(dependsOnMethods= {"createUser"})
			public void deleteUser()
	{
		//System.out.println("user deleted");
		Reporter.log("user created");
	}
}
