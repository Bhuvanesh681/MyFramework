package com.framework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.framework.constants.FrameworkConstants;
import com.framework.exception.InvalidPathForException;

public final class ExcelUtils {

	private ExcelUtils() {

	}

	@SuppressWarnings("resource")
	public static List<Map<String,String>> getTestDetails(String sheetname){
		List<Map<String,String>> list=null;

		XSSFWorkbook workbook;

		try(FileInputStream fs=new FileInputStream(FrameworkConstants.getExcelPath())) {

			workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet=workbook.getSheet(sheetname);
			list=new ArrayList<Map<String,String>>();
			int lastrownum=sheet.getLastRowNum();
			int lastcolnum=sheet.getRow(0).getLastCellNum();
			Map<String,String> map=null;
			for(int i =1;i<=lastrownum;i++) {
				map=new HashMap<String,String>();
				for(int j=0;j<lastcolnum;j++) {
					String key=sheet.getRow(0).getCell(j).getStringCellValue();
					String value=sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}


		} catch (FileNotFoundException e) {
			throw new InvalidPathForException("Excel file you are trying to read is not found");
		} catch (IOException e) {
			throw new InvalidPathForException("some IO exception happened while trying to read excel file");
		}


		return list;

	}

}
