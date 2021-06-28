package com.framework.pages;

import org.openqa.selenium.By;

import com.Framwork.enums.WaitStrategy;

public class DCTNewQuotePage extends BasePage{

	private By selectentitydropdown=By.xpath("//input[@fieldref='data.AgencyID']");
	private By selectlineofbusinessdropdown=By.xpath("//input[@placeholder='(Select Line of Business)']");
	private By startanewquotebtn=By.xpath("//span[contains(.,'Start New Quote')]");
	private By productnumber=By.xpath("//input[@fieldref='PolicyInput.ProductNumber']");
	private By effectivedate=By.xpath("//input[@fieldref='PolicyInput.EffectiveDate']");

	public DCTNewQuotePage selectEntity(String entityType) {
		

		sendKeysWithoutClick(selectentitydropdown, entityType, WaitStrategy.PRESENCE, "Entity drop down");
		return this;
	}
	
	public DCTNewQuotePage enterProductNumber(String productNumber) throws InterruptedException {
		
		sendKeysWithEnter(effectivedate, productNumber, WaitStrategy.PRESENCE, "Product Number Test box");
		return this;
	}
	
	public DCTNewQuotePage entereffectivedate(String effectivedate) throws InterruptedException  {
		
		sendKeysWithEnter(productnumber, effectivedate, WaitStrategy.PRESENCE, "Effective date calender field");
		return this;
	}

	public DCTNewQuotePage selectLOB(String LOB){
		
		sendKeysWithEnterUsingKeyboard(selectlineofbusinessdropdown, LOB, WaitStrategy.NONE, "LOB drop down");
		return this;
	}

	public QuickQuotePage clickonNewQuoteBtn() {
		//JavascriptExecutor executor1 = (JavascriptExecutor) DriverManager.getDriver();
		//executor1.executeScript("arguments[0].click();", startanewquotebtn);
		click(startanewquotebtn, WaitStrategy.PRESENCE, "Start a new quote button");
		return new QuickQuotePage();
	}



}
