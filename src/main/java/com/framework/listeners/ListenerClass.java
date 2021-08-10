package com.framework.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.annotations.FrameworkAnnotation;
import com.framework.reports.ExtentLogger;
import com.framework.reports.ExtentReport;
import com.framework.utils.EmailUtils;


public class ListenerClass implements ITestListener,ISuiteListener{

	public void onStart(ISuite suite) {
		
			ExtentReport.iniReports();
		
		
	}

	public void onFinish(ISuite suite) {
		
			ExtentReport.flushReports();
			
			EmailUtils.sendEmailReportWithAttachment("Bhuvanesh.Sikarwar@cfins.com", "July@181", "BhuvaneshSikarwar@gmail.com");
		
	}

	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
		.author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
		.category());
		
	}

	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+" is Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		
			ExtentLogger.fail(result.getMethod().getMethodName()+" is Failed",true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		
		
	}

	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+" is Skipped",true);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
