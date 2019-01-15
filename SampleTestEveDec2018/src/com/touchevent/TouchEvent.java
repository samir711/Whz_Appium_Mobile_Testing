package com.touchevent;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.PointOption.point;

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



public class TouchEvent {
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
		MobileElement e2=dragSections.get(dragSections.size() -1);
		
		TouchAction action=new TouchAction<>(driver);
		
		action.longPress(longPressOptions()
                .withElement(element(e1))
                .withDuration(ofSeconds(5)))
                .moveTo(element(e2))
                .release().perform();
		
		System.out.println("----------------------");
		List<MobileElement> newNames=driver.findElements(By.id("com.mobeta.android.demodslv:id/text"));
		
		for(MobileElement element:newNames){
			System.out.println("newNames::"+element.getText());
		}
		
		
		TouchAction action1=new TouchAction(driver);
		
		MobileElement lastElement=dragSections.get(dragSections.size()-1);
		int x=lastElement.getLocation().getX();
		int y=lastElement.getLocation().getY();
		
		 while(true){
				
		    	List<MobileElement> allName=driver.findElements(By.id("com.mobeta.android.demodslv:id/text"));
		    	String topElement=allName.get(0).getText();
		    	System.out.println("topElement::"+topElement);
		    	//action1.longPress(lastElement).moveTo(x, y+100).release().perform();
		    	action1.longPress(longPressOptions()
		                .withElement(element(lastElement))
		                .withDuration(ofSeconds(5)))
		        .moveTo(point(x, y+50))
		        .release().perform();
		    	
		    	String newTopElement=allName.get(0).getText();
		    	System.out.println("newTopElement::"+newTopElement);
		    	if(newTopElement.equals(topElement))
		    		break;
		    }

	}
	
	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}


}
