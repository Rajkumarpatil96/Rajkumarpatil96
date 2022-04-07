package UtilityPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static String getdatafromproprtyfile(String key) throws IOException
	{
		Properties p=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\manis\\eclipse-workspace0\\11dec -batch B\\myfile.properties");
		p.load(file);
		String value = p.getProperty(key);
		return value;
	}

	
	

}
