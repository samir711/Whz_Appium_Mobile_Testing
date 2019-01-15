package com.touchevent;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class MultiTouchDemo {
public static AndroidDriver<MobileElement> driver;
	
	
	@Test
	public void testApp() throws MalformedURLException, InterruptedException {
		//File app = new File("D:\\MobileAutomation\\Apks\\ScaleImageView.apk");
		File app = new File("Apk/ScaleImageView.apk");
		
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

		driver.findElement(	By.id("com.davemorrissey.labs.subscaleview.sample:id/basicFeatures")).click();
		MobileElement image = driver.findElement(By.id("com.davemorrissey.labs.subscaleview.sample:id/imageView"));
		
		int center_X=image.getLocation().getX()+(image.getSize().width/2);
		int center_Y=image.getLocation().getY()+(image.getSize().height/2);
		// driver.pinch(el);
		// driver.zoom(el);
		MultiTouchAction multiTouchAction = new MultiTouchAction(driver);
		
		TouchAction action1 = new TouchAction(driver);
		action1.press(point(center_X,center_Y-10)).moveTo(point(center_X,center_Y-200)).release();
		
		TouchAction action2 = new TouchAction(driver);
		action2.press(point(center_X,center_Y+10)).moveTo(point(center_X,center_Y+200)).release();
		
		multiTouchAction.add(action1).add(action2).perform();
		// xpath=//android.widget.TextView[@text='John']
		// Move is used for dragging and dropping whereas swipe is only used to
		// swipe the
		// screen down

	}

	@AfterTest
	public void quit() {
		driver.quit();
	}
}