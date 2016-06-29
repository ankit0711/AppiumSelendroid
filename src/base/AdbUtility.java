package base;


import org.junit.Assert;

import readProperties.LoadAndroidPropertiesFile;
import utils.ExecuteShell;
import utils.LogUtil;


public class AdbUtility{

	public ExecuteShell executeShellCommand = new ExecuteShell();

	
	/*****************************************************************************************************************************************************************
	 *
	 * Functions for resuming app to the specified activity
	 * @param packageName, ActivityName
	 *
	 ****************************************************************************************************************************************************************/
	
	public void resumeApp(String packageName,String activityName) throws InterruptedException{
		System.out.println("Resume app");
		String runComponent=packageName+'/'+activityName;		
		executeShellCommand.ExecuteShellCommand("am","start",runComponent);
		Thread.sleep(4000);
	}

	/*****************************************************************************************************************************************************************
	 *
	 * Functions for launching app
	 * @param packageName, ActivityName
	 *
	 ****************************************************************************************************************************************************************/
	
	public void launchApp(String packageName,String activityName) throws InterruptedException{
		LogUtil.info("Launching app");
		String runComponent=packageName+'/'+activityName;
		executeShellCommand.ExecuteShellCommand("adb shell am","start","-n",runComponent);
		Thread.sleep(4000);
	}

	/*****************************************************************************************************************************************************************
	 *
	 * Functions for force stop the app
	 * @param packageName
	 *
	 ****************************************************************************************************************************************************************/
	
	public void forceStopApp(String packageName){
		executeShellCommand.ExecuteShellCommand("am", "force-stop",packageName);
	}

	/*****************************************************************************************************************************************************************
	 *
	 * Functions for getting logs
	 * @param packageName
	 *
	 ****************************************************************************************************************************************************************/
	
//	public String getLogs() throws Exception{
//		System.out.println("Getting Logs");
//		return	executeShellCommand.executeCommand("adb logcat | grep "+ executeShellCommand.getAppPid());
//	}



	/*****************************************************************************************************************************************************************
	 *
	 * Functions for clearing data for the package in parameters.
	 * @param packageName
	 *
	 ****************************************************************************************************************************************************************/

	public void clearData(String packageName) {
		System.out.println("Clearing hike data");
		executeShellCommand.ExecuteShellCommand("pm","clear" ,LoadAndroidPropertiesFile.APP_PACKAGE_NAME );
	}

	/****************************************************************************************************************************************************************
	 *
	 *
	 * @return boolean
	 * Returns true if device is locked and false if device is unlocked
	 ***************************************************************************************************************************************************************/

	public boolean isDeviceLocked()
	{
		System.out.println("********** Checking if device is locked/unlocked **********");
		String value =executeShellCommand.executeCommand("dumpsys power");
		if(value!=null)
		{
			try{
				int timeoutIndex= value.indexOf("mMinimumScreenOffTimeoutConfig");
				String timeoutConfig= value.substring(timeoutIndex+31).split("\n")[0];
				int currentTimeoutIndex= value.indexOf("Screen off timeout: ");
				String currentTimeout= value.substring(currentTimeoutIndex+20,currentTimeoutIndex+25).split("\n")[0];
				System.out.println("********** mMinimumScreenOffTimeoutConfig: \n"+timeoutConfig+"\n********** Screen off timeout: \n"+currentTimeout+"\n**********");
				if(timeoutConfig.equals(currentTimeout))
				{
					System.out.println("********** Device is LOCKED **********");
					return true;
				}
				else
				{
					System.out.println("********** Device is UNLOCKED **********");
					return false;
				}
			}
			catch(Exception e)
			{
				Assert.fail("Failed due to an exception: "+e.getMessage());
				return false;
			}
		}
		else
		{
			Assert.fail("Device not connected as executed command returned NULL");
			return false;
		}
	}

	/*****************************************************************************************************************************************************************
	 *
	 * Functions for exiting app
	 *
	 ****************************************************************************************************************************************************************/
	/**
	 * This function swipes hike from recent app panel
	 */
//	public void forceSwipe(String appName) {
//		try {
//			device.pressRecentApps();
//			UiObject applicationName = getElement(Locators.NAME, appName);
//			applicationName.swipeLeft(10);
//			device.waitForIdle();
//			device.pressHome();
//			device.pressRecentApps();
//			Assert.assertTrue("Could not force swipe"+returnScreenshot(), !applicationName.exists());
//		} catch (Exception e) {
//			e.printStackTrace();
//			Assert.fail("Could not force swipe" + returnScreenshot());
//		}
//	}
	
	/*************************************************************************************************************************************************************
	 * This method checks if any android device is connected to the system.
	 * @return: Boolean - True in case android device is connected, false otherwise
	 ************************************************************************************************************************************************************/
	
	public boolean isDeviceConnected(){
		try{
			String[] cmd= {"adb","devices"};
			String line=executeShellCommand.ExecuteShellCommand(cmd).trim();				
			if(line.equals("List of devices attached"))
	        	return false;
	        else
	        	return true;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
        
	}
	
	/*************************************************************************************************************************************************************
	 * This method returns the name of the Android device connected.
	 * @return: String -Name of the device connected.
	 ************************************************************************************************************************************************************/
	
	public String getDeviceName(){
		try{
			String[] cmd= {"adb", "shell", "getprop" ,"ro.product.model"};
			String deviceName=executeShellCommand.ExecuteShellCommand(cmd).trim();
			return deviceName;
		}
		catch(Exception e){
			System.out.println("Unable to fetch device name");
			return e.getMessage();
		}
	}
	
	/*************************************************************************************************************************************************************
	 * This method returns the OS version of the Device connected.
	 * @return: String-The OS version of the device connected.
	 ************************************************************************************************************************************************************/
	
	public String getDeviceOSVersion(){
		try{			
			String[] cmd= {"adb", "shell", "getprop" ,"ro.build.version.release"};
			String deviceOSVersion=executeShellCommand.ExecuteShellCommand(cmd).trim();
			return deviceOSVersion;
		}
		catch(Exception e){
			System.out.println("Unable to fetch device os version");
			return e.getMessage();
		}
	}
	
	/*************************************************************************************************************************************************************
	 * This method returns the name of the launcher activity for the package in parameter.
	 * @param packageName
	 * @return:String-The name of the launcher activity.
	 ************************************************************************************************************************************************************/
	
	public String getLauncherActivity(String packageName){
		try{
		String[] cmd=	{"adb", "shell", "pm" ,"list", "packages", "-f", packageName};
		String apkPath=executeShellCommand.ExecuteShellCommand(cmd).trim();
		int startIndex=apkPath.indexOf("/");
		int endIndex=apkPath.indexOf('=');
		apkPath=apkPath.substring(startIndex, endIndex);
		String apkName=apkPath.substring(apkPath.lastIndexOf('/')+1);			
		String[] cmd1={"adb", "pull", apkPath};
		executeShellCommand.ExecuteShellCommand(cmd1).trim();		
		String cmd2[]={"aapt", "dump", "badging" ,apkName};
		String[] temp=executeShellCommand.ExecuteShellCommand(cmd2).trim().split("\n");         
		String line="";
		int len=temp.length;
		while(len-->0){
			if(temp[len-1].contains("launchable")){
				line=temp[len-1];
				break;
			}
		}	
		int beginIndex=line.indexOf('\'');
		int lastIndex=line.indexOf('\'', beginIndex+1 );
		String launcherActivity=line.substring(beginIndex+1, lastIndex);
		return launcherActivity;
		}
		catch(Exception e){
			return e.getMessage();
		}		
	}
	
	
}
