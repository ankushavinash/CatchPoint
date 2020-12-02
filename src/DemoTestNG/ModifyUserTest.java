package DemoTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ModifyUserTest{
	@Test
	public void modiftUser()
	{
		String actual="hello";
		String exp="hello";
		SoftAssert s=new SoftAssert();
		s.assertEquals(actual, exp);
		s.assertAll();
		System.out.println("pass");
		
		Assert.assertEquals(actual, exp);
		System.out.println("validate");
	}
}
