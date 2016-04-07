package base;

import io.appium.java_client.AppiumDriver;
import readProperties.LoadAndroidPropertiesFile;

public class AppiumMethods {

	public  AppiumDriver driver= TestBase.getDriver();
	
	//This method hides the keyboard.
	public void hideKeyboard(){
		driver.hideKeyboard();
	}
		
	//This method gets the keyboard.
		public void getKeyboard(){
			driver.getKeyboard();
	}
		
	//Used to press device menu button.
	public void pressDeviceMenuButton(){
		
	}
	
	//Used to lock the device screen
	public void lockScreen(){
		driver.lockScreen(1);
	}
		
	//Used to unlock the device screen.
	public void unlockScreen(){
		
	}
		
	//Used to change device orientation.
	public void changeOrientationToLandscape(){
			
	}
	
	public boolean isAppLaunched(){
		driver.getPageSource();
		if(driver.getPageSource().contains(LoadAndroidPropertiesFile.APP_PACKAGE_NAME))
			return true;
		else
			return false;
		
	}
}
