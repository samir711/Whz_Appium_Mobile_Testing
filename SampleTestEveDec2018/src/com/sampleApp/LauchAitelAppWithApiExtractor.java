package com.sampleApp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LauchAitelAppWithApiExtractor {
	
	public static AndroidDriver<MobileElement> driver;
	
	@Test
	public void LauchAirtelApp() throws MalformedURLException, InterruptedException {
		
		String apkAirtelMoneyPath = "Apk/Airtel Money_com.airtel.money.apk";
		String apkAajTakPath = "Apk/Aaj Tak_in.AajTak.headlines.apk";
		
		//File app = new File(apkAirtelMoneyPath);
		File app = new File(apkAajTakPath);
		
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "virusnet-mate82");
		caps.setCapability("uid", "VKN7N15C29029254");
		caps.setCapability("platformName", "Android");
		caps.setCapability("plaformVersion", "8.0");
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("noReset", "true");
		
        caps.setCapability("app", app.getAbsolutePath());;
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
		
		Thread.sleep(4000);
	}
	
	@AfterTest
	public void quit() {
		driver.quit();
	}
	

}
