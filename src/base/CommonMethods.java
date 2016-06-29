package base;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import readProperties.LoadAndroidPropertiesFile;
import utils.ExecuteShell;
import utils.LogUtil;

//This class defines common methods that would be used frequently by the test scripts.

public class CommonMethods {

	AdbUtility adb = new AdbUtility();
	public AppiumDriver driver=  TestBase.getDriver();
	ExecuteShell shell = new ExecuteShell();

/*==============================================================================================================================
*	 Hides the keyboard if it is showing.																					   *
*	 @param: none																											   *
*	 @return: void																									           *
*==============================================================================================================================*/	
	public void hideKeyboard(){
		try{
			LogUtil.info("Hiding keyboard");
			driver.hideKeyboard();
			driver.getKeyboard();
		}
		catch(WebDriverException e){
			e.printStackTrace();
		}
	}

/*==============================================================================================================================
	 This method gets the keyboard.
	 @param: none
	 @return:Keyboard
*==============================================================================================================================*/	
	
	public Keyboard getKeyboard(){
		try{
			LogUtil.info("Getting keyboard");
			return driver.getKeyboard();
		}
		catch(WebDriverException e){
			e.printStackTrace();
			return null;
		}
	}	
	

/*==============================================================================================================================
*	 Used to press device Menu button. -Works for android only																   *
*	 @param: none																											   *
*	 @return: void																									           *
*==============================================================================================================================*/		
	public void pressDeviceMenuButton(){
		try{
			LogUtil.info("Pressing Device MENU key");
			((AndroidDriver)driver).sendKeyEvent(AndroidKeyCode.MENU);			
		}
		catch(WebDriverException e){
			e.printStackTrace();
		}
	}
	
	
/*==============================================================================================================================
*	 Used to press device Home button. -Works for android only																   *
*	 @param: none																											   *
*	 @return: void																									           *
*==============================================================================================================================*/	
	public void pressDeviceHomeButton(){
		try{
			LogUtil.info("Pressing Device HOME key");
			((AndroidDriver)driver).sendKeyEvent(AndroidKeyCode.HOME);			
		}
		catch(WebDriverException e){
			e.printStackTrace();
		}
	}
	

/*==============================================================================================================================
*	 Sets device to airplane mode- Works for android only																       *
*	 @param: none																											   *
*	 @return: void																									           *
*==============================================================================================================================*/
	public void enableAirplaneMode(){			
		try{
			LogUtil.info("Turning On Airplane Mode");
			shell.executeCommand("adb shell settings put global airplane_mode_on 1");
			shell.executeCommand("adb shell am broadcast -a android.intent.action.AIRPLANE_MODE --ez state true");	
			LogUtil.info("Airplane mode On");
			Thread.sleep(3000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
/*==============================================================================================================================
*	 Disable's airplane mode- Works for android only																           *
*	 @param: none																											   *
*	 @return: void																									           *
*==============================================================================================================================*/
	public void disableAirplaneMode(){			
		try{
			LogUtil.info("Turning Off Airplane Mode");
			shell.executeCommand("adb shell settings put global airplane_mode_on 0");
			shell.executeCommand("adb shell am broadcast -a android.intent.action.AIRPLANE_MODE --ez state false");	
			LogUtil.info("Airplane mode Off");
			Thread.sleep(3000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

/*==============================================================================================================================
*	 Enable WiFi on the device- Works for android only																           *
*	 @param: none																											   *
*	 @return: void																									           *
*==============================================================================================================================*/
	public void enableWiFi(){
			try{
				LogUtil.info("Turning ON WiFi");
				shell.executeCommand("adb shell am start -n io.appium.settings/.Settings -e wifi on");
				LogUtil.info("WiFi is ON now");	
				Thread.sleep(3000);
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
	

/*==============================================================================================================================
*	 Disable WiFi on the device- Works for android only																           *
*	 @param: none																											   *
*	 @return: void																									           *
*==============================================================================================================================*/
	public void disableWiFi(){
		try{
			LogUtil.info("Turning OFF WiFi");
			shell.executeCommand("adb shell am start -n io.appium.settings/.Settings -e wifi off");
			LogUtil.info("WiFi is OFF now");	
			Thread.sleep(3000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
		
	
/*==============================================================================================================================
*	 Enable Mobile Data on the device- Works for android only																   *
*	 @param: none																											   *
*	 @return: void																									           *
*==============================================================================================================================*/
	public void enableMobileData(){
		try{
			LogUtil.info("Enabling Mobile Data");
			shell.executeCommand("adb shell am start -n io.appium.settings/.Settings -e data on");
			LogUtil.info("Mobile Data is ON now");
			Thread.sleep(3000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
/*==============================================================================================================================
*	 Disable Mobile Data on the device- Works for android only																   *
*	 @param: none																											   *
*	 @return: void																									           *
*==============================================================================================================================*/
	public void disableMobileData(){
		try{
			LogUtil.info("Turning OFF Mobile Data");
			shell.executeCommand("adb shell am start -n io.appium.settings/.Settings -e data off");
			LogUtil.info("Mobile Data is OFF now");
			Thread.sleep(3000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
		

/*==============================================================================================================================
*	 Used to lock the device screen																                               *
*	 @param: none																											   *
*	 @return: void																									           *
*==============================================================================================================================*/
	public void lockScreen(){
		try{
			LogUtil.info("Trying to lock the device");
			driver.lockScreen(3);
			LogUtil.info("Device locked");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
			
	
/*==============================================================================================================================
*	 Used to unlock the device screen.																                           *
*	 @param: none																											   *
*	 @return: void																									           *
*==============================================================================================================================*/
	public void unlockScreen(){
		try{
			LogUtil.info("Trying to unlock the device");
			adb.launchApp("io.appium.unlock", "io.appium.unlock.Unlock");
			LogUtil.info("Device unlocked");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

/*==============================================================================================================================
*	 Used to change device orientation to Portrait.																               *
*	 @param: none																											   *
*	 @return: void																									           *
*==============================================================================================================================*/
	public void changeOrientationToPortrait(){
		try{
			LogUtil.info("Changing device orientation to Portrait");
			driver.rotate(ScreenOrientation.PORTRAIT);
			LogUtil.info("Changed device orientation to Portrait");
			}
		catch(WebDriverException e){
			LogUtil.info("Unable to change device orientation to Portrait");
			e.printStackTrace();
			}
	}
			
	
/*==============================================================================================================================
*	 Used to change device orientation to Landscape.																           *
*	 @param: none																											   *
*	 @return: void																									           *
*==============================================================================================================================*/
	public void changeOrientationToLandscape(){
		try{
			LogUtil.info("Changing device orientation to Landscape");
			driver.rotate(ScreenOrientation.LANDSCAPE);
			LogUtil.info("Changed device orientation to Landscape");
			}
		catch(Exception e){
			LogUtil.info("Unable to change device orientation to Landscape");
			e.printStackTrace();
		}
	}
	
		
/*==============================================================================================================================
*	 This method returns true if the app with provided package name is launched ,False otherwise.							   *
*	 @param: none																											   *
*	 @return: boolean																									           *
*==============================================================================================================================*/
	public boolean isAppLaunched(){
		LogUtil.info("Checking if the app is launched");
		if(driver.getPageSource().contains(LoadAndroidPropertiesFile.APP_PACKAGE_NAME)){
			LogUtil.info("App is lauched");
			return true;
		}
		else{
			LogUtil.info("App was not launched");	
			return false;	
		}
	}
		

/*==============================================================================================================================
*	 Launch the application in test.																                           *
*	 @param: none																											   *
*	 @return: void																									           *
*==============================================================================================================================*/
	public void launchAppInTest(){
		try{
		LogUtil.info("Launching the app");	
		adb.launchApp(LoadAndroidPropertiesFile.APP_PACKAGE_NAME, LoadAndroidPropertiesFile.ACTIVITY_NAME);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

/*==============================================================================================================================
*	 Shake device - Works for iOS device.																                       *
*	 @param: none																											   *
*	 @return: void																									           *
*==============================================================================================================================*/
	public void shakeDevice(){
		try{
			((IOSDriver)driver).shake();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
/*==============================================================================================================================
*	 This methods performs swipe operation.																                       *
*	 @param: int startXIndex, int startYIndex, int endXIndex, int endYIndex, int duration									   *
*	 @return: void																									           *
*==============================================================================================================================*/
	public void swipe(int startx,int starty, int endx, int endy, int duration){
		try{
			LogUtil.info("Performing swipe operation");
			driver.swipe(startx, starty, endx, endy, duration);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

/*==============================================================================================================================
*	 This method takes a WebElement as argument and clicks on it.														       *
*	 @param: WebElement																										   *
*	 @return: void																									           *
*==============================================================================================================================*/
	public void clickElement(WebElement element){
		try{
		LogUtil.info("Clicking the element");	
		element.click();
		LogUtil.info("Successfully Clicked");	
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
	}
	
/*==============================================================================================================================
*	 This method takes a WebElement and a String as argument and enters the string in the WebElement.						   *
*	 @param: WebElement, String																								   *
*	 @return: void																									           *
*==============================================================================================================================*/
	public void EnterText(WebElement element,String str){
		try{
			LogUtil.info("Entering text : " + str +" in the text field.");
			element.click();
			element.clear();
			element.sendKeys(str);
			LogUtil.info("Successfully entered text");	
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
	}
	

/*==============================================================================================================================
*	 This method takes a WebElement as argument and returns the text of the WebElement.					                  	   *
*	 @param: WebElement																								           *
*	 @return: String																									       *
*==============================================================================================================================*/
	public String getElementText(WebElement element){
		String text="";
		try{
		LogUtil.info("Getting Element Text");	
		text=element.getText();
		LogUtil.info( "Actual text:"+ text);
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
		return text;
	}
	
	
/*==============================================================================================================================
*	 This method returns true if the web-element is displayed on page and returns false otherwise					           *
*	 @param: WebElement																								           *
*	 @return: Boolean																									       *
*==============================================================================================================================*/
	public boolean isElementDisplayed(WebElement element){
		try{
		LogUtil.info("Checking if the element is displayed");	
			if(element.isDisplayed()){
				LogUtil.info("Element Displayed");
				return true;		
			}
			else{
				LogUtil.info("Element is not Displayed");
				return false;
			}
		}
		catch(NoSuchElementException e){
		return false;
		}
	}
	
	
/*==============================================================================================================================
*	 This method takes a WebElement as argument and returns true if the check-box is selected,false otherwise.			       *
*	 @param: WebElement																								           *
*	 @return: Boolean																									       *
*==============================================================================================================================*/
	public boolean isCheckBoxSelected(WebElement element){
		boolean isCheckBoxSelected=false;	
		try{
		LogUtil.info("Checking if check-box is selected");	
			if(getAttribute(element,"checked").equals("true")){
				isCheckBoxSelected= true;
				LogUtil.info("Check-box was in slelected state");
			}
			else
				LogUtil.info("Check-box was not in selected state");
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		return isCheckBoxSelected;
	}
	
	
/*==============================================================================================================================
*	 This method takes a WebElement and String as argument and returns the elements argument as String.      			       *
*	 @param: WebElement	, String 																							   *
*	 @return: String																									       *
*==============================================================================================================================*/
	public String getAttribute(WebElement element,String attribute){
		String resultAttribute="";
		try{
			LogUtil.info("Getting atribute: "+attribute +" of the element");
			resultAttribute= element.getAttribute(attribute);
			LogUtil.info("Attribute value: " + resultAttribute);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultAttribute;
	}
	

/*==============================================================================================================================
*	 This method switches driver to the first frame on the page      			                                               *
*	 @param: none 																						                 	   *
*	 @return: void																									           *
*==============================================================================================================================*/
	public void switchFrame(){
		try{
		LogUtil.info("Switcihng to frame 0");	
		driver.switchTo().frame(0);
		LogUtil.info("Successfully switched to frame 0");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

/*==============================================================================================================================
*	 This method switches driver back to default frame.      			                                                       *
*	 @param: none 																						                 	   *
*	 @return: void																									           *
*==============================================================================================================================*/
	public void switchToDefaultContent(){
		try{
		LogUtil.info("Switching to default frame");	
		driver.switchTo().defaultContent();
		LogUtil.info("Successfully switched to default frame");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
