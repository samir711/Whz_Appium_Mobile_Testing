package com.appium.maven.mobile.hybrid;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.appium.maven.mobile.hybrid.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestInc {
	private Driverscript ds;
	private ExtentReports report;
	private ExtentTest test;

	// CTRL+SHIFT+F ---> to align code
	@Test
	public void testApp() {
		
		report = ExtentManager.getInstance();
		test = report.startTest("TestInc");
		test.log(LogStatus.INFO, "Strting the Test");
		ds = new Driverscript(test);
		try {
			ds.executekeyword("TC2");
		} catch (MalformedURLException e) {
		
			e.printStackTrace();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Ending the test");

	}

	@AfterMethod
	public void quit() {
		if(null!=ds)
			ds.getKeywords().closeapp();	
		if(null!=report && null!=test) {
		report.endTest(test);
		report.flush();
		}
	   
		
	}

}
