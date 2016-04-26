package base;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.mobile.NetworkConnection.ConnectionType;
import org.seleniumhq.jetty7.io.Connection;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import readProperties.LoadAndroidPropertiesFile;
import utils.ExecuteShell;

//This class defines common methods that would be used frequently by the test scripts.

public class CommonMethods {

	public AppiumDriver driver=  TestBase.getDriver();
	ExecuteShell shell = new ExecuteShell();
	//This method hides the keyboard.
	public void hideKeyboard(){
		try{
			System.out.println("Hiding keyboard");
			driver.hideKeyboard();
		}
		catch(WebDriverException e){
			e.printStackTrace();
		}
	}
		
	//This method gets the keyboard.
	public void getKeyboard(){
		try{
			System.out.println("Getting keyboard");
			driver.getKeyboard();
		}
		catch(WebDriverException e){
			e.printStackTrace();
		}
	}	
	
	//Used to press device menu button. -Works for android only
	public void pressDeviceMenuButton(){
		try{
			((AndroidDriver)driver).sendKeyEvent(AndroidKeyCode.MENU);			
		}
		catch(WebDriverException e){
			e.printStackTrace();
		}
	}
	
	//Used to press device menu button. -Works for android only
	public void pressDeviceHomeButton(){
		try{
			((AndroidDriver)driver).sendKeyEvent(AndroidKeyCode.HOME);			
		}
		catch(WebDriverException e){
			e.printStackTrace();
		}
	}
	
	//Sets device to airplane mode- Works for android only
	public void enableAirplaneMode(){			
		try{
			System.out.println("Turning On Airplane Mode");
			shell.executeCommand("adb shell settings put global airplane_mode_on 1");
			shell.executeCommand("adb shell am broadcast -a android.intent.action.AIRPLANE_MODE --ez state true");	
			System.out.println("Airplane mode On");
			Thread.sleep(3000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Disable's airplane mode- Works for android only
	public void disableAirplaneMode(){			
		try{
			System.out.println("Turning Off Airplane Mode");
			shell.executeCommand("adb shell settings put global airplane_mode_on 0");
			shell.executeCommand("adb shell am broadcast -a android.intent.action.AIRPLANE_MODE --ez state false");	
			System.out.println("Airplane mode Off");
			Thread.sleep(3000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
	
	//Enable WiFi on the device- Works for android only
	public void enableWiFi(){
			try{
				System.out.println("Turning ON WiFi");
				shell.executeCommand("adb shell am start -n io.appium.settings/.Settings -e wifi on");
				System.out.println("WiFi is ON now");	
				Thread.sleep(3000);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	
	//Disable WiFi on the device- Works for android only
	public void disableWiFi(){
		try{
			System.out.println("Turning OFF WiFi");
			shell.executeCommand("adb shell am start -n io.appium.settings/.Settings -e wifi off");
			System.out.println("WiFi is OFF now");	
			Thread.sleep(3000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
		
	//Enable Mobile Data on the device- Works for android only
	public void enableMobileData(){
		try{
			System.out.println("Enabling Mobile Data");
			shell.executeCommand("adb shell am start -n io.appium.settings/.Settings -e data on");
			System.out.println("Mobile Data is ON now");
			Thread.sleep(3000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Disable Mobile Data on the device- Works for android only
	public void disableMobileData(){
		try{
			System.out.println("Turning OFF Mobile Data");
			shell.executeCommand("adb shell am start -n io.appium.settings/.Settings -e data off");
			System.out.println("Mobile Data is OFF now");
			Thread.sleep(3000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
		
	//Get device current network connection -Works for android only
	public String getNetworkConnection(){
		NetworkConnection myDriver = (NetworkConnection) driver;
		try{
			if(myDriver.getNetworkConnection()==ConnectionType.AIRPLANE_MODE)
				return "AirplaneMode";
			if(myDriver.getNetworkConnection()==ConnectionType.WIFI)
				return "WiFi";
			if(myDriver.getNetworkConnection()==ConnectionType.DATA)
				return "Data";					
		}
		catch(WebDriverException e){
			e.printStackTrace();
		}
		return "Connection not found";
	}
		
	//Used to lock the device screen
	public void lockScreen(){
		driver.lockScreen(1);
	}
			
	//Used to unlock the device screen.
	public void unlockScreen(){
			
	}
	
	//Used to change device orientation to Portrait
	public void changeOrientationToPortrait(){
		try{
			System.out.println("Changing device orientation to Portrait");
			driver.rotate(ScreenOrientation.PORTRAIT);
			System.out.println("Changed device orientation to Portrait");
			}
		catch(WebDriverException e){
			System.out.println("Unable to change device orientation to Portrait");
			e.printStackTrace();
			}
	}
			
	//Used to change device orientation to Landscape
	public void changeOrientationToLandscape(){
		try{
			System.out.println("Changing device orientation to Landscape");
			driver.rotate(ScreenOrientation.LANDSCAPE);
			System.out.println("Changed device orientation to Landscape");
			}
		catch(Exception e){
			System.out.println("Unable to change device orientation to Landscape");
			e.printStackTrace();
		}
	}
	
	//This method returns true if the app with provided package name is launched ,False otherwise.	
	public boolean isAppLaunched(){
		System.out.println("Checking if the app is launched");
		if(driver.getPageSource().contains(LoadAndroidPropertiesFile.APP_PACKAGE_NAME)){
			System.out.println("App is lauched");
			return true;
		}
		else{
			System.out.println("App was not launched");	
			return false;	
		}
	}
		
	//Used to navigate to home activity.
	public void goToHomeScreen(){
		
	}
	
	//This method takes a WebElement as argument and clicks on it.
	public void clickElement(WebElement element){
		try{
		System.out.println("Clicking the element");	
		element.click();
		System.out.println("Successfully Clicked");	
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
	}
	
	//This method takes a WebElement and a String as argument and enters the string in the WebElement.
	public void EnterText(WebElement element,String str){
		try{
			System.out.println("Entering text : " + str +" in the text field.");
			element.click();
			element.clear();
			element.sendKeys(str);
			System.out.println("Successfully entered text");	
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
	}
	
	//This method takes a WebElement as argument and returns the text of the WebElement.
	public String getElementText(WebElement element){
		String text="";
		try{
		System.out.println("Getting Element Text");	
		text=element.getText();
		System.out.print( "   "+ text);
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
		return text;
	}
	
	//This method returns true if the web-element is displayed on page and returns false otherwise
	public boolean isElementDisplayed(WebElement element){
		try{
		System.out.println("Checking if the element is displayed");	
			if(element.isDisplayed()){
				System.out.println("Element Displayed");
				return true;		
			}
			else{
				System.out.println("Element is not Displayed");
				return false;
			}
		}
		catch(NoSuchElementException e){
		return false;
		}
	}
	
	//This method takes a WebElement as argument and returns true if the check-box is selected,false otherwise.
	public boolean isCheckBoxSelected(WebElement element){
		boolean isCheckBoxSelected=false;	
		try{
		System.out.println("Checking if check-box is selected");	
			if(getAttribute(element,"checked").equals("true")){
				isCheckBoxSelected= true;
				System.out.println("Check-box was in slelected state");
			}
			else
				System.out.println("Check-box was not in selected state");
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		return isCheckBoxSelected;
	}
	
	//This method takes a WebElement and String as argument and returns the elements argument as String.
	public String getAttribute(WebElement element,String attribute){
		String resultAttribute="";
		try{
			System.out.println("Getting atribute: "+attribute +" of the element");
			resultAttribute= element.getAttribute(attribute);
			System.out.println("Attribute value: " + resultAttribute);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultAttribute;
	}
	
	//This method switches driver to the first frame on the page
	public void switchFrame(){
		try{
		System.out.println("Switcihng to frame 0");	
		driver.switchTo().frame(0);
		System.out.println("Successfully switched to frame 0");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//This method switches driver back to default frame.
	public void switchToDefaultContent(){
		try{
		System.out.println("Switching to default frame");	
		driver.switchTo().defaultContent();
		System.out.println("Successfully switched to default frame");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
