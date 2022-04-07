package PomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomLoginPage {
@FindBy(id="userid")private WebElement userid;
@FindBy(id="password")private WebElement password;
@FindBy(xpath="//button[@type='submit']")private WebElement loginButton;

public PomLoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void enterUserid(String username)
{
	userid.sendKeys(username);
}
public void enterpassword(String pass)
{
	password.sendKeys(pass);
}
public void ClickOnlogiButton()
{
	loginButton.click();
}

}
