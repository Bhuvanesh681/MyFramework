package com.framework.pages;

import org.openqa.selenium.By;

import com.Framwork.enums.WaitStrategy;

public class OrangeHRMHomePage extends BasePage {

	private final By link_welcome=By.id("welcome");
	private final By link_logout=By.xpath("//a[text()='Logout']");

	public OrangeHRMHomePage clickWelcome() {
		click(link_welcome,WaitStrategy.PRESENCE,"Welcome Link");
		
		return this;
	}

	public OrangeHRMLoginPage clickLogout() {
		//Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		click(link_logout,WaitStrategy.CLIKABLE,"Logout Link");
		return new OrangeHRMLoginPage();
	}

}
