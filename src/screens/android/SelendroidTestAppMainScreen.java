package screens.android;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.CommonMethods;

public class SelendroidTestAppMainScreen extends CommonMethods {

//	public SelendroidTestAppMainScreen(){
//		PageFactory.initElements(driver, this);
//	}
	
	
	@FindBy(how=How.ID,using="title") 
	WebElement pageTitle;
	
	@FindBy(how=How.XPATH,using="//android.widget.TextView[1][@text='Hello Default Locale, Selendroid-test-app!']") 
	WebElement pageHeader;
	
	@FindBy(how=How.XPATH,using="//android.widget.TextView[1][@text='Localization (L10n) locator test']") 
	WebElement pageLabelLocalization;
	
	@FindBy(how=How.ID,using="buttonTest") 
	WebElement enButton;
	
	@FindBy(how=How.ID,using="message") 
    WebElement enButtonConfirmationLabel;
	
	@FindBy(how=How.ID,using="button1") 
	WebElement enButtonConfirmationAgreeButton;
	
	@FindBy(how=How.ID,using="button2") 
	WebElement enButtonConfirmationNoButton;
		
	@FindBy(how=How.ID,using="buttonStartWebview") 
	WebElement chromeButton;
	
	@FindBy(how=How.ID,using="startUserRegistration") 
	WebElement userRegisterationButton;
	
	@FindBy(how=How.ID,using="my_text_field") 
	WebElement myTextField;
	
	@FindBy(how=How.ID,using="waitingButtonTest") 
	WebElement showProgressBarForAWhileButton;
	
	@FindBy(how=How.ID,using="input_adds_check_box") 
	WebElement iAcceptAddsCheckbox;
	
	@FindBy(how=How.ID,using="visibleButtonTest") 
	WebElement displayTextViewButton
	;
	@FindBy(how=How.ID,using="showToastButton") 
	WebElement displaysAToastButton;
	
	@FindBy(how=How.ID,using="showPopupWindowButton") 
	WebElement displayPopUpWindowButton;
	
	@FindBy(how=How.ID,using="exceptionTestButton") 
	WebElement pressToThrowUnhandledExceptionButton;
	
	@FindBy(how=How.ID,using="exceptionTestField") 
	WebElement typeToThrowExceptionTextField;
	
	@FindBy(how=How.ID,using="encodingTextview") 
	WebElement japaneseLabel;
	
	@FindBy(how=How.ID,using="topLevelElementTest") 
	WebElement displayAndFocusOnLayoutButton;
	
	
	public String getPageTitle(){
		System.out.println(pageTitle.getText());
		return pageTitle.getText();
	}
	
	public String getPageHeader(){
		return pageHeader.getText();
	}
	
	public String getPageLabelLocalizationText(){
		return pageLabelLocalization.getText();
	}
	
	public String getENButtonText(){
		return enButton.getText();
	}
	
	public void clickEnButton(){
		enButton.click();
	}
	
	public boolean isEnButtonConfirmationLabelDisplayed(){
		return isElementDisplayed(enButtonConfirmationLabel);
	}
	
	public String getEnButtonConfirmationLabelText(){
		return enButtonConfirmationLabel.getText();
	}
	
	public void clickEnButtonConfirmationAgreeButton(){
		 enButtonConfirmationAgreeButton.click();
	}
	
	public String getEnButtonConfirmationAgreeButtonText(){
		return enButtonConfirmationAgreeButton.getText();
	}
	
	public void clickEnButtonConfirmationNoButton(){
		 enButtonConfirmationNoButton.click();
	}
	
	public String getEnButtonConfirmationNoButtonText(){
		return enButtonConfirmationNoButton.getText();
	}
	
	public void clickChromeButton(){
		chromeButton.click();
	}
	
	public void clickUserRegisterationButton(){
		userRegisterationButton.click();
	}
	
	public void enterTextInMyTextField(String text){
		myTextField.sendKeys(text);
	}
	
	public void clickShowProgressBarForAWhileButton(){
		showProgressBarForAWhileButton.click();
	}
	
	public void clickiIAcceptAddsCheckbox(){
		iAcceptAddsCheckbox.click();
	}
	
	public void clickDisplayTextViewButton(){
		displayTextViewButton.click();
	}
	
	public void clickDisplaysAToastButton(){
		displaysAToastButton.click();
	}
	
	public void clickDisplayPopUpWindowButton(){
		displayPopUpWindowButton.click();
	}
	
	public void clickPressToThrowUnhandledExceptionButton(){
		pressToThrowUnhandledExceptionButton.click();
	}
	
	public void enterTextTypeToThrowExceptionTextField(String text){
		typeToThrowExceptionTextField.sendKeys(text);
	}
	
	public String getTextJapaneseLabel(){
		return japaneseLabel.getText();
	}
	
	public void clickDisplayAndFocusOnLayoutButton(){
		displayAndFocusOnLayoutButton.click();
	}
}
