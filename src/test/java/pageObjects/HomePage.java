package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	WebDriver driver;
	
	//constructor
	
	public HomePage(WebDriver driver)
	{
		super(driver);		
		
	}
	
	//locator
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement Myaccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement Register;
	@FindBy(linkText="Login") WebElement LinkLogIn; //login link added to steps
	
	//Action Methods
	
	public void clickMyAccount() throws InterruptedException
	{   
		//Myaccount.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Myaccount);
	
	}
	
	public void clickRegister()
	{
		Register.click();
	}
	
	public void clickLogIn()
	{
		LinkLogIn.click();
	}
	
		
	
	
	

}
