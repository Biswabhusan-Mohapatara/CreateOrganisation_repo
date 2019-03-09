package com.selenium.lib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtil {
	   String filepath="./data/commonData.properties";
		String excelpath="./data/testData.xlsx";
		
		
		public Properties getPropertyFileObject() throws Throwable {
		
		FileInputStream fis=new FileInputStream(filepath);
		Properties pObj=new Properties();
		pObj.load(fis);
		return pObj;
		}
		
		public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable 
		{
			FileInputStream fis=new FileInputStream(excelpath);
	     	Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheetName);
			String data=sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
			System.out.println(data);
			wb.close();
			return data;
				
	    }
		
		public void setExcelData(String sheetName,int rowNum,int cellNum,String data) throws Throwable {
			FileInputStream fis=new FileInputStream(excelpath);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(sheetName);
			sh.getRow(rowNum).createCell(cellNum).setCellValue(data);
			FileOutputStream fos=new FileOutputStream(excelpath);
			wb.write(fos);
			wb.close();
			
		}
		
}
