package com.sampleApp;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTestNg {
	
	@AfterTest
	public void printData4() {
		System.out.println("First Sample Code4");
	}
	
	@Test
	public void printData() {
		System.out.println("First Sample Code2");
	}
	
	@Test
	public void printData2() {
		System.out.println("First Sample Code1");
	}
	
	@BeforeTest
	public void printData3() {
		System.out.println("First Sample Code3");
	}

}
