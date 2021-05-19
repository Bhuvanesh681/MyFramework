package com.framework.reports;

import com.Framwork.enums.ConfigProperties;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.framework.utils.PropertyUtils;
import com.framework.utils.ScreenShotUtils;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void fail(String message, boolean isScreenShotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenShotNeeded) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}

	}

	public static void skip(String message, boolean isScreenShotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenShotNeeded) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}

	}

	public static void pass(String message, boolean isScreenShotNeeded) throws Exception {
		if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenShotNeeded) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}

	}

	
}