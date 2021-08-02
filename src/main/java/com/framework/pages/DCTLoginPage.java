package com.framework.pages;

import org.openqa.selenium.By;

import com.Framwork.enums.WaitStrategy;

public class DCTLoginPage extends BasePage{

	private final By username_txtbx=By.id("username-inputEl");
	private final By password_txtbx=By.id("password-inputEl");
	private final By login_btn=By.xpath("//span[text()='Login']");

	public DCTLoginPage enterUserName(String username) {
		sendKeys(username_txtbx, username, WaitStrategy.PRESENCE, "User Name texbox field");
		return this;
	}

	public DCTLoginPage enterPassword(String password) {
		sendKeys(password_txtbx, password, WaitStrategy.PRESENCE, "Password texbox field");
		return this;
	}

	public DCTHomePage clickOnLogin() {
		click(login_btn, WaitStrategy.CLIKABLE, "Login button");
		return new DCTHomePage();
	}


}
