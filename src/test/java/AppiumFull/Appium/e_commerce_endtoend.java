package AppiumFull.Appium;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.ecommerce;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
public class e_commerce_endtoend extends base {
  @Test(dataProvider="InputData")
   public static void ecommmmmm(String name)  throws IOException, InterruptedException {
		AndroidDriver<AndroidElement>  driver;
		
		
		driver=capabilities("Device_type","Ecomm");
		ecommerce a12=new ecommerce(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		a12.country.click();
		//driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		utility a1=new utility(driver);
		a1.scrolltotext("Aruba");
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"));");
		driver.findElementByXPath("//*[@text='Aruba']").click();
		//driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("ankit");
		a12.namefield().sendKeys(name);
		driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().text(\"Jordan 6 Rings\"));");
	int count=driver.findElementsById("com.androidsample.generalstore:id/productName").size();
	for(int i=0;i<count;i++) {
		if (driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText().equalsIgnoreCase("Jordan 6 Rings")) {
			driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
		}
	}
	driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
	WebElement w1=driver.findElementById("com.androidsample.generalstore:id/termsButton");
	TouchAction t=new TouchAction(driver);
	t.longPress(longPressOptions().withElement(element(w1)).withDuration(ofSeconds(2))).release().perform();
	String error=driver.findElementById("android:id/message").getText();
	driver.findElementById("android:id/button1").click();    
	driver.findElementByXPath("//*[@text='Send me e-mails on discounts related to selected products in future']").click();
	driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
	Thread.sleep(4000);
	//get context
	Set<String> contexts=driver.getContextHandles();
	for(String context:contexts) {
		System.out.println(context);
	}
driver.context("WEBVIEW_com.androidsample.generalstore");
//	driver.findElement(By.name("q")).sendKeys("ankit");
	
	}
  @DataProvider(name="InputData")
  public Object[][] getdata() {
	  
	  Object[][] obj=new Object[][] {
		  {"ankit"},{"tripathi"}
	  };
	  return obj;
	  
  }
}
