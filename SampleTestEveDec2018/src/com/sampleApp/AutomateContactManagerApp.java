package com.sampleApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class AutomateContactManagerApp {
	
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
      //  Thread.sleep(3000);
        driver.findElementByAccessibilityId("Show Invisible Contacts (Only)").click();
//        Thread.sleep(5000);
//        driver.findElementByAccessibilityId("Show Invisible Contacts (Only)").click();
//        Thread.sleep(5000);
//        driver.findElementByAccessibilityId("Add Contact").click();
//        Thread.sleep(4000);
//        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys("abc");
//        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys("9844467743");
//        driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).sendKeys("abc@gmail.com");
//        Thread.sleep(2000);
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Add Contact");
        el1.click();
        Thread.sleep(2000);
        MobileElement el2 = (MobileElement) driver.findElementById("com.example.android.contactmanager:id/contactNameEditText");
        el2.click();
        el2.sendKeys("abc");
        MobileElement el3 = (MobileElement) driver.findElementById("com.example.android.contactmanager:id/contactPhoneEditText");
        el3.click();
        el3.sendKeys("9844467745");
        Thread.sleep(4000);

		
	}
	

	@AfterTest
	public void quit() {
		driver.quit();
	}

}
