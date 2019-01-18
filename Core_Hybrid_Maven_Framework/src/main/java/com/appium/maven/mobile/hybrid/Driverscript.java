package com.appium.maven.mobile.hybrid;

import com.appium.maven.mobile.hybrid.util.Constants;
import com.appium.maven.mobile.hybrid.util.Xls_Reader;

public class Driverscript {
	
	public static void main(String[] args) {
		
		String keywords_sheet = "keywords";
		String testUnderExecution = "TC1";
		AppKeywords appKeyword = new AppKeywords();
		
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//data//Data.xlsx");
		
		int rows = xls.getRowCount(keywords_sheet);
		System.out.println("rows are ::" + rows);
		
		for(int rNum=2;rNum<=rows;rNum++) {
			
			String tcid = xls.getCellData(keywords_sheet, Constants.TCID_COL, rNum);
			if(tcid.equalsIgnoreCase(testUnderExecution)) {
				String keyword = xls.getCellData(keywords_sheet, Constants.KEYWORD_COl, rNum);
				String Object = xls.getCellData(keywords_sheet,Constants.OBJECT_COl, rNum);
				String data = xls.getCellData(keywords_sheet, Constants.DATA_COl, rNum);
	            System.out.println(tcid + "---"+ keyword + "---"+ Object+"---"+ data);
				String result = "";
	            if(keyword.equalsIgnoreCase("openapp")){
					result = appKeyword.openapp();
				}
				else if(keyword.equalsIgnoreCase("click")) {
					result = appKeyword.click();
					
				}
				else if(keyword.equalsIgnoreCase("type")) {
					result = appKeyword.type();
					
				}
				else if(keyword.equalsIgnoreCase("verifyTest")) {
					result = appKeyword.verifyTest();
				}
				else if(keyword.equalsIgnoreCase("AddContatct")) {
					result = appKeyword.addContact();
					
				}
				else if(keyword.equalsIgnoreCase("closeapp")) {
					result = appKeyword.closeapp();
					
				}
	            System.out.println("result is :: " + result);
			}
			
		}
		
	}

}
