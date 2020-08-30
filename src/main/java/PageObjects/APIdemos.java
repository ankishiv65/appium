package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import AppiumFull.Appium.base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class APIdemos  {
	
	public APIdemos(AndroidDriver<AndroidElement>  driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	public WebElement Preference;
	
	@AndroidFindBy(xpath="//*[@text='3. Preference dependencies']")
	public WebElement Preference_dependencies;
	
	public WebElement Preference_dependencies() {
		return Preference_dependencies;
	}
	

}
