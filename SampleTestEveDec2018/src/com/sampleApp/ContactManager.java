package com.sampleApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ContactManager {
	
public static AndroidDriver<MobileElement> driver;
	
	@Test
	public void testApp() throws MalformedURLException, InterruptedException {
		
       File app = new File("D:\\WhizdomTraining_OnlneClass_Appium\\WhizdomApk\\ContactManager.apk");
		
	//	File app = new File("Apk/ContactManager.apk");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "virusnet-mate82");
		caps.setCapability("uid", "VKN7N15C29029254");
		caps.setCapability("platformName", "Android");
		caps.setCapability("plaformVersion", "8.0");
		caps.setCapability("autoGrantPermissions", "false");
		caps.setCapability("noReset", "true");
		caps.setCapability("app", app.getAbsolutePath());;
		
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
		
		 // implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Show Invisible Contacts (Only)").click();
        Thread.sleep(3000);
        String src = driver.getPageSource();
        System.out.println("Src is :: " + src);
  	
	}
	
	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}

}
