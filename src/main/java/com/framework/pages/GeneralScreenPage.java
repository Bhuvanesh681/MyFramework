package com.framework.pages;

import org.openqa.selenium.By;

import com.Framwork.enums.WaitStrategy;
import com.framework.helper.JavaScriptHelper;
import com.framework.utils.DynamicXpathUtils;

public class GeneralScreenPage extends BasePage{

	//General Screen fields
	private static String accoutTypeStr="//input[@value='%s']";
	private static String coverageoptionstryes="(//input[@fieldref='LineInput.%s'])[1]";
	private static String coverageoptionstrno="(//input[@fieldref='LineInput.%s'])[2]";
	private static By insuredNametxtbx=By.xpath("//input[@fieldref='AccountInput.Name']");
	private static By insuredaddresstxtbx=By.xpath("//input[@fieldref='AccountInput.Address1']");
	private static By insuredaddress2txtbx=By.xpath("//input[@fieldref='AccountInput.Address2']");
	private static By citytxtbx=By.xpath("//input[@fieldref='AccountInput.City']");
	private static By stateselectdrpdwn=By.xpath("//input[@fieldref='AccountInput.State']");
	private static By zipcodetxtbx=By.xpath("//input[@fieldref='AccountInput.ZipCode']");
	private static By insuredcontactnametxtbx=By.xpath("//input[@fieldref='AccountInput.InsuredName']");
	private static By insuredphonetxtbx=By.xpath("//input[@fieldref='AccountInput.InsuredPhone']");
	private static By insuredemailtxtbx=By.xpath("//input[@fieldref='AccountInput.InsuredEmail']");
	private static By domaintxtbx=By.xpath("//input[@fieldref='PolicyInput.Domain']");
	private static By yearinbusinesstxtbx=By.xpath("//input[@fieldref='PolicyInput.YearEstablished']");
	private static By ratablerevenuetxtbx=By.xpath("//input[@fieldref='LineInput.RatableRevenue']");
	private static By quoteversiondescriptiontxtbx=By.xpath("//input[@fieldref='PolicyInput.Description']");
	private static By underwriterdropdown=By.xpath("//input[@fieldref='LineUnderwritingInput.Underwriter']");
	private static By producernametxtbx=By.xpath("//input[@fieldref='ProducerInfoOutput.Name']");
	private static By producercontacttxtbx=By.xpath("//input[@fieldref='ProducerInfoOutput.Contact']");
	private static By produceremailtxtbx=By.xpath("//input[@fieldref='ProducerInfoOutput.Email']");
	//private static By brokerfirmtxtbx=By.xpath("//input[@fieldref='ProducerInfoOutput.Name']");
	private static By effectivedateselect=By.xpath("//input[@fieldref='PolicyInput.EffectiveDate']");
	private static By policytermdrpdwn=By.xpath("//input[@fieldref='PolicyInput.Term']");
	private static By continutydateselect=By.xpath("//input[@fieldref='PolicyInput.ContinuityDate']");
	private static By effectivedateTBDcheckbx=By.xpath("(//input[@fieldref='PolicyInput.EffectiveDateTBD'])[1]");
	private static By commissiontxtbox=By.xpath("//input[@fieldref='LineInput.CommissionPercentage']");
	private static By writingcompanydrpdwn=By.xpath("//input[@fieldref='LineUnderwritingInput.WritingCompany']");
	private static By NAICSCcodedropdwn=By.xpath("//input[@fieldref='PolicyOutputNonShredded.NAICSCodeSearchResult']");
	//private static By ratinglevelstandard=By.xpath("//input[@fieldref='LineInput.StandardRatingLevel']");
	private static By ratinglevelpreferred=By.xpath("//input[@fieldref='LineInput.PreferredRatingLevel']");
	private static By NYFTZcheckbx=By.xpath("//input[@type='checkbox' and @fieldref='PolicyInput.NYFTZ']");
	private static By underwritercommnettxtarea=By.xpath("//textarea[@fieldref='PolicyInput.UnderwriterComments']");
	private static By nextbtn=By.xpath("//span[@class='g-btn-text'][contains(.,'Next')]");
	



	//Method to enters all fields value in General Screen
	public PriorClaimHistoryPage enterQuickQuoteGenearlInfo(String accounttype,String insuredname,String insuredaddress,
			String city,String state,String zip,String insuredcontactname,String insuredcontactphone,String insuredcontactemail,
			String domain,String yearestablised,String ratablerevenue,
			String quoteversiondescription,String underwriter,
			String producername,String producercontact,String produceremail,
			String effectivedate,String policyterm,String effectivedateTBD,String continutydate,String company,
			String naicsccode,String commission,String ratinglevel,
			String nyftz, String underwritercomment ) throws InterruptedException {


		Thread.sleep(5000);
		System.out.println(accounttype);
		if(!accounttype.equalsIgnoreCase("New")) {
			String accouttypexpath = DynamicXpathUtils.getXpath(accoutTypeStr, accounttype);
			click(By.xpath(accouttypexpath), WaitStrategy.NONE, "AccoutType radio btn");
		}
		sendKeys(insuredNametxtbx, insuredname, WaitStrategy.PRESENCE, "Insured name txt box");
		sendKeys(insuredaddresstxtbx, insuredaddress, WaitStrategy.PRESENCE, "Insured name txt box");
		JavaScriptHelper.scrollDownByPixel(300);
		Thread.sleep(1000);
		sendKeysWithEnter(citytxtbx, city, WaitStrategy.PRESENCE, "City name txt box");
		sendKeysWithoutClick(stateselectdrpdwn, state, WaitStrategy.NONE, "State name txt box");
		sendKeys(zipcodetxtbx, zip, WaitStrategy.PRESENCE, "Zip code txt box");
		sendKeys(insuredcontactnametxtbx, insuredcontactname, WaitStrategy.PRESENCE, "Insured contact Name text box");
		JavaScriptHelper.scrollDownByPixel(100);
		Thread.sleep(1000);
		sendKeys(insuredphonetxtbx, insuredcontactphone, WaitStrategy.PRESENCE, "Insured Phone number box");

		sendKeys(insuredemailtxtbx, insuredcontactemail, WaitStrategy.PRESENCE, "Insured email Text box");

		sendKeys(domaintxtbx, domain,  WaitStrategy.PRESENCE, "Domain name text box");

		sendKeysWithoutClick(yearinbusinesstxtbx, yearestablised,WaitStrategy.PRESENCE, "Year Establised drop down");

		sendKeys(ratablerevenuetxtbx, ratablerevenue, WaitStrategy.PRESENCE, "Ratable revenue text box");

		sendKeys(quoteversiondescriptiontxtbx, quoteversiondescription, WaitStrategy.PRESENCE, "Quote version description text box");
		JavaScriptHelper.scrollUpVertically();
		Thread.sleep(1000);
		sendKeysWithEnter(underwriterdropdown, underwriter,  WaitStrategy.NONE, "Underwriter Select drop down");

		sendKeys(producernametxtbx, producername, WaitStrategy.PRESENCE, "Producer Name text field");

		sendKeys(producercontacttxtbx, producercontact, WaitStrategy.PRESENCE, "Producer COntact text field");

		sendKeys(produceremailtxtbx, produceremail, WaitStrategy.PRESENCE, "Producer Email text box");
		if(effectivedateTBD.equalsIgnoreCase("yes")) {
			click(effectivedateTBDcheckbx, WaitStrategy.NONE, "Effective Date Check Box");
			Thread.sleep(2000);
		}else {
		clearandsendKeys(effectivedateselect, effectivedate, WaitStrategy.PRESENCE, "Select Effective date");
		sendKeysWithoutClick(policytermdrpdwn, policyterm, WaitStrategy.PRESENCE, "Policy term drop down");
		clearandsendKeys(continutydateselect, continutydate, WaitStrategy.PRESENCE, "Select Continuty date");
		}
		sendKeysWithoutClick(writingcompanydrpdwn, company, WaitStrategy.PRESENCE, "Writing company name txt box");

		sendKeysWithoutClick(NAICSCcodedropdwn, naicsccode, WaitStrategy.PRESENCE, "NAICSC Code drop down");

		sendKeys(commissiontxtbox, commission, WaitStrategy.PRESENCE, "Commission txt box");

		if(!ratinglevel.equalsIgnoreCase("Standard")) {
			click(ratinglevelpreferred, WaitStrategy.PRESENCE, "Rating level preferred");
		}
		/*
		 * if(nyftz.equalsIgnoreCase("Yes")) { click(NYFTZcheckbx,
		 * WaitStrategy.PRESENCE, "NYFTZ check box"); }
		 */
		sendKeys(underwritercommnettxtarea, underwritercomment, WaitStrategy.PRESENCE, "Under writer commnet text area");
		Thread.sleep(1000);
		JavaScriptHelper.scrollDownByPixel(500);
		Thread.sleep(1000);
		click(nextbtn, WaitStrategy.PRESENCE, "Next button");
		Thread.sleep(2000);
		return new PriorClaimHistoryPage();
	}


}
