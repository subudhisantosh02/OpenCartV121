package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {
	
WebDriver driver;
	
	//constructor
	
	public LogInPage(WebDriver driver)
	{
		super(driver);		
		
	}

	//locators
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_login_Email;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_login_password;
	@FindBy(xpath="//input[@value='Login']") WebElement btn_login;
	
	//Action Methods
	
	public void setLogInEmail(String login_Email)
	{
		txt_login_Email.sendKeys(login_Email);
	}
	
	public void setLogInPassdword(String login_password)
	{
		txt_login_password.sendKeys(login_password);
	}
	
	public void clickBtn_login()
	{
		btn_login.click();;
	}
	
	
}
