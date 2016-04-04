package testcases.android;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CommonMethods;
import base.TestBase;
import screens.android.SelendroidTestAppMainScreen;

public class SelendroidTestAppMainScreenTest extends TestBase{
	
	SelendroidTestAppMainScreen mainscreen;
	CommonMethods commonMethods =null;

	@BeforeClass
	public void setUpDriver(){
		mainscreen=PageFactory.initElements(driver, SelendroidTestAppMainScreen.class);
	}
	
	/*
	 Verify the screen title.
	 The expected title is "selendroid-test-app"
	 */
	@Test
	public void verifyPagetitle(){
		
		String actual=mainscreen.getPageTitle().trim();
		String expected="selendroid-test-app";
		Assert.assertEquals(actual, expected);
	}
	
	/*
	 Verify the Label at the top of the page
	 Expected text for label is "Hello Default Locale, Selendroid-test-app!"
	 */
	@Test
	public void verifyPageHeader(){
		String actual=mainscreen.getPageHeader().trim();
		String expected="Hello Default Locale, Selendroid-test-app!";
		Assert.assertEquals(actual, expected);
	}
	
	/*
	 Verify the label for Localization
	 Expected text for label is "Localization (L10n) locator test"
	 */
	@Test
	public void verifyPageLabelLocalizationText(){
		String actual=mainscreen.getPageLabelLocalizationText().trim();
		String expected="Localization (L10n) locator test";
		Assert.assertEquals(actual, expected);
	}
	
	/*
	 Verify the EN Button text.
	 Expected text on the button is EN Button.
	 */
	@Test
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
	@Test
	public void testENButtonFunctionality(){
		String confirmationLabel="This will end the activity",agreeButtonText="I agree",noButtonText="No, no";
		mainscreen.clickEnButton();
		Assert.assertEquals(mainscreen.getEnButtonConfirmationLabelText(), confirmationLabel);
		Assert.assertEquals(mainscreen.getEnButtonConfirmationAgreeButtonText(), agreeButtonText);
		Assert.assertEquals(mainscreen.getEnButtonConfirmationNoButtonText(), noButtonText);
		mainscreen.clickEnButtonConfirmationNoButton();
		Assert.assertEquals(mainscreen.isEnButtonConfirmationLabelDisplayed(), false);
		mainscreen.clickEnButton();
		mainscreen.clickEnButtonConfirmationAgreeButton();
		
	}
	
	
}
