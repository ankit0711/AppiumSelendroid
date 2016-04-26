package base;


import org.junit.Assert;

import readProperties.LoadAndroidPropertiesFile;
import utils.ExecuteShell;


public class AdbUtility extends CommonMethods{

	public ExecuteShell executeShellCommand = new ExecuteShell();

	public void resumeApp(String packageName,String activityName) throws InterruptedException{
		System.out.println("Resume app");
		String runComponent=packageName+'/'+activityName;
		executeShellCommand.ExecuteShellCommand("am","start",runComponent);
		Thread.sleep(4000);
	}

	public void launchApp(String packageName,String activityName) throws InterruptedException{
		System.out.println("Launching app");
		String runComponent=packageName+'/'+activityName;
		executeShellCommand.ExecuteShellCommand("am","start","-n",runComponent);
		Thread.sleep(4000);
	}

	public void forceStopApp(String packageName){
		executeShellCommand.ExecuteShellCommand("am", "force-stop",packageName);
	}

	public void launchSpecificActivity(String AppPackage,String activity) throws InterruptedException{
		System.out.println("Launching App");
		String packageName=AppPackage;
		String activityName=activity;
		launchApp(packageName, activityName);
	}

	public String getLogs() throws Exception{
		System.out.println("Getting Logs");
		return	executeShellCommand.executeCommand("logcat | grep "+ executeShellCommand.getAppPid());
	}
	/*****************************************************************************************************************************************************************
	 *
	 * Functions for launching app
	 * @param packageName TODO
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
	 * @author chetan
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
	 * @author pooja This function swipes hike from recent app panel
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
}
