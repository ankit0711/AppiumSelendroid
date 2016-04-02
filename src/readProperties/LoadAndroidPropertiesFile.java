package readProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadAndroidPropertiesFile {
	public static int IMPLICIT_WAIT;
	public static int APPIUM_SERVER_PORT;
	public static String Android_DEVICE_NAME;
	public static String PLATFORM_NAME;
	public static String BROWSER_NAME;
	public static String APP_PACKAGE_NAME;
	public static String PLATFORM_VERSION;
	public static String ACTIVITY_NAME;
	public static String PLATFORM;
	public static String APP_PATH;
	static Properties prop = new Properties();
	
	public static void loadAndroidConfigurationFile() throws IOException{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/properties/android.properties");
		prop.load(fis);
		
		IMPLICIT_WAIT=Integer.parseInt(prop.getProperty("implicit.wait").trim());
		APPIUM_SERVER_PORT=Integer.parseInt(prop.getProperty("appium.server.port").trim());
		Android_DEVICE_NAME=prop.getProperty("android.device.name").trim();
		PLATFORM_NAME=prop.getProperty("platform.name").trim();
		BROWSER_NAME=prop.getProperty("browser.name").trim();
		APP_PACKAGE_NAME=prop.getProperty("application.app").trim();
		PLATFORM_VERSION=prop.getProperty("platform.version").trim();
		ACTIVITY_NAME=prop.getProperty("activity.name").trim();
		PLATFORM=prop.getProperty("platform").trim();
		APP_PATH=prop.getProperty("app.path").trim();
		//APP_ACTIVITY=prop.getProperty("app.activity").trim();
	}

}
