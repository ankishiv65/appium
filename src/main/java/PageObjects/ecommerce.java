package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ecommerce {
	AndroidDriver<AndroidElement> driver;
	public ecommerce(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	public WebElement country;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement namefield;
	
	public WebElement namefield() {
		return namefield;
	}
}
