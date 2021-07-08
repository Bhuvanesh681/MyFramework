package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.Framwork.enums.WaitStrategy;
import com.framework.driver.DriverManager;
import com.framework.utils.DynamicXpathUtils;

public class GeneralPage extends BasePage{

	//General Screen fields
		private static String accoutTypeStr="//input[@value='%s']";
		private static String coverageoptionstryes="(//input[@fieldref='LineInput.%s'])[1]";
		private static String coverageoptionstrno="(//input[@fieldref='LineInput.%s'])[2]";
		private static By insuredNametxtbx=By.xpath("//input[@fieldref='AccountInput.Name_UI']");
		private static By insuredaddresstxtbx=By.xpath("//input[@fieldref='AccountInput.Address1_UI']");
		private static By insuredaddress2txtbx=By.xpath("//input[@fieldref='AccountInput.Address2']");
		private static By citytxtbx=By.xpath("//input[@fieldref='AccountInput.City_UI']");
		private static By stateselectdrpdwn=By.xpath("//input[@fieldref='AccountInput.State']");
		private static By zipcodetxtbx=By.xpath("//input[@fieldref='AccountInput.ZipCode_UI']");
		private static By insuredemailtxtbx=By.xpath("//input[@fieldref='AccountInput.Email_UI']");
		private static By primaryphonetxtbx=By.xpath("//input[@fieldref='AccountInput.PrimaryPhone_UI']");
		private static By websitetxtbx=By.xpath("//input[@fieldref='AccountInput.Website']");
		private static By yearinbusinessdrpdwn=By.xpath("//input[@fieldref='PolicyInput.YearsInBusiness']");
		private static By ratablerevenuetxtbx=By.xpath("//input[@fieldref='LineInput.RatableRevenue']");
		private static By underwriterdropdown=By.xpath("//input[@fieldref='PolicyInput.Underwriter']");
		private static By brokernametxtbx=By.xpath("//input[@fieldref='SubProducerInfoOutput.Name']");
		private static By produceremailtxtbx=By.xpath("//input[@fieldref='SubProducerInfoOutput.Email']");
		private static By brokerfirmtxtbx=By.xpath("//input[@fieldref='ProducerInfoOutput.Name']");
		private static By effectivedateselect=By.xpath("//input[@fieldref='PolicyInput.EffectiveDate']");
		private static By continutydateselect=By.xpath("//input[@fieldref='PolicyInput.ContinuityDate']");
		private static By commissiontxtbox=By.xpath("//input[@fieldref='LineInput.CommissionPercentage']");
		private static By writingcompanydrpdwn=By.xpath("//input[@fieldref='LineUnderwritingInput.WritingCompany']");
		
		//Method to enters all fields value in General Screen
		public PriorClaimHistoryPage enterQuickQuoteGenearlInfo(String accounttype,String insuredname,String insuredaddress,
				String city,String state,String zip,String insuredcontactemail,String insuredcontactphone,
				String domain,String yearestablised,String ratablerevenue,String underwriter,
				String brokername,String brokerfirm,
				String produceremail,String effectivedate,String continutydate,
				String commission,String company ) throws InterruptedException {

			Thread.sleep(5000);
			System.out.println(accounttype);
			if(!accounttype.equalsIgnoreCase("New")) {
				String accouttypexpath = DynamicXpathUtils.getXpath(accoutTypeStr, accounttype);
				click(By.xpath(accouttypexpath), WaitStrategy.NONE, "AccoutType radio btn");
			}
			sendKeys(insuredNametxtbx, insuredname, WaitStrategy.PRESENCE, "Insured name txt box");
			sendKeys(insuredaddresstxtbx, insuredaddress, WaitStrategy.PRESENCE, "Insured name txt box");
			((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollBy(0,250)", "");
			sendKeysWithEnter(citytxtbx, city, WaitStrategy.PRESENCE, "City name txt box");
			sendKeysWithoutClick(stateselectdrpdwn, state, WaitStrategy.NONE, "State name txt box");
			sendKeysWithEnter(zipcodetxtbx, zip, WaitStrategy.PRESENCE, "Zip code txt box");
			sendKeys(insuredemailtxtbx, insuredcontactemail, WaitStrategy.PRESENCE, "Insured email Text box");
			sendKeys(primaryphonetxtbx, insuredcontactphone, WaitStrategy.PRESENCE, "Insured Phone number box");
			sendKeys(websitetxtbx, domain,  WaitStrategy.PRESENCE, "Domain name text box");
			sendKeysWithoutClick(yearinbusinessdrpdwn, yearestablised,WaitStrategy.PRESENCE, "Year Establised drop down");
			sendKeys(ratablerevenuetxtbx, ratablerevenue, WaitStrategy.PRESENCE, "Ratable revenue text box");
			sendKeysWithoutClick(underwriterdropdown, underwriter,  WaitStrategy.PRESENCE, "Underwriter Select drop down");
			sendKeys(brokernametxtbx, brokername, WaitStrategy.PRESENCE, "Broker Name text field");
			sendKeys(brokerfirmtxtbx, brokerfirm, WaitStrategy.PRESENCE, "Broker Firm text field");
			sendKeys(produceremailtxtbx, produceremail, WaitStrategy.PRESENCE, "Producer Email text box");
			sendKeysWithoutClick(effectivedateselect, effectivedate, WaitStrategy.PRESENCE, "Select Effective date");
			sendKeysWithoutClick(continutydateselect, continutydate, WaitStrategy.PRESENCE, "Select Continuty date");
			sendKeys(commissiontxtbox, commission, WaitStrategy.PRESENCE, "Commission txt box");
			sendKeysWithEnter(writingcompanydrpdwn, company, WaitStrategy.PRESENCE, "Writing company name txt box");

			return new PriorClaimHistoryPage();
		}


}
