package com.framework.helper;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.driver.DriverManager;


public class AlertHelper {

	public static boolean isAlertPresent() {
		try {
			DriverManager.getDriver().switchTo().alert();

			return true;
		} catch (NoAlertPresentException e) {
			// Ignore

			return false;
		}
	}

	// Accept an alert
	public static void acceptAlert(int EXPLICIT_WAIT_TIME) {

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), EXPLICIT_WAIT_TIME);
			wait.until(ExpectedConditions.alertIsPresent());
			DriverManager.getDriver().switchTo().alert().accept();
		} catch (NoAlertPresentException | TimeoutException e) {
			System.out.println("Exception in handlign the Alert:" + e);
		}

	}

	// Dismiss an alert
	public static void dismissAlert(int EXPLICIT_WAIT_TIME) {

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), EXPLICIT_WAIT_TIME);
			wait.until(ExpectedConditions.alertIsPresent());
			DriverManager.getDriver().switchTo().alert().dismiss();
		} catch (NoAlertPresentException | TimeoutException e) {
			System.out.println("Exception in handlign the Alert:" + e);
		}

	}

	// Read an Alert Message
	public static String readAlertMessage(int EXPLICIT_WAIT_TIME) {

		String alertText = null;
		;

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), EXPLICIT_WAIT_TIME);
			wait.until(ExpectedConditions.alertIsPresent());
			alertText = DriverManager.getDriver().switchTo().alert().getText();
		} catch (NoAlertPresentException | TimeoutException e) {
			System.out.println("Exception in handlign the Alert:" + e);
		}

		return alertText;
	}

	// Send Text Message to alert

	public static void sendMessage(String message, int EXPLICIT_WAIT_TIME) {

		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), EXPLICIT_WAIT_TIME);
			wait.until(ExpectedConditions.alertIsPresent());
			DriverManager.getDriver().switchTo().alert().sendKeys(message);
			;

		} catch (NoAlertPresentException | TimeoutException e) {
			System.out.println("Exception in handlign the Alert:" + e);
		}
	}

}
