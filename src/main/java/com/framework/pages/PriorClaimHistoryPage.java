package com.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Framwork.enums.WaitStrategy;
import com.framework.driver.DriverManager;
import com.framework.helper.JavaScriptHelper;

public class PriorClaimHistoryPage extends BasePage {

	//Prior Claim History fields

	private static By priorclaimlossdatecal=By.xpath("//input[@fieldref='LossInput.DateOfLoss']");
	private static By totalincurredtxt=By.xpath("//input[@fieldref='LossInput.AmountPaid']");
	private static By priorclaimhistorystatusselect=By.xpath("//input[@fieldref='LossInput.Status']");
	private static By yearsofpriorcoveragetxtbx=By.xpath("//input[@fieldref='LineInput.YearsOfPriorCoverage']");
	private static By noofclaimstxtbx=By.xpath("//input[@fieldref='LineInput.NumberOfClaims']");
	private static By totallossincurredtxtbx=By.xpath("//input[@fieldref='LineInput.TotalLoss']");
	private static By lossratiodrpdwn=By.xpath("//input[@fieldref='LineInput.LossRatio']");
	private static By claimhistorycommenttxtarea=By.xpath("//textarea[@fieldref='LineInput.ClaimComments']");
	private static By priorclainaddbtn=By.xpath("(//span[@class='g-btn-text'][contains(.,'ADD')])[1]");
	private static By nextbtn=By.xpath("//span[@class='g-btn-text'][contains(.,'Next')]");
	
	//Method to enters all fields value in Prior Claim History Screen
	public CoveragePricingPage priorClaimHistory(String numberofclaims,String priorclaimlossdate,
			String priorclaimamotpaid,String priorclaimhistorystatus,String yearsofpriorcoverage,
			String claimhistorycomment) throws InterruptedException {
	JavaScriptHelper.scrollUpVertically();
		if(numberofclaims.equalsIgnoreCase("1")) {

			sendKeys(priorclaimlossdatecal, priorclaimlossdate, WaitStrategy.PRESENCE, "Prior Claim Loss date calender");
			sendKeysWithoutClick(totalincurredtxt, priorclaimamotpaid, WaitStrategy.PRESENCE, "Prior Claim amount paid field");
			clearandsendKeys(priorclaimhistorystatusselect, priorclaimhistorystatus, WaitStrategy.PRESENCE, "priorclaimhistorystatusselect");
		}else {
			addmultiplePriorClaims(numberofclaims,priorclaimlossdate,priorclaimamotpaid,priorclaimhistorystatus);
		}

		sendKeys(yearsofpriorcoveragetxtbx, yearsofpriorcoverage, WaitStrategy.PRESENCE, "yearsofpriorcoverage txt bx");
		sendKeys(claimhistorycommenttxtarea, claimhistorycomment, WaitStrategy.PRESENCE, "claim history comment text area");
		Thread.sleep(1000);
		JavaScriptHelper.scrollDownVertically();
		Thread.sleep(1000);
		click(nextbtn, WaitStrategy.CLIKABLE, "Next Button");
		Thread.sleep(3000);

		return new CoveragePricingPage();

	}

	private void addPriorClaim(String numberOfClaims) {
		int noofclaim=Integer.parseInt(numberOfClaims);
		while(noofclaim>0) {
			click(priorclainaddbtn, WaitStrategy.CLIKABLE, "Prior Claim Add Button");
			noofclaim--;
		}
	}
	private void addmultiplePriorClaims(String numberOfClaims,String priorclaimlossdate,String priorclaimamotpaid,
			String priorclaimhistorystatus) throws InterruptedException {
		int noofclaim=Integer.parseInt(numberOfClaims);
		while(noofclaim>1) {
			click(priorclainaddbtn, WaitStrategy.CLIKABLE, "Prior Claim Add Button");
			noofclaim--;
		}
		List<WebElement> list1 = DriverManager.getDriver().findElements(priorclaimlossdatecal);
		for(WebElement i:list1) {
		sendKeyswithWebElement(i, priorclaimlossdate, WaitStrategy.NONE, "Prior Claim Loss date calender");
		Thread.sleep(1000);
		}
		
		List<WebElement> list2 = DriverManager.getDriver().findElements(totalincurredtxt);
		for(WebElement j:list2) {
			sendKeyswithWebElement(j, priorclaimamotpaid, WaitStrategy.NONE, "Prior Claim amount paid field");
			Thread.sleep(1000);
		}
		List<WebElement> list3 = DriverManager.getDriver().findElements(priorclaimhistorystatusselect);
		for(WebElement k:list3) {
			sendKeyswithWebElement(k, priorclaimhistorystatus, WaitStrategy.NONE, "priorclaimhistorystatusselect");
			Thread.sleep(1000);
		}
		
		
	}


}
