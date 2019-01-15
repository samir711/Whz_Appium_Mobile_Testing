package com.touchevent;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;



public class DragSort {
	public static AndroidDriver<MobileElement> driver;
	
	@Test
	public void testApp() throws MalformedURLException, InterruptedException {
		
       File app = new File("Apk/Drag Sort Demos_v0.5.0_apkpure.com.apk");
		
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
        driver.findElement(By.id("com.mobeta.android.demodslv:id/activity_title")).click();
		Thread.sleep(5000);
		List<MobileElement> dragSections=driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle"));
		List<MobileElement> names=driver.findElements(By.id("com.mobeta.android.demodslv:id/text"));
		MobileElement e1=dragSections.get(0);
		MobileElement e2=dragSections.get(3);
		
		TouchAction action=new TouchAction<>(driver);
		
		action.longPress(longPressOptions()
                .withElement(element(e1))
                .withDuration(ofSeconds(5)))
                .moveTo(element(e2))
                .release().perform();
		
		
		Thread.sleep(5000);
  	
	}
	
	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}


}
