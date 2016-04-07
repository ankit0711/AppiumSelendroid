package base;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

//This class defines common methods that would be used frequently by the application.

public class CommonMethods {

	public AppiumDriver driver= TestBase.getDriver();


	
	//Used to navigate to home activity.
	public void goToHomeScreen(){
		
	}
	
	//This method takes a WebElement as argument and clicks on it.
	public void clickElement(WebElement element){
		element.click();
	}
	
	//This method takes a WebElement and a String as argument and enters the string in the WebElement.
	public void EnterText(WebElement element,String str){
		try{
			element.click();
			element.clear();
			element.sendKeys(str);
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
	}
	
	//This method takes a WebElement as argument and returns the text of the WebElement.
	public String getElementText(WebElement element){
		return element.getText();
	}
	
	//This method returns true if the web-element is displayed on page and returns false otherwise
	public boolean isElementDisplayed(WebElement element){
		try{
		if(element.isDisplayed())
			return true;
		else
			return false;
		}
		catch(NoSuchElementException e){
		return false;
		}
	}
	
	//This method takes a WebElement as argument and returns true if the check-box is selected,false otherwise.
	public boolean isCheckBoxSelected(WebElement element){
		if(getAttribute(element,"checked").equals("true"))
			   return true;
			 return false;
	}
	
	//This method takes a WebElement and String as argument and returns the elements argument as String.
	public String getAttribute(WebElement element,String attribute){
		return element.getAttribute(attribute);
	}
	
	public void switchFrame(){
		driver.switchTo().frame(0);
	}
	
	public void switchToDefaultContent(){
		driver.switchTo().defaultContent();
	}
}
