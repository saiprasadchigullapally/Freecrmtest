package com.crm.qa.util;



import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=20;
	

	
	public static String TESTDATA_SHEET_PATH="E:\\myselenium\\freeCRMTest\\src\\main\\java\\com\\crm\\qa"
			              + "\\testdata\\freecrmtestdata.xlsx ";
	
	static Workbook book;
	static Sheet sheet;
	
	
	public void switchToFrame() {
		
		driver.switchTo().frame("mainpanel");
	}

	
	public static Object[][] getTestData(String sheetname) {
		
		FileInputStream file=null;
		
		try {
			file=new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			book=WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		sheet=book.getSheet(sheetname);
		
		Object data[][] =new Object [sheet.getLastRowNum()] [sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
	}
	
	public void takeScreenShotAtEndofTest() {
		
//		File scrfile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String currentDir=System.getProperty(" ");
//		FileUtils.copyFile(scrfile,new File(currentDir+"/screenshots"+System.currentTimeMillis()+".png"));
		
	}
	
}
