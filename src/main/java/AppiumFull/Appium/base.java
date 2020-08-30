package AppiumFull.Appium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement>  driver;
	
	public static AppiumDriverLocalService startserver() {
		boolean flag=checkIfServerIsRunnning(4723);
		if(flag!=true)
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		return service;
	}
	
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
public static void start_emulator() throws IOException, InterruptedException {
	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\emulator.bat");
    Thread.sleep(6000);
}
public static void getscreenshot(String s) throws IOException {
	
	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
	
}	
public static AndroidDriver<AndroidElement> capabilities(String devicetype,String appname) throws IOException, InterruptedException {
	System.out.println(appname);
	 
	
	
	Properties prop=new Properties();
	
	FileInputStream f1=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\AppiumFull\\Appium\\global.properties");
   prop.load(f1);
	// TODO Auto-generated method stub
// File appDir = new File("src");
// File app = new File(appDir, "ApiDemos-debug.apk");
 DesiredCapabilities capabilities = new DesiredCapabilities();
 String device=prop.getProperty("Device");
 //String devicetypee=prop.getProperty(devicetype);
 String devicetypee=System.getProperty("devicetype");
 String appnamee=prop.getProperty(appname);
 System.out.println(appnamee);
 if (devicetypee.equalsIgnoreCase("Real")){
 capabilities.setCapability("deviceName", device );
 capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
 capabilities.setCapability("udid","4588a8e87d29");//extracted from cmd -adb devices
 capabilities.setCapability("platformName","Android");
//capabilities.setCapability("platformVersion","Android");
 if (appnamee.equalsIgnoreCase("ecomm")) {
	 capabilities.setCapability("appPackage","com.androidsample.generalstore");
	 
	 capabilities.setCapability("appActivity","com.androidsample.generalstore.SplashActivity");
 }else if(appnamee.equalsIgnoreCase("apidemo")) {
	 capabilities.setCapability("appPackage","io.appium.android.apis");
	 
	 capabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");
 }
 


 } else if(devicetypee.equalsIgnoreCase("Emulator")) {
	 File appDir = new File("src");
     File app = new File(appDir, "ApiDemos-debug.apk");
    
     
     capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
     capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
   
     start_emulator();
	  
 }
 driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
 return driver;
	}

}
