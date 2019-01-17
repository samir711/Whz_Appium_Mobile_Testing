package com.appium.maven.mobile.hybrid;

import com.appium.maven.mobile.hybrid.util.Xls_Reader;

public class Driverscript {
	
	public static void main(String[] args) {
		
		String keywords_sheet = "keywords";
		String testUnderExecution = "TC1";
		AppKeywords keywords = new AppKeywords();
		
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//data//Data.xlsx");
		
		int rows = xls.getRowCount(keywords_sheet);
		System.out.println("rows are ::" + rows);
		
		for(int rNum=2;rNum<=rows;rNum++) {
			
			String tcid = xls.getCellData(keywords_sheet, "TCID", rNum);
			if(tcid.equalsIgnoreCase(testUnderExecution)) {
				String keyword = xls.getCellData(keywords_sheet, "keyword", rNum);
				String Object = xls.getCellData(keywords_sheet, "Object", rNum);
				String data = xls.getCellData(keywords_sheet, "Data", rNum);
	            System.out.println(tcid + "---"+ keyword + "---"+ Object+"---"+ data);
				if(keyword.equalsIgnoreCase("openapp")){
					keywords.openapp();
				}
				else if(keyword.equalsIgnoreCase("click")) {
					keywords.click();
					
				}
				else if(keyword.equalsIgnoreCase("verifyTest")) {
					keywords.verifyTest();
				}
				else if(keyword.equalsIgnoreCase("AddContatct")) {
					keywords.addContact();
					
				}
				else if(keyword.equalsIgnoreCase("closeapp")) {
					keywords.closeapp();
					
				}
			}
			
		}
		
	}

}
