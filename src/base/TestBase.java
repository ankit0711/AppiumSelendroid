package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import capabilities.AndroidCapabilities;
import capabilities.iOSCapabilities;
import readProperties.LoadAndroidPropertiesFile;
import readProperties.LoadiOSPropertiesFile;
import testcases.android.SelendroidTestAppMainScreenTest;
/*
 * This class reads the config.property file.
 * Loads the platform property file as per the entries in the config property file.
 * Set capabilities and initialize driver.
 * Quit the driver when the test is completed.
 */
public class TestBase {
	
	public static AppiumDriver driver;
	public static String PlatformName;
	static Properties prop = new Properties();
	
	
	@BeforeSuite
	public void setUp() throws IOException{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/properties/config.properties");
		prop.load(fis);
		PlatformName=prop.getProperty("platform");
		
		if(PlatformName.equalsIgnoreCase("android")){
			LoadAndroidPropertiesFile.loadAndroidConfigurationFile();
			AndroidCapabilities.setAndroidCapabilities();
			driver=AndroidCapabilities.getAndroidDriver();
		}
		
		else if(PlatformName.equalsIgnoreCase("iOS")){
			LoadiOSPropertiesFile.loadiOSConfigurationFile();
			iOSCapabilities.setiOSCapabilities();
			driver=iOSCapabilities.getiOSDriver();
		}
		
	}
	
	
	public static AppiumDriver getDriver(){
		return driver;
	}
	
	@AfterSuite
	public void tearDown(){
	//	driver.quit();
		
	}

}
