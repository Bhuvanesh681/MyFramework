package com.framework.pages;

import org.openqa.selenium.By;

import com.Framwork.enums.WaitStrategy;

public class DCTHomePage extends BasePage{
	
	private static By newquotelnk=By.xpath("//span[@class='mainActionsCaption' and text()='New Quote']");
	
	public DCTNewQuotePage goToNewQuotePage() {
		click(newquotelnk, WaitStrategy.CLIKABLE, "New Quote Link on Home Page");
		return new DCTNewQuotePage();
	}

}
