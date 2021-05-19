package com.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.pages.OrangeHRMLoginPage;
import com.framework.reports.ExtentReport;


public class OrangeHRMTest extends BaseTest{
	private OrangeHRMTest() {

	}

	@Test(dataProvider="LoginTestDataProvider")
	public void loginLogoutTest(String username,String password) {
		ExtentReport.createTest("loginLogoutTest");
		String title=new OrangeHRMLoginPage()
				.enterUserName(username).enterPassword(password)
				.clickLogin().clickWelcome().clickLogout()
				.getTitle();
		
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");

	}
	
	@Test(dataProvider="LoginTestDataProvider")
	public void newTest(String username,String password) {
		ExtentReport.createTest("loginLogoutTest");
		String title=new OrangeHRMLoginPage()
				.enterUserName(username).enterPassword(password)
				.clickLogin().clickWelcome().clickLogout()
				.getTitle();
		
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");

	}
	
	@DataProvider(name="LoginTestDataProvider",parallel=true)
	public Object[][] getData(){
		return new Object[][] {
			{"Admin","admin123"}
			
			
		};
	}

}
