package base;
import io.appium.java_client.AppiumDriver;

//This class defines common methods that would be used frequently by the application.

public class CommonMethods {

	public AppiumDriver driver= TestBase.getDriver();

	
	//This method hides the keyboard.
	public void hideKeyboard(){
		driver.hideKeyboard();
	}
	
	//Used to press device menu button.
	public void pressDeviceMenuButton(){
		
	}
	
	//Used to navigate to home activity.
	public void goToHomeScreen(){
		
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
	
	
	
}
