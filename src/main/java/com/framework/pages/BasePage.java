package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.Framwork.enums.WaitStrategy;
import com.framework.driver.DriverManager;
import com.framework.factories.ExplicitWaitFactory;
import com.framework.reports.ExtentLogger;

public class BasePage {
	protected void click(By by, WaitStrategy waitstrategy,String elementname) {
		ExplicitWaitFactory.performExplicitWait(waitstrategy, by).click();
		try {
			ExtentLogger.pass(elementname+ " is clicked",true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	protected void sendKeys(By by, String value, WaitStrategy waitstrategy,String elementname) {
		ExplicitWaitFactory.performExplicitWait(waitstrategy, by).sendKeys(value);
		try {
			ExtentLogger.pass(value +" is entered successfully in "+elementname,true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void sendKeysWithoutClick(By by, String value, WaitStrategy waitstrategy,String elementname)  {
		
		ExplicitWaitFactory.performExplicitWait(waitstrategy, by).sendKeys(value,Keys.TAB);
		try {
			ExtentLogger.pass(value +" is entered successfully in "+elementname,true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void sendKeysWithEnter(By by, String value, WaitStrategy waitstrategy,String elementname) throws InterruptedException  {
		Thread.sleep(1000);
		DriverManager.getDriver().findElement(by).click();
		Thread.sleep(1000);
		ExplicitWaitFactory.performExplicitWait(waitstrategy, by).sendKeys(value,Keys.TAB);
		try {
			ExtentLogger.pass(value +" is entered successfully in"+elementname,true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void clearandsendKeys(By by, String value, WaitStrategy waitstrategy,String elementname) throws InterruptedException  {
		Thread.sleep(1000);
		DriverManager.getDriver().findElement(by).clear();
		Thread.sleep(1000);
		DriverManager.getDriver().findElement(by).click();
		Thread.sleep(1000);
		ExplicitWaitFactory.performExplicitWait(waitstrategy, by).sendKeys(value,Keys.TAB);
		try {
			ExtentLogger.pass(value +" is entered successfully in"+elementname,true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void clearandsendKeyswithWebElement(WebElement ele, String value, WaitStrategy waitstrategy,String elementname) throws InterruptedException  {
		ele.click();
		Thread.sleep(500);
		ele.clear();
		//Thread.sleep(1000);
		//ele.click();
		Thread.sleep(500);
		ele.sendKeys(value);
		try {
			ExtentLogger.pass(value +" is entered successfully in"+elementname,true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void sendKeyswithWebElement(WebElement ele, String value, WaitStrategy waitstrategy,String elementname) throws InterruptedException  {
		
		ele.click();
		Thread.sleep(1000);
		ele.sendKeys(value);
		try {
			ExtentLogger.pass(value +" is entered successfully in"+elementname,true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
protected void sendKeysWithEnterUsingKeyboard(By by, String value, WaitStrategy waitstrategy,String elementname)  {
		
		ExplicitWaitFactory.performExplicitWait(waitstrategy, by).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.RETURN);
		try {
			ExtentLogger.pass(value +" is entered successfully in"+elementname,true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	


}
