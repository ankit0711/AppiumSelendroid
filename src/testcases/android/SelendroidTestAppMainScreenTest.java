package testcases.android;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import capabilities.AndroidCapabilities;
import base.TestBase;
import screens.android.SelendroidTestAppMainScreen;

public class SelendroidTestAppMainScreenTest extends TestBase{
	
	SelendroidTestAppMainScreen mainscreen=null;

	@BeforeClass
	public void setUpDriver(){
		mainscreen= new SelendroidTestAppMainScreen(driver);
	}
	
	@Test
	public void verifyPagetitle(){
		
		String actual=mainscreen.getPageTitle().trim();
		String expected="selendroid-test-app";
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void verifyPageHeader(){
		String actual=mainscreen.getPageHeader().trim();
		String expected="Hello Default Locale, Selendroid-test-app!";
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void verifyPageLabelLocalizationText(){
		String actual=mainscreen.getPageLabelLocalizationText().trim();
		String expected="Localization (L10n) locator test";
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void verifyENButtonText(){
		String actual=mainscreen.getENButtonText().trim();
		String expected="EN Button";
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void testENButtonFunctionality(){
		
	}
	
	
}
