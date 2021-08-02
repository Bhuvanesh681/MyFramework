package com.framework.pages;

import org.openqa.selenium.By;

import com.Framwork.enums.WaitStrategy;

public class PolicyFormPage extends BasePage {
	private static By nextbtn=By.xpath("//span[@class='g-btn-text'][contains(.,'Next')]");
	
	public QuotePage redirectToQuotePage() {
		click(nextbtn, WaitStrategy.PRESENCE, "Next Button");
		return new QuotePage();
		
	}

}
