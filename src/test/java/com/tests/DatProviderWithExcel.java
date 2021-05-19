package com.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DatProviderWithExcel {

	@Test(dataProvider="getData1")
	public void test2(Map<String,String> map) {
		System.out.println(map.get("username"));

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/Test.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("testing");
		int rownum=sheet.getLastRowNum();
		int colnum=sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[rownum][colnum];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colnum;j++) {
				data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;

	}
	
	@DataProvider
	public Object[] getData1() throws IOException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/Test.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=workbook.getSheet("testing");
		
		int rownum=sheet.getLastRowNum();
		int colnum=sheet.getRow(0).getLastCellNum();
		
		Object[] data=new Object[rownum];
		Map<String,String> map;
		
		for(int i=1;i<=rownum;i++) {
			map=new HashedMap<String,String>();
			for(int j=0;j<colnum;j++) {
				String key=sheet.getRow(0).getCell(j).getStringCellValue();
				String value=sheet.getRow(i).getCell(j).getStringCellValue();
				map.put(key, value);
				
				data[i-1]=map;
			}
		}
		return data;

	}
}
