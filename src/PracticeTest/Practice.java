package PracticeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Practice implements ITestListener {
	@Test
	public void screenShotpractice() throws IOException
	{	
		Date d1=new Date();
		String currDate=d1.toString().replace(":", "-");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/campaign/landing.php?campaign_id=1653993517&extra_1=s%7Cc%7C318504235901%7Ce%7Cfacebook%20%27%7C&placement=&creative=318504235901&keyword=facebook%20%27&partner_id=googlesem&extra_2=campaignid%3D1653993517%26adgroupid%3D63066387003%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-360705453827%26loc_physical_ms%3D9302961%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=Cj0KCQiAzZL-BRDnARIsAPCJs72hMnIvnAImWYlBHLdqOkkcNKhoQkuiRauHZrksBqphmR_L0elec2MaAvAAEALw_wcB");
		driver.manage().window().maximize();
		EventFiringWebDriver d=new EventFiringWebDriver(driver);
		File sourceFile=d.getScreenshotAs(OutputType.FILE);
		File destinationFile=new File("./prachishot"+currDate+".png");
		FileUtils.copyFile(sourceFile,destinationFile);
		System.out.println("pass");
	}
	@Test
	public void fetchDataFromFile() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Ishan Ratnaparkhi\\Desktop\\Data.txt");
		Properties pobj=new Properties();
		pobj.load(fis);
		String s=pobj.getProperty("username");
		System.out.println(s);
		
		FileInputStream f=new FileInputStream("D:\\Automation Files\\DDT\\TestScriptData.xlsx");
		Workbook book=WorkbookFactory.create(f);
		String s1=book.getSheet("TestCaseData").getRow(1).getCell(1).getStringCellValue();
		System.out.println(s1);
		
}
	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailure(ITestResult arg0) {
		
	}
	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}}

