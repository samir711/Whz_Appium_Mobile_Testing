package com.appium.maven.mobile.hybrid;

import com.appium.maven.mobile.hybrid.util.Constants;

public class GenericKeyword {
	
public String openapp() {
		
		System.out.println("Opening app");
		return Constants.PASS;
	}
	
	public String click() {
		System.out.println("click");
		return Constants.PASS;
		
	}
	
	public String type() {
		System.out.println("type");
		return Constants.PASS;
		
	}
	
	public String verifyTest() {
		System.out.println("verify test");
		return Constants.PASS;
		
	}
	
	public String closeapp() {
		System.out.println("Closing app");
		return Constants.PASS;
		
	}

}
