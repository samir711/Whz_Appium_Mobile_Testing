package com.sampleApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class SimpleTouchAction {

	public static AndroidDriver<MobileElement> driver;

	@SuppressWarnings("deprecation")
	@Test
	public void testApp() throws MalformedURLException, InterruptedException {

		// with apk
		// no apk mode
		File app = new File("Apk/CarDekho.apk");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "virusnet-mate82");
		caps.setCapability("uid", "VKN7N15C29029254");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.0.0");
		caps.setCapability("app", app.getAbsolutePath());
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("noReset", "false");
	

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("com.girnarsoft.cardekho:id/tv_used_car")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"2 - 5 Lakh\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("com.girnarsoft.cardekho:id/edit_text_search")).sendKeys("Pune");
		Thread.sleep(5000);
	//	driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		/*
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		or
		
		*
		*/
		
		//driver.swipe();
		//new TouchAction<>(driver).longPress(longPressOptions).moveTo().release
		
		
		Thread.sleep(4000);
	
		//if pressX was zero it didn't work for me
	    int pressX = driver.manage().window().getSize().width / 2;
	    // 4/5 of the screen as the bottom finger-press point
	    int bottomY = driver.manage().window().getSize().height * 4/5;
	    // just non zero point, as it didn't scroll to zero normally
	    int topY = driver.manage().window().getSize().height / 8;

			TouchAction action = new TouchAction (driver);
			action.press (PointOption.point(pressX, bottomY))
			    .moveTo (PointOption.point(pressX, topY))
			    .release ()
			    .perform ();
			Thread.sleep(5000);
			
			MobileElement e1=driver.findElement(By.className("android.view.ViewGroup"));
			action.tap(TapOptions.tapOptions().withElement (ElementOption.element(e1))).perform ();
			Thread.sleep(5000);
					
	}

	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}

}
