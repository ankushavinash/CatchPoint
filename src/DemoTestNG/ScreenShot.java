package DemoTestNG;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class ScreenShot {
	@Test
	public void screenshotdemo() throws Exception
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().window().maximize();
		
		//screenshot capturing
		EventFiringWebDriver efwd =new EventFiringWebDriver(driver);
		
		File sourceFile=efwd.getScreenshotAs(OutputType.FILE);
		File destiFile=new File("./ScreenShot/loginScreenShot.png");
		
		FileUtils.copyFile(sourceFile,destiFile);
		driver.close();
	}

}
