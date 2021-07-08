package com.framework.pages;

import org.openqa.selenium.By;

import com.Framwork.enums.WaitStrategy;
import com.framework.helper.JavaScriptHelper;

public class PriorClaimHistoryPage extends BasePage {
	
	//Prior Claim History fields
		private static By yearsofpriorcoveragetxtbx=By.xpath("//input[@fieldref='LineInput.YearsOfPriorCoverage']");
		private static By noofclaimstxtbx=By.xpath("//input[@fieldref='LineInput.NumberOfClaims']");
		private static By totallossincurredtxtbx=By.xpath("//input[@fieldref='LineInput.TotalLoss']");
		private static By lossratiodrpdwn=By.xpath("//input[@fieldref='LineInput.LossRatio']");
		private static By claimhistorycommenttxtarea=By.xpath("//textarea[@fieldref='LineInput.ClaimComments']");

		private static By priorclainaddbtn=By.xpath("(//span[@class='g-btn-text'][contains(.,'ADD')])[1]");
		private static By priorclaimlossdatecal=By.xpath("//input[@fieldref='LossInput.DateOfLoss']");
		private static By priorclaimamountpaidtxt=By.xpath("//input[@fieldref='LossInput.AmountPaid']");
		private static By priorclaimhistorystatusselect=By.xpath("//input[@fieldref='LossInput.Status']");
		private static By priorclaimhistorycancelbtn=By.xpath("//a[@role='button'][contains(.,'X')]");
		
		//Method to enters all fields value in Prior Claim History Screen
		public PriorClaimHistoryPage priorClaimHistory(String yearsofpriorcoverage,String noofclaims,String totallossincurred,
				String lossratio,String claimhistorycomment,String numberofclaims,String priorclaimlossdate,
				String priorclaimamotpaid,String priorclaimhistorystatus) throws InterruptedException {
			//((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollBy(0,500)", "");
			JavaScriptHelper.scrollDownByPixel(500);
			sendKeys(yearsofpriorcoveragetxtbx, yearsofpriorcoverage, WaitStrategy.PRESENCE, "yearsofpriorcoverage txt bx");
			sendKeys(noofclaimstxtbx, noofclaims, WaitStrategy.PRESENCE, "noofclaimstxtbx txt bx");
			sendKeys(totallossincurredtxtbx, totallossincurred, WaitStrategy.PRESENCE, "totallossincurredtxtbx txt bx");
			sendKeysWithEnter(lossratiodrpdwn, lossratio, WaitStrategy.PRESENCE, "lossratiodrpdwn txt bx");
			sendKeys(claimhistorycommenttxtarea, claimhistorycomment, WaitStrategy.PRESENCE, "claim history comment text area");
			//click(priorclainaddbtn, WaitStrategy.CLIKABLE, "Prior Claim Add Button");
			if(numberofclaims.equalsIgnoreCase("one")) {
			addPriorClaim(numberofclaims);
			sendKeysWithoutClick(priorclaimlossdatecal, priorclaimlossdate, WaitStrategy.PRESENCE, "Prior Claim Loss date calender");
			sendKeysWithoutClick(priorclaimamountpaidtxt, priorclaimamotpaid, WaitStrategy.PRESENCE, "Prior Claim amount paid field");
			sendKeysWithoutClick(priorclaimhistorystatusselect, priorclaimhistorystatus, WaitStrategy.PRESENCE, "priorclaimhistorystatusselect");
			}else {
				addmultiplePriorClaims(numberofclaims);
			}
			
			return this;

		}
		
		private void addPriorClaim(String numberOfClaims) {
			int noofclaim=Integer.parseInt(numberOfClaims);
			while(noofclaim>0) {
			click(priorclainaddbtn, WaitStrategy.CLIKABLE, "Prior Claim Add Button");
			noofclaim--;
			}
		}
		private void addmultiplePriorClaims(String numberOfClaims) {
			int noofclaim=Integer.parseInt(numberOfClaims);
			while(noofclaim>0) {
			click(priorclainaddbtn, WaitStrategy.CLIKABLE, "Prior Claim Add Button");
			noofclaim--;
			}
			/*
			 * Here need to add code for adding multiple prior claims
			 */
		}


}
