package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
WebDriver driver;
	
	//constructor
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);		
		
	}
	
	//locators
	
	@FindBy(xpath="//h2[text()='My Account']") WebElement msgHeading;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logout;
	
	
	
	//ActionMethods
	
	public boolean isMyAccountPageExists()
	{
		try {
		return (msgHeading.isDisplayed());
			//return (driver.getCurrentUrl().contains("account") || driver.getTitle().contains("My Account"));
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public void clickLogout()
	{
		logout.click();
	}

}
