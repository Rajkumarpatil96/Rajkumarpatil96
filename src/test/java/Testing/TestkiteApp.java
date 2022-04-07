package Testing;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import PomPackage.PomHomePage;
import PomPackage.PomLoginPage;
import PomPackage.PomPinPage;
import UtilityPackage.Utility;
import baseclass.Base;

public class TestkiteApp extends Base {
	PomLoginPage login;
	PomPinPage pin;
	PomHomePage home;
	@Parameters("Browsername")
	@BeforeClass
	public void launchingBrowser(String Browsername) throws IOException
	{
		LaunchBrowser(Browsername);
		login=new PomLoginPage(driver);
		pin=new PomPinPage(driver);
		home=new PomHomePage(driver);
		
	}
	@BeforeMethod
	public void logintoKiteApp() throws IOException
	{
		login.enterUserid(Utility.getdatafromproprtyfile("UN"));
		login.enterpassword(Utility.getdatafromproprtyfile("PWD"));
		login.ClickOnlogiButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		pin.Enterpin(Utility.getdatafromproprtyfile("PIN"));
		pin.ClickOnContinueButton();
		
	}
	
	@Test
	public void Validationofuserid() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//int TCID=1;
		String Actualuserid = home.getuserid();
		String expecteduserid = Utility.getdatafromproprtyfile("UN");
		Assert.assertEquals(Actualuserid, expecteduserid,"Actual And expected username are not matching");
		Reporter.log("validation successful,test case is pass");
		//Utility.GetScreenshot(driver, TCID);
	}
	@AfterMethod
	public void LogoutKiteApp()
	{	
		home.ClickOnLogoutButton();
	}
	@AfterClass
	public void KiteAppclose()
	{
		BrowserClose();
	}
	
	
}
