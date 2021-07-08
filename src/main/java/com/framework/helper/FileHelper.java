package com.framework.helper;

import org.openqa.selenium.WebElement;

public class FileHelper {
	
	/*
	 * browserButton should be a input type
	 * BrowserButton should have attribute Type =File
	 * fileapth should contain path upto file.
	 */
	public static void uploadFile(WebElement browserButton, String filepath) {
		
		browserButton.sendKeys(filepath);
		
	}

}
