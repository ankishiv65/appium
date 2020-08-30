package AppiumFull.Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class utility {
	AndroidDriver<AndroidElement>  driver;
	public utility(AndroidDriver<AndroidElement>  driver) {
		this.driver=driver;
	}
	
	public void scrolltotext(String text) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}

}
