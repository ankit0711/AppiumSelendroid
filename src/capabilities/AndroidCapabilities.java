package capabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import base.AdbUtility;
import readProperties.LoadAndroidPropertiesFile;

/*
 * This class is a singleton class that set's up Android capabilities.
 * Declares  method to return the driver after initializing it.
 */
public class AndroidCapabilities {

	public static AppiumDriver driver;
	public static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static URL serverURL;
	
	private AndroidCapabilities(){
		
	}
	
	/*
	 * This method sets up the required Android capabilities.
	 */
	public static void setAndroidCapabilities(){
		AdbUtility adbUtil = new AdbUtility();
		capabilities.setCapability("browserName", LoadAndroidPropertiesFile.BROWSER_NAME);
		//capabilities.setCapability("platform", LoadAndroidPropertiesFile.PLATFORM);
		capabilities.setCapability("platformName", LoadAndroidPropertiesFile.PLATFORM_NAME);
		capabilities.setCapability("deviceName",adbUtil.getDeviceName());     
	    capabilities.setCapability("platformVersion",adbUtil.getDeviceOSVersion());
	    capabilities.setCapability("app",LoadAndroidPropertiesFile.APP_PATH);
	    capabilities.setCapability("appPackage",LoadAndroidPropertiesFile.APP_PACKAGE_NAME);
	    capabilities.setCapability("appActivity", adbUtil.getLauncherActivity(LoadAndroidPropertiesFile.APP_PACKAGE_NAME));
	}
	
	/*
	 * This method returns the android driver.
	 */
	public static AppiumDriver getAndroidDriver() throws MalformedURLException {
		if(driver==null)
			{
			serverURL=new URL("http://127.0.0.1:"+LoadAndroidPropertiesFile.APPIUM_SERVER_PORT+"/wd/hub");
			driver = new AndroidDriver<>(serverURL, capabilities);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		return driver;
	}
	
}
