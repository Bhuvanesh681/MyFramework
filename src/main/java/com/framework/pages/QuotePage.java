package com.framework.pages;

import org.openqa.selenium.By;

import com.Framwork.enums.WaitStrategy;
import com.framework.helper.JavaScriptHelper;

public class QuotePage extends BasePage{
	//underwriter information
	private static By name=By.xpath("//input[@fieldref='PolicyInput.Name']");
	private static By title=By.xpath("//input[@fieldref='PolicyInput.Title']");
	private static By streetaddress=By.xpath("//textarea[@fieldref='PolicyInput.Address']");
	private static By city=By.xpath("//input[@fieldref='PolicyInput.City']");
	private static By state=By.xpath("//input[@fieldref='PolicyInput.State']");
	private static By zip=By.xpath("//input[@fieldref='PolicyInput.Zipcode']");
	private static By phonenumber=By.xpath("//input[@fieldref='PolicyInput.Phone']");
	private static By email=By.xpath("//input[@fieldref='PolicyInput.Email']");
	private static By nextbtn=By.xpath("//span[@class='g-btn-text'][contains(.,'Next')]");
	
	public BindPage goToBindPage() throws InterruptedException {
		Thread.sleep(2000);
		JavaScriptHelper.scrollDownVertically();
		Thread.sleep(2000);
		click(nextbtn, WaitStrategy.CLIKABLE, "Next Button");
		Thread.sleep(5000);
		return new BindPage();
	}

}
