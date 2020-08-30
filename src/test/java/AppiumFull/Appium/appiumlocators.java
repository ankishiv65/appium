package AppiumFull.Appium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.APIdemos;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class appiumlocators extends base {
	
	
	@Test
	public void locator() throws IOException, InterruptedException{
		//service=startserver();
	AndroidDriver<AndroidElement>  driver;
	
	driver=capabilities("Device_type","APIdemo");
	APIdemos a1=new APIdemos(driver);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	a1.Preference.click();
	a1.Preference_dependencies().click();
	driver.findElementById("android:id/checkbox").click();
	//2 ways to handle duplicate 
	driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
	//driver.findElementsByClassName("//android.widget.RelativeLayout").get(2).click();
	driver.findElementById("android:id/edit").sendKeys("Ankit");
	driver.findElementById("android:id/button1").click();
	//ui automator
	//driver.findElementByAndroidUIAutomator("attribute(\"value"\)");
	//Assert.assertTrue(false);
	//service.stop();
	
}
}
