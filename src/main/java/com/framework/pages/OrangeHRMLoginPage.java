package com.framework.pages;

import org.openqa.selenium.By;

import com.Framwork.enums.WaitStrategy;

public class OrangeHRMLoginPage extends BasePage {


	private final By textbox_username= By.id("txtUsername");
	private final By textbox_password= By.xpath("//input[@id='txtPassword'  and @type='password']");
	private final By button_login= By.id("btnLogin");

	public OrangeHRMLoginPage enterUserName(String username) {
		sendKeys(textbox_username, username,WaitStrategy.PRESENCE,"UserNmae text box");
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(textbox_password, password,WaitStrategy.PRESENCE,"Password TextBox");
		return this;
	}

	public OrangeHRMHomePage clickLogin() {
		click(button_login,WaitStrategy.PRESENCE,"Login Button");
		return new OrangeHRMHomePage();
	}

	public String getTitle() {
		return getPageTitle();
	}
	

}
