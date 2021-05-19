package com.framework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.framework.constants.FrameworkConstants;

public final class ExcelUtils {

	private ExcelUtils() {

	}

	public static List<Map<String,String>> getTestDetails(){
		List<Map<String,String>> list=null;
		FileInputStream fs = null;
		XSSFWorkbook workbook;
		try {
			fs=new FileInputStream(FrameworkConstants.getExcelPath());
			workbook = new XSSFWorkbook(fs);
			String sheetname="RUNMANAGER";
			XSSFSheet sheet=workbook.getSheet(sheetname);
			
			Map<String,String> map=null;
			list=new ArrayList<Map<String,String>>();
			int lastrownum=sheet.getLastRowNum();
			int lastcolnum=sheet.getRow(0).getLastCellNum();

			for(int i =1;i<=lastrownum;i++) {
				map=new HashMap<String,String>();
				for(int j=0;j<lastcolnum;j++) {
					String key=sheet.getRow(0).getCell(j).getStringCellValue();
					String value=sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(Objects.nonNull(fs)) {
				fs.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;

	}

}
