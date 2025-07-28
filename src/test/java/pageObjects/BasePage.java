package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		//driver=new ChromeDriver();
		PageFactory.initElements(driver, this);
	}
	

}
