package com.framework.pages;

import org.openqa.selenium.By;

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
