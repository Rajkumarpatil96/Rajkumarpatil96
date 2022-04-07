package Listenerpackage;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import baseclass.Base;


public class Listener extends Base implements ITestListener {
	public void onTestStart(ITestResult result) {
		
Reporter.log("Your Test case is Start",true);
	}
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
Reporter.log("Sorry Your test case is fail",true);
String TCName1 = result.getName();
try {
	GetScreenshot(TCName1);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


}public void onTestSuccess(ITestResult result) {
	Reporter.log("Congrats Your test case is pass");
	String TCName2 = result.getName();
	try {
		GetScreenshot(TCName2);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void onTestSkipped(ITestResult result) {
	Reporter.log("Your testcase "+result.getName()+"is Skipped",true);
	}
}
