package baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import UtilityPackage.Utility;

public class Base {
	protected static WebDriver driver;
	public void LaunchBrowser(String Browsername) throws IOException
	{
		if(Browsername.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\manis\\OneDrive\\Desktop\\software testing.Raj\\Automation testing\\Selenium Tool\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notification");
		 driver =new ChromeDriver();
		}
		else if(Browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\manis\\OneDrive\\Desktop\\software testing.Raj\\Automation testing\\Selenium Tool\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.get(Utility.getdatafromproprtyfile("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		Reporter.log("Browser Lounching successful",true);
		
		
	}
	
	public  void GetScreenshot(String TCName) throws IOException
	{
		File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String path = System.getProperty("user.dir")+"\\Screenshot\\TC"+TCName+".png";
		File Dest=new File("C:\\Users\\manis\\OneDrive\\Desktop\\software testing.Raj\\Automation testing\\Selenium\\Screenshot\\TC"+TCName+"Screenshot.png");
		FileHandler.copy(Source, Dest);
		
	}
	public void BrowserClose()
	{
		driver.close();
	}

}
