package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	WebDriver driver;
	
	//constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locator
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_FirstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_LastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_Email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_Telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_Password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_Confirm_Passowrd;
	@FindBy(xpath="//input[@value='0']") WebElement radio_btn_Subscribe;
	@FindBy(xpath="//input[@name='agree']") WebElement chkbox_Privacy_Policy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btn_Continue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement conf_msg;
	
	
	//Action Mehods
	
	public void setFirstName(String firstName)
	{
		txt_FirstName.sendKeys(firstName);	
	}
	
	public void setLastName(String lastName)
	{
		txt_LastName.sendKeys(lastName);	
	}
	public void setEmail(String email)
	{
		txt_Email.sendKeys(email);	
	}
	public void setTelephone(String telephone)
	{
		txt_Telephone.sendKeys(telephone);	
	}
	public void setPassword(String password)
	{
		txt_Password.sendKeys(password);	
	}
	public void setConfirmPassword(String confirmPassword)
	{
		txt_Confirm_Passowrd.sendKeys(confirmPassword);	
	}
	
	public void setSubscribe()
	{
		radio_btn_Subscribe.click();
	}
	public void checkPrivacyPolicy()
	{
		chkbox_Privacy_Policy.click();	
	}
	public void clickContinue()
	{
		btn_Continue.click();
	}
	
	public String getConfirmationMesaage()
	{
		try{
			return (conf_msg.getText());
		}catch(Exception e)
		{
			return (e.getMessage());
		
		}
	}
	

}
