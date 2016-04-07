package testcases.android;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.AppiumMethods;
import base.TestBase;
import capabilities.AndroidCapabilities;
import readProperties.LoadAndroidPropertiesFile;
import screens.android.SelendroidTestAppMainScreen;

public class SelendroidTestAppMainScreenTest extends TestBase{
	
	SelendroidTestAppMainScreen mainscreen;
	AppiumMethods appiumMethods;
	
	@BeforeClass
	public void setUpDriver(){
		mainscreen=PageFactory.initElements(driver, SelendroidTestAppMainScreen.class);
		appiumMethods = new AppiumMethods();
	}
	
	/*
	 Verify the screen title.
	 The expected title is "selendroid-test-app"
	 */
	
	@Test(priority=0,enabled=true)
	public void verifyPagetitle(){
		
		String actual=mainscreen.getPageTitle().trim();
		String expected="selendroid-test-app";
		Assert.assertEquals(actual, expected);
	}
	
	/*
	 Verify the Label at the top of the page
	 Expected text for label is "Hello Default Locale, Selendroid-test-app!"
	 */
	@Test(priority=1,enabled=false)
	public void verifyPageHeader(){
		String actual=mainscreen.getPageHeader().trim();
		String expected="Hello Default Locale, Selendroid-test-app!";
		Assert.assertEquals(actual, expected);
	}
	
	/*
	 Verify the label for Localization
	 Expected text for label is "Localization (L10n) locator test"
	 */
	@Test(priority=2,enabled=false)
	public void verifyPageLabelLocalizationText(){
		String actual=mainscreen.getPageLabelLocalizationText().trim();
		String expected="Localization (L10n) locator test";
		Assert.assertEquals(actual, expected);
	}
	
	/*
	 Verify the EN Button text.
	 Expected text on the button is EN Button.
	 */
	@Test(priority=3,enabled=false)
	public void verifyENButtonText(){
		String actual=mainscreen.getENButtonText().trim();
		String expected="EN Button";
		Assert.assertEquals(actual, expected);
	}
	
	/*
	 1.Click on the EN Button.
	 2.Verify if the confirmation pop up is shown with Correct label and buttons.(Expected Label="This will end the activity",Expected buttons: "I agree" and "No,No")
	 3.Click on the "No,No" button.
	 4.Verify if the confirmation message is not shown anymore.
	 5.Click on the EN Button again.
	 6.Click on "I agree" button
	 7.Verify if the app gets dismissed.
	 */
	@Test(priority=4,enabled=false)
	public void testENButtonFunctionality(){
		String confirmationLabel="This will end the activity",agreeButtonText="I agree",noButtonText="No, no";
		mainscreen.clickEnButton();
		Assert.assertEquals(mainscreen.getEnButtonConfirmationLabelText(), confirmationLabel);
		Assert.assertEquals(mainscreen.getEnButtonConfirmationAgreeButtonText(), agreeButtonText);
		Assert.assertEquals(mainscreen.getEnButtonConfirmationNoButtonText(), noButtonText);
		mainscreen.clickEnButtonConfirmationNoButton();
		Assert.assertEquals(mainscreen.isEnButtonConfirmationLabelDisplayed(), false);
		//mainscreen.clickEnButton();
		//mainscreen.clickEnButtonConfirmationAgreeButton();
		//Assert.assertEquals(appiumMethods.isAppLaunched(), false);
		//AndroidCapabilities.launchMyApp();
		//System.out.println(driver.getPageSource().contains(LoadAndroidPropertiesFile.APP_PACKAGE_NAME));
	}
	
	/*
	 1.Click in the text field.
	 2.Verify that the text field does not have any text.
	 3.Enter some text in the text field.
	 4.Verify that the text is being displayed in the text field.
	 */
	@Test(priority=5,enabled=false)
	public void myTextFieldTest(){
		String initialText=mainscreen.getTextMyTextField();
		Assert.assertEquals(initialText, "");
		mainscreen.enterTextInMyTextField("SampleText");
		String finalText=mainscreen.getTextMyTextField();
		Assert.assertEquals(finalText, "SampleText");
	}
	
	/*
	  Verify that the 'I accept adds' check-box is selected by default.
	  Click on the check-box to de-select it.
	  Verify that the check-box is de-selected now.
	  Click on the check-box to select it.
	  Verify that the check-box is in selected state now.
	 */
	@Test(priority=6,enabled=false)
	public void testIAcceptAddsCheckBox(){
		String expectedText="I accept adds";
		Assert.assertEquals(mainscreen.getIAcceptAddsCheckboxText(),expectedText);
		Assert.assertEquals(mainscreen.isIAcceptAddsCheckboxSelected(), true);
		mainscreen.clickiIAcceptAddsCheckbox();
		Assert.assertEquals(mainscreen.isIAcceptAddsCheckboxSelected(), false);
		mainscreen.clickiIAcceptAddsCheckbox();
		Assert.assertEquals(mainscreen.isIAcceptAddsCheckboxSelected(), true);
		
	}
	
	@Test(priority=7,enabled=true)
	public void testProgressBar(){
		mainscreen.clickShowProgressBarForAWhileButton();
	}
	
}
