package com.framework.reports;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.framework.constants.FrameworkConstants;

public final class ExtentReport {
	private static ExtentReports extent;
	

	private ExtentReport() {

	}

	public static void iniReports() throws Exception {
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark=new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("My Report");
			spark.config().setReportName("My new Framework");
		}
	}


	public static void flushReports() throws Exception {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
	}


	public static void createTest(String testcasename) {
		ExtentTest test=extent.createTest(testcasename);
		ExtentManager.setExtentTest(test);
	}
}
