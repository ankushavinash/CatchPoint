package com.vtiger.objectRepository;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageMembers {
	
	@FindBy(name="user_name")
	private WebElement username_tf;
	
	@FindBy(name="user_password")
	private WebElement password_tf;
	
	@FindBy(id="submitButton")
	private WebElement login_Btn;
	
	@FindBy(xpath="/div[contains(text(),'You must specify')]")
	private WebElement error_msg;
	
	
	public WebElement getUsernameField()
	{
		return username_tf;
	}
	public WebElement getPasswordField()
	{
		return password_tf;		
	}
	public WebElement getLoginBtn()
	{
		return login_Btn;
	}
	public void loginToApp(String username, String password)
	{
		username_tf.sendKeys(username);
		password_tf.sendKeys(password);
		login_Btn.click();
	}
}














/*public LoginPageMembers(WebDriver driver)
{
	username_tf = driver.findElement(By.name("user_name"));
	password_tf = driver.findElement(By.name("user_password"));
	login_Btn = driver.findElement(By.id("submitButton"));
	error_msg=driver.findElement(By.xpath("/div[contains(text(),'You must specify')]"));
}*/

