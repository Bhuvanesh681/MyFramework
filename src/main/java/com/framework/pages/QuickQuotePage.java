package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.Framwork.enums.WaitStrategy;
import com.framework.driver.DriverManager;
import com.framework.utils.DynamicXpathUtils;

public class QuickQuotePage extends BasePage {


	//private static By accouttyperadiobtn=By.xpath("//input[@value='%account_type%']");
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

	private static By medicalifo=By.xpath("//input[@name='int_4C7_1']");
	private static By dependency=By.xpath("//input[@name='int_4C7_5']");

	private static By yearsofpriorcoveragetxtbx=By.xpath("//input[@fieldref='LineInput.YearsOfPriorCoverage']");
	private static By noofclaimstxtbx=By.xpath("//input[@fieldref='LineInput.NumberOfClaims']");
	private static By totallossincurredtxtbx=By.xpath("//input[@fieldref='LineInput.TotalLoss']");
	private static By lossratiodrpdwn=By.xpath("//input[@fieldref='LineInput.LossRatio']");
	private static By claimhistorycommenttxtarea=By.xpath("//textarea[@fieldref='LineInput.ClaimComments']");
	private static By priorclainaddbtn=By.xpath("(//span[@class='g-btn-text'][contains(.,'ADD')])[1]");
	private static By priorclaimlossdate=By.xpath("//input[@fieldref='LossInput.DateOfLoss']");
	private static By priorclaimamountpaid=By.xpath("//input[@fieldref='LossInput.AmountPaid']");
	private static By priorclaimhistorystatus=By.xpath("//input[@fieldref='LossInput.Status']");
	private static By priorclaimhistorycancelbtn=By.xpath("//a[@role='button'][contains(.,'X')]");

	private static By nextbtn=By.xpath("//span[@class='g-btn-text'][contains(.,'Next')]");


	public QuickQuotePage enterQuickQuoteGenearlInfo(String accounttype,String insuredname,String insuredaddress,
			String city,String state,String zip,String insuredcontactemail,String insuredcontactphone,
			String domain,String yearestablised,String ratablerevenue,String underwriter,
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
		sendKeys(produceremailtxtbx, produceremail, WaitStrategy.PRESENCE, "Producer Email text box");
		sendKeysWithoutClick(effectivedateselect, effectivedate, WaitStrategy.PRESENCE, "Select Effective date");
		sendKeysWithoutClick(continutydateselect, continutydate, WaitStrategy.PRESENCE, "Select Continuty date");
		sendKeys(commissiontxtbox, commission, WaitStrategy.PRESENCE, "Commission txt box");
		sendKeysWithEnter(writingcompanydrpdwn, company, WaitStrategy.PRESENCE, "Writing company name txt box");
		
		return this;
	}

	public QuickQuotePage hazardgroupentry() {
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollBy(0,500)", "");
		sendKeys(medicalifo, "120", WaitStrategy.PRESENCE, "Medical info");
		sendKeys(dependency, "100", WaitStrategy.PRESENCE, "Dependency info");
		return this;		
	}

	public QuickQuotePage priorClaimHistory(String yearsofpriorcoverage,String noofclaims,String totallossincurred,
			String lossratio,String claimhistorycomment) throws InterruptedException {
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollBy(0,500)", "");
		sendKeys(yearsofpriorcoveragetxtbx, yearsofpriorcoverage, WaitStrategy.PRESENCE, "yearsofpriorcoverage txt bx");
		sendKeys(noofclaimstxtbx, noofclaims, WaitStrategy.PRESENCE, "noofclaimstxtbx txt bx");
		sendKeys(totallossincurredtxtbx, totallossincurred, WaitStrategy.PRESENCE, "totallossincurredtxtbx txt bx");
		sendKeysWithEnter(lossratiodrpdwn, lossratio, WaitStrategy.PRESENCE, "lossratiodrpdwn txt bx");
		sendKeys(claimhistorycommenttxtarea, claimhistorycomment, WaitStrategy.PRESENCE, "claim history comment text area");

		return this;

	}

	public QuickQuotePage covereageOptions(String expandedfirstparty, String multimediacoverage,String ecrime,String waitingperiod) {
		if(expandedfirstparty.equalsIgnoreCase("yes") ) {
			//Bydefault yes is selected ---no need to select
			//String coverageoptions_xpath=DynamicXpathUtils.getXpath(coverageoptionstryes, "ExpandedFirstParty");
			//click(By.xpath(coverageoptions_xpath), WaitStrategy.PRESENCE, "Coverage option radio button");
		}else if(expandedfirstparty.equalsIgnoreCase("no")) {
			String coverageoptions_xpath=DynamicXpathUtils.getXpath(coverageoptionstrno, "ExpandedFirstParty");
			click(By.xpath(coverageoptions_xpath), WaitStrategy.PRESENCE, "Coverage option radio button");
		}
		if(multimediacoverage.equalsIgnoreCase("yes") ) {
			//Bydefault yes is selected ---no need to select
			//String coverageoptions_xpath=DynamicXpathUtils.getXpath(coverageoptionstryes, "MultimediaCoverage");
			//click(By.xpath(coverageoptions_xpath), WaitStrategy.PRESENCE, "Coverage option radio button");
		}else if(multimediacoverage.equalsIgnoreCase("no")) {
			String coverageoptions_xpath=DynamicXpathUtils.getXpath(coverageoptionstrno, "MultimediaCoverage");
			click(By.xpath(coverageoptions_xpath), WaitStrategy.PRESENCE, "Coverage option radio button");
		}
		if(ecrime.equalsIgnoreCase("yes") ) {
			//Bydefault yes is selected ---no need to select
			//String coverageoptions_xpath=DynamicXpathUtils.getXpath(coverageoptionstryes, "ECrime");
			//click(By.xpath(coverageoptions_xpath), WaitStrategy.PRESENCE, "Coverage option radio button");
		}else if(ecrime.equalsIgnoreCase("no")) {
			String coverageoptions_xpath=DynamicXpathUtils.getXpath(coverageoptionstrno, "ECrime");
			click(By.xpath(coverageoptions_xpath), WaitStrategy.PRESENCE, "Coverage option radio button");
		}
		if(waitingperiod.equalsIgnoreCase("8") ) {
			//Bydefault '8' is selected ---no need to select
			//String coverageoptions_xpath=DynamicXpathUtils.getXpath(coverageoptionstryes, "WaitingPeriod");
			//click(By.xpath(coverageoptions_xpath), WaitStrategy.PRESENCE, "Coverage option radio button");
		}else if(waitingperiod.equalsIgnoreCase("10")) {
			String coverageoptions_xpath=DynamicXpathUtils.getXpath(coverageoptionstrno, "WaitingPeriod");
			click(By.xpath(coverageoptions_xpath), WaitStrategy.PRESENCE, "Coverage option radio button");
		}


		return this;

	}

	public QuickQuotePage generalSection() throws InterruptedException {
		Thread.sleep(1000);
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);
		click(nextbtn, WaitStrategy.PRESENCE, "Next Button");
		Thread.sleep(3000);
		return this;

	}


}
