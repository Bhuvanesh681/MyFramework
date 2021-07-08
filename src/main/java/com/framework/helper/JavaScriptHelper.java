package com.framework.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.framework.driver.DriverManager;

public class JavaScriptHelper {

	//private Logger Log = Logger.getLogger(JavaScriptHelper.class);
	public static Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) DriverManager.getDriver();
		//Log.info(script);
		return exe.executeScript(script);
	}

	public static Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) DriverManager.getDriver();
		//Log.info(script);
		return exe.executeScript(script, args);
	}

	public void scrollToElemet(WebElement element) {
		executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
		//Log.info(element);
	}

	public void scrollToElemetAndClick(WebElement element) {
		scrollToElemet(element);
		element.click();
		//Log.info(element);
	}

	public static void scrollIntoView(WebElement element) {
		executeScript("arguments[0].scrollIntoView()", element);
		//Log.info(element);
	}

	public static void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		//Log.info(element);
	}

	public static void scrollDownVertically() {
		executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollUpVertically() {
		executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}

	public static void scrollDownByPixel(int pxl) {
		executeScript("window.scrollBy(0,"+pxl+")");
	}

	public static void scrollUpByPixel(int pxl) {
		executeScript("window.scrollBy(0,"+pxl+")");
	}

	public void ZoomInBypercentage() {
		executeScript("document.body.style.zoom='40%'");
	}

	public void ZoomBy100percentage() {
		executeScript("document.body.style.zoom='100%'");
	}
	
	public static void buttonClickUsingJS(WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
}
