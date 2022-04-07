package PomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomPinPage {
@FindBy(id="pin")private WebElement pin;
@FindBy(xpath="//button[@type='submit']")private WebElement ContinueButton;

public PomPinPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void Enterpin(String pin1)
{
	pin.sendKeys(pin1);
}
public void ClickOnContinueButton()
{
	ContinueButton.click();
}
}
