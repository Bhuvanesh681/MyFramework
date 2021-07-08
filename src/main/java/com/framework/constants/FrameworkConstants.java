package com.framework.constants;

import com.Framwork.enums.ConfigProperties;
import com.framework.utils.PropertyUtils;

public class FrameworkConstants {

	private FrameworkConstants(){

	}
	private static final String RESOURCEPATH=System.getProperty("user.dir")+"/src/test/resources";
	private static final String CONFIGFILEPATH=RESOURCEPATH+"/config/config.properties";
	private static final String EXCELPATH=RESOURCEPATH+"/excel/testdata.xlsx";
	private static final String RUNMANAGERSHEET="RUNMANAGER";
	private static final String ITERATIONDATASHEET="DATA";
	private static final String EXTENTREPORTPATH=System.getProperty("user.dir")+"/extent-test-output";
	private static String extentReportFilePath="";


	public static String getRunManagerSheet() {
		return RUNMANAGERSHEET;
	}

	public static String getIterationDataSheet() {
		return ITERATIONDATASHEET;
	}
	

	public static String getExcelPath() {
		return EXCELPATH;
	}

	public static String getExtentReportFilePath()  {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath=createReportPath();
		}
		return extentReportFilePath;
	}



	private static String createReportPath() {
		if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTPATH +"/"+System.currentTimeMillis()+"/index.html"; 
		}else {
			return EXTENTREPORTPATH +"/"+"index.html";
		}
	}


	private static final int EXPLICITWAIT= 10;

	public static int getExplicitWait() {
		return EXPLICITWAIT;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}


}
