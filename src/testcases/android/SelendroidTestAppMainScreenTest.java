package testcases.android;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.TestBase;
import capabilities.AndroidCapabilities;
import mx4j.log.Log;
import screens.android.SelendroidTestAppMainScreen;
import utils.LogUtil;

public class SelendroidTestAppMainScreenTest extends TestBase{
	
	SelendroidTestAppMainScreen mainscreen;
	
	@BeforeClass
	public void setUpDriver(){
		mainscreen=PageFactory.initElements(driver, SelendroidTestAppMainScreen.class);
	}
	
	/*==============================================================================================================================
	 *1)Verify the screen title.
	 *The expected title is "selendroid-test-app"
	 *==============================================================================================================================*/
	@Test(priority=0,enabled=true,description="Verifying the Screen Title")
	public void verifyPagetitle(){
		try{
		LogUtil.startTestCase("SelendroidTestAppMainScreenTest", "Verifying the screen title");
		String actual=mainscreen.getPageTitle().trim();
		String expected="selendroid-test-app";
		Assert.assertEquals(actual, expected);
		LogUtil.endTestCase();
		}
		catch(Exception e){
			LogUtil.errorMessageWithStackTrace("Error in Verifying the Screen Title: "+e.getMessage(),e);
		}
	}
	
	/*==============================================================================================================================
	 *1)Verify the Label at the top of the page
	 *Expected text for label is "Hello Default Locale, Selendroid-test-app!"
	 *==============================================================================================================================*/
	@Test(priority=1,enabled=true,description="Verifying label at the top of the page")
	public void verifyPageHeader(){
		try{
		LogUtil.startTestCase("SelendroidTestAppMainScreenTest", "Verifying label at the top of the page");
		String actual=mainscreen.getPageHeader().trim();
		String expected="Hello Default Locale, Selendroid-test-app!";
		Assert.assertEquals(actual, expected);
		LogUtil.endTestCase();
		}
		catch(Exception e){
			LogUtil.errorMessageWithStackTrace("Error in Verifying label at the top of the page: "+e.getMessage(),e);
		}
	}
	
	/*==============================================================================================================================
	 *1)Verify the label for Localization
	 *Expected text for label is "Localization (L10n) locator test"
	 *==============================================================================================================================*/
	@Test(priority=2,enabled=true,description="Verifying the localization label")
	public void verifyPageLabelLocalizationText(){
		try{
		LogUtil.startTestCase("SelendroidTestAppMainScreenTest", "Verifying the localization label");
		String actual=mainscreen.getPageLabelLocalizationText().trim();
		String expected="Localization (L10n) locator test";
		Assert.assertEquals(actual, expected);
		LogUtil.endTestCase();
		}
		catch(Exception e){
			LogUtil.errorMessageWithStackTrace("Error in Verifying the localization label: "+e.getMessage(),e);
		}
	}
	
	/*==============================================================================================================================
	 *1)Verify the EN Button text.
	 *Expected text on the button is EN Button.
	 *==============================================================================================================================*/
	@Test(priority=3,enabled=true,description="Verifying the EN Button Text")
	public void verifyENButtonText(){
		try{
		LogUtil.startTestCase("SelendroidTestAppMainScreenTest", "Verifying the EN Button Text");	
		String actual=mainscreen.getENButtonText().trim();
		String expected="EN Button";
		Assert.assertEquals(actual, expected);
		LogUtil.endTestCase();
		}
		catch(Exception e){
			LogUtil.errorMessageWithStackTrace("Error in Verifying the EN Button Text: "+e.getMessage(),e);
		}
	}
	
	/*==============================================================================================================================
	 *1.Click on the EN Button.
	 *2.Verify if the confirmation pop up is shown with Correct label and buttons.(Expected Label="This will end the activity",Expected buttons: "I agree" and "No,No")
	 *3.Click on the "No,No" button.
	 *4.Verify if the confirmation message is not shown anymore.
	 *5.Click on the EN Button again.
	 *6.Click on "I agree" button
	 *7.Verify if the app gets dismissed.
	 *==============================================================================================================================*/
	@Test(priority=4,enabled=true,description="Verifying the EN Button functionality")
	public void testENButtonFunctionality(){
		try{
		LogUtil.startTestCase("SelendroidTestAppMainScreenTest", "Verifying the EN Button functionality");
		String confirmationLabel="This will end the activity",agreeButtonText="I agree",noButtonText="No, no";
		mainscreen.clickEnButton();
		Assert.assertEquals(mainscreen.getEnButtonConfirmationLabelText(), confirmationLabel);
		Assert.assertEquals(mainscreen.getEnButtonConfirmationAgreeButtonText(), agreeButtonText);
		Assert.assertEquals(mainscreen.getEnButtonConfirmationNoButtonText(), noButtonText);
		mainscreen.clickEnButtonConfirmationNoButton();
		Assert.assertEquals(mainscreen.isEnButtonConfirmationLabelDisplayed(), false);
		mainscreen.clickEnButton();
		mainscreen.clickEnButtonConfirmationAgreeButton();
		Assert.assertEquals(mainscreen.isAppLaunched(), false);
		mainscreen.launchAppInTest();
		Assert.assertEquals(mainscreen.isAppLaunched(), true);
		LogUtil.endTestCase();
		}
		catch(Exception e){
			LogUtil.errorMessageWithStackTrace("Error in Verifying the EN Button functionality: "+e.getMessage(),e);
		}
	}
	
	/*==============================================================================================================================
	 *1)Click in the text field.
	 *2)Verify that the text field does not have any text.
	 *3)Enter some text in the text field.
	 *4)Verify that the text is being displayed in the text field.
	 *==============================================================================================================================*/
	@Test(priority=5,enabled=true,description="Verifying the text field functionality")
	public void myTextFieldTest(){
		try{
		LogUtil.startTestCase("SelendroidTestAppMainScreenTest", "Verifying the text field functionality");
		String initialText=mainscreen.getTextMyTextField();
		Assert.assertEquals(initialText, "");
		mainscreen.enterTextInMyTextField("SampleText");
		String finalText=mainscreen.getTextMyTextField();
		Assert.assertEquals(finalText, "SampleText");
		LogUtil.endTestCase();
		}
		catch(Exception e){
			LogUtil.errorMessageWithStackTrace("Error in Verifying the text field functionality: "+e.getMessage(),e);
		}
	}
	
	/*==============================================================================================================================
	 *1)Verify that the 'I accept adds' check-box is selected by default.
	 *2)Click on the check-box to de-select it.
	 *3)Verify that the check-box is de-selected now.
	 *4)Click on the check-box to select it.
	 *5)Verify that the check-box is in selected state now.
	 *==============================================================================================================================*/
	@Test(priority=6,enabled=true,description="Verifying the 'I accept' check-box functionality")
	public void testIAcceptAddsCheckBox(){
		try{
		LogUtil.startTestCase("SelendroidTestAppMainScreenTest", "Verifying the 'I accept' check-box functionality");	
		String expectedText="I accept adds";
		Assert.assertEquals(mainscreen.getIAcceptAddsCheckboxText(),expectedText);
		Assert.assertEquals(mainscreen.isIAcceptAddsCheckboxSelected(), true);
		mainscreen.clickiIAcceptAddsCheckbox();
		Assert.assertEquals(mainscreen.isIAcceptAddsCheckboxSelected(), false);
		mainscreen.clickiIAcceptAddsCheckbox();
		Assert.assertEquals(mainscreen.isIAcceptAddsCheckboxSelected(), true);
		LogUtil.endTestCase();
		}
		catch(Exception e){
			LogUtil.errorMessageWithStackTrace("Error in Verifying the 'I accept' check-box functionality: "+e.getMessage(),e);
		}
		
	}
	
	@Test(priority=7,enabled=true,description="Verifying the progress bar functionality")
	public void testProgressBar(){
		try{
		LogUtil.startTestCase("SelendroidTestAppMainScreenTest", "Verifying the progress bar functionality");	
		mainscreen.clickShowProgressBarForAWhileButton();
		LogUtil.endTestCase();
		}
		catch(Exception e){
			LogUtil.errorMessageWithStackTrace("Error in Verifying the progress bar functionality: "+e.getMessage(),e);
		}
	}
	
	@Test(priority=8,enabled=true,description="Testing My Common Methods")
	public void testCommonMethods(){
		try{
		LogUtil.startTestCase("SelendroidTestAppMainScreenTest", "Verifying common Methods");	
		mainscreen.enterTextInMyTextField("Hello");
		mainscreen.hideKeyboard();
		Thread.sleep(3000);
		mainscreen.getKeyboard();
		Thread.sleep(3000);
		LogUtil.endTestCase();
		}
		catch(Exception e){
			LogUtil.errorMessageWithStackTrace("Error in Testing My Common Methods: "+e.getMessage(),e);
		}
	}
	
}
