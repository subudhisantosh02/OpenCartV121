package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public  Logger logger;
	public Properties prop;

	@BeforeClass(groups= {"Sanity","Regresssion","Master"})
	@Parameters({"os","browser"})
	public void setup(@Optional("windows") String os,@Optional("chrome") String br) throws IOException {
		
		//loading config.properties file
		//u can use FileReader class
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\config.properties");
		prop=new Properties();
		prop.load(fis);
		
		
		logger=LogManager.getLogger(this.getClass());
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//here os and browser is coming from xml file
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) 
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux")) 
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("no matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome");break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
			case "firefox": capabilities.setBrowserName("firefox");break;
			default: System.out.println("No matching browser"); return;					
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver=new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver();break;
			default : System.out.println("Invalid Browser name"); return; 
			}
		}
		
			
		//driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(prop.getProperty("appURL"));//reading url from properties 
		driver.manage().window().maximize();
	}

	@AfterClass(groups= {"Sanity","Regresssion","Master",})
	public void tearDown() {
		driver.quit();
	}

	public String randomString() {
		String genetaredstring = RandomStringUtils.randomAlphabetic(5);
		return genetaredstring;
	}

	public String randomNumber() {
		String genetarednumber = RandomStringUtils.randomNumeric(10);
		return genetarednumber;
	}

	public String randomAlphaNumeric() {
		String genetaredalphanumeric = RandomStringUtils.randomAlphanumeric(8);
		return genetaredalphanumeric;
	}
	
	public String captureScreen(String tname) throws IOException {
	    String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File sourceFile = ts.getScreenshotAs(OutputType.FILE);

	    // Create screenshots folder if it doesn't exist
	    String folderPath = System.getProperty("user.dir") + "/screenshots/";
	    new File(folderPath).mkdirs();

	    // Full screenshot file path
	    String targetFilePath = folderPath + tname + "_" + timestamp + ".png";
	    File targetFile = new File(targetFilePath);

	    // Copy the screenshot file
	    org.apache.commons.io.FileUtils.copyFile(sourceFile, targetFile);

	    return targetFilePath;
	}
	

}
