package PomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomHomePage {
@FindBy(xpath="//span[@class='user-id']")private WebElement Userid;
@FindBy(xpath="//a[@target='_self']")private WebElement LogOutButton;

public PomHomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public String getuserid()
{
	String text = Userid.getText();
	return text;
	
}
public void ClickOnLogoutButton()
{
	Userid.click();
	LogOutButton.click();
	
}
}
