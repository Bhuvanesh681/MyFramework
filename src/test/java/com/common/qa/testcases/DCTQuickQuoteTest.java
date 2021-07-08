package com.common.qa.testcases;

import java.util.Map;
import org.testng.annotations.Test;
import com.Framwork.enums.CategoryType;
import com.framework.annotations.FrameworkAnnotation;
import com.framework.pages.DCTLoginPage;


public class DCTQuickQuoteTest extends BaseTest{
	private DCTQuickQuoteTest() {
	}

	@FrameworkAnnotation(author= {"bhuvanesh"},category= {CategoryType.REGRESSION,CategoryType.SANITY})
	@Test
	public void DCTQuickQuoteFlowTest(Map<String,String> data) throws InterruptedException {

		new DCTLoginPage().enterUserName(data.get("username"))
		.enterPassword(data.get("password"))
		.clickOnLogin()
		.goToNewQuotePage()
		.selectEntity("Executive Risk")
		.enterProductNumber("")
		.entereffectivedate("")
		.selectLOB("Tech E&O, Cyber and Multimedia Liability") 
		.clickonNewQuoteBtn()
		.enterQuickQuoteGenearlInfo(data.get("accounttype"),data.get("insuredname"), data.get("insuredaddress"),
				data.get("city"),data.get("state"),data.get("zip"),
				data.get("insuredcontactemail"),data.get("insuredcontactphone"),
				data.get("domain"),data.get("YearEstablished"),data.get("ratablerevenue"),
				data.get("underwriter"),data.get("brokername"),data.get("brokerfirm"),
				data.get("produceremail"),
				data.get("effectivedate"),data.get("continutitydate"),
				data.get("commission"),data.get("company"))
		.hazardgroupentry()
		.priorClaimHistory(data.get("yearsofpriorcoverage"), data.get("noofclaims"), data.get("totallossincurred"),
				data.get("lossratio"),data.get("claimhistorycommants"),data.get("noofclaims"),
				data.get("lossdate"),data.get("amoutpaid"),data.get("priorclaimhistorystatus"))
		.limitanddeductible(data.get("one"), data.get("aggregatelimitofliability"), data.get("ecrimelosssubmitofliability"), 
				data.get("quoteprmium"), data.get("finalpremium"));
		


	}

	@FrameworkAnnotation(author= {"Anubhav"},category= {CategoryType.REGRESSION})
	@Test
	public void DCTQuickQuoteFlowTest1(Map<String,String> data) throws InterruptedException {

		new DCTLoginPage().enterUserName(data.get("username"))
		.enterPassword(data.get("password"))
		.clickOnLogin()
		.goToNewQuotePage()
		.selectEntity("Executive Risk")
		.enterProductNumber("")
		.entereffectivedate("")
		.selectLOB("Tech E&O, Cyber and Multimedia Liability") 
		.clickonNewQuoteBtn()
		.enterQuickQuoteGenearlInfo(data.get("accounttype"),data.get("insuredname"), data.get("insuredaddress"),
				data.get("city"),data.get("state"),data.get("zip"),
				data.get("insuredcontactemail"),data.get("insuredcontactphone"),
				data.get("domain"),data.get("YearEstablished"),data.get("ratablerevenue"),
				data.get("underwriter"),data.get("brokername"),data.get("brokerfirm"),
				data.get("produceremail"),
				data.get("effectivedate"),data.get("continutitydate"),
				data.get("commission"),data.get("company"))
		.hazardgroupentry()
		.priorClaimHistory(data.get("yearsofpriorcoverage"), data.get("noofclaims"), data.get("totallossincurred"),
				data.get("lossratio"),data.get("claimhistorycommants"),data.get("noofclaims"),
				data.get("lossdate"),data.get("amoutpaid"),data.get("priorclaimhistorystatus"));
		//.covereageOptions(data.get("ExpandedFirstParty"),data.get("MultimediaCoverage"),data.get("ECrime"),data.get("WaitingPeriod"))
				//.generalSection();


	}

	



}
