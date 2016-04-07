package screens.android;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetElementText;
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
	//sdewrkwefjkhsdkfhksdhfksdjfhsdfffffffffffffffffffffffffffffffffffffffffffffffffffff
	@FindBy(how=How.ID,using="message") 
	WebElement waitingDialogHeaderProgressBar;
	
	@FindBy(how=How.ID,using="progress") 
	WebElement progressBar;
	
	@FindBy(how=How.ID,using="progress_percent") 
	WebElement progressPercentProgressBar;
	
	@FindBy(how=How.ID,using="progress_number") 
	WebElement progressNumberProgressBar;
	
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
		return getElementText(pageTitle);
	}
	
	public String getPageHeader(){
		return  getElementText(pageHeader);
	}
	
	public String getPageLabelLocalizationText(){
		return getElementText(pageLabelLocalization);
	}
	
	public String getENButtonText(){
		return getElementText(enButton);
	}
	
	public void clickEnButton(){
		clickElement(enButton);
	}
	
	public boolean isEnButtonConfirmationLabelDisplayed(){
		return isElementDisplayed(enButtonConfirmationLabel);
	}
	
	public String getEnButtonConfirmationLabelText(){
		return getElementText(enButtonConfirmationLabel);
	}
	
	public void clickEnButtonConfirmationAgreeButton(){
		clickElement(enButtonConfirmationAgreeButton);
	}
	
	public String getEnButtonConfirmationAgreeButtonText(){		
		return getElementText(enButtonConfirmationAgreeButton);
	}
	
	public void clickEnButtonConfirmationNoButton(){
		clickElement(enButtonConfirmationNoButton);
	}
	
	public String getEnButtonConfirmationNoButtonText(){
		return getElementText(enButtonConfirmationNoButton);
	}
	
	public void clickChromeButton(){
		clickElement(chromeButton);
	}
	
	public void clickUserRegisterationButton(){
		clickElement(userRegisterationButton);
	}
	
	public void enterTextInMyTextField(String text){
		EnterText(myTextField, text);
	}
	
	public String getTextMyTextField(){
		return getElementText(myTextField);
	}
	
	public void clickShowProgressBarForAWhileButton(){
		clickElement(showProgressBarForAWhileButton);
	}
	
	public String getTextshowProgressBarForAWhileButton(){
		return getElementText(showProgressBarForAWhileButton);
	}
	
	public String getTextProgressDialogHeader(){
		return getElementText(waitingDialogHeaderProgressBar);
	}
	
	public boolean isProgressBarDisplayed(){
		return isElementDisplayed(progressBar);
	}
	
	public String getTextProgressPercent(){
		return getElementText(progressPercentProgressBar);
	}
	
	public String getTextProgressNumber(){
		return getElementText(progressNumberProgressBar);
	}
	
	public void clickiIAcceptAddsCheckbox(){
		clickElement(iAcceptAddsCheckbox);
	}
	
	public String getIAcceptAddsCheckboxText(){
		return getElementText(iAcceptAddsCheckbox);
	}
	
	public boolean isIAcceptAddsCheckboxSelected(){
		return isCheckBoxSelected(iAcceptAddsCheckbox);
	}
	
	public void clickDisplayTextViewButton(){
		clickElement(displayTextViewButton);
	}
	
	public void clickDisplaysAToastButton(){
		clickElement(displaysAToastButton);
	}
	
	public void clickDisplayPopUpWindowButton(){
		clickElement(displayPopUpWindowButton);
	}
	
	public void clickPressToThrowUnhandledExceptionButton(){
		clickElement(pressToThrowUnhandledExceptionButton);
	}
	
	public void enterTextTypeToThrowExceptionTextField(String text){
		EnterText(typeToThrowExceptionTextField, text);
	}
	
	public String getTextJapaneseLabel(){
		return getElementText(japaneseLabel);
	}
	
	public void clickDisplayAndFocusOnLayoutButton(){
		clickElement(displayAndFocusOnLayoutButton);
	}
}
