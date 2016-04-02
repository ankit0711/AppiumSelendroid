package capabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import readProperties.LoadAndroidPropertiesFile;

/*
 * This class is a singleton class that set's up iOS capabilities.
 * Declares  method to return the driver after initializing it.
 */

public class iOSCapabilities {

	public static AppiumDriver driver;
	public static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static URL serverURL;
	
	private iOSCapabilities(){
		
	}
	
/*
* This method sets up the required iOS capabilities.
*/
	
public static void setiOSCapabilities(){
		
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, LoadAndroidPropertiesFile.BROWSER_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM, LoadAndroidPropertiesFile.PLATFORM);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, LoadAndroidPropertiesFile.PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,LoadAndroidPropertiesFile.Android_DEVICE_NAME);     
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,LoadAndroidPropertiesFile.PLATFORM_VERSION);
	    capabilities.setCapability(MobileCapabilityType.APP,LoadAndroidPropertiesFile.APP_PATH);
	    capabilities.setCapability(MobileCapabilityType.APP_PACKAGE,LoadAndroidPropertiesFile.APP_PACKAGE_NAME);
	    capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, LoadAndroidPropertiesFile.ACTIVITY_NAME);
	}

/*
 * This method returns the iOS driver.
 */
	public static AppiumDriver getiOSDriver() throws MalformedURLException{
	if(driver==null)
		{
		serverURL=new URL("http://localhost"+LoadAndroidPropertiesFile.APPIUM_SERVER_PORT+"/wd/hub");
		driver = new IOSDriver<>(serverURL, capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	return driver;
}

}
