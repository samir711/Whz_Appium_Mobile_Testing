package com.sampleApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class Arch {
	public static AndroidDriver<MobileElement> driver;
	public static AndroidDriver<WebElement> dr2;
	public static AndroidDriver<AndroidElement> dr3;
	// CTRL+SHIFT+O to import data
	//ios specific
	public static IOSDriver<IOSElement> dr4;
	public static IOSDriver<WebElement> dr5;
	public static IOSDriver<MobileElement> dr6;
	
	@Test
	public void testApp() throws MalformedURLException, InterruptedException {
	    
		//File app = new File("D:\\WhizdomTraining_OnlneClass_Appium\\WhizdomApk\\ContactManager.apk");
			
	 	File app = new File("Apk/ContactManager.apk");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "virusnet-mate82");
		caps.setCapability("uid", "VKN7N15C29029254");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.0.0");
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("noReset", "true");
		caps.setCapability("app", app.getAbsolutePath());

		// Instantiate Appium Driver
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		//	dr3 = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	    //	dr2 = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			
			// ios specific
//			dr4 = new IOSDriver<IOSElement>(new URL(
//					"http://0.0.0.0:4723/wd/hub"), caps);
//			dr5 = new IOSDriver<WebElement>(new URL(
//					"http://0.0.0.0:4723/wd/hub"), caps);
//			dr6 = new IOSDriver<MobileElement>(new URL(
//					"http://0.0.0.0:4723/wd/hub"), caps);
			
			// implicit wait
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElementByAccessibilityId("Show Invisible Contacts (Only)").click();
			driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton")).click();
			Thread.sleep(4000);
			System.out.println(driver.isDeviceLocked());
			System.out.println(driver.isKeyboardShown());
	}
	
	@AfterTest
	public void quit() {
		driver.quit();
	}
}
