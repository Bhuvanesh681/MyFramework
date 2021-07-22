package com.common.qa.testcases;

import java.util.Map;
import org.testng.annotations.Test;
import com.Framwork.enums.CategoryType;
import com.Framwork.enums.ConfigProperties;
import com.framework.annotations.FrameworkAnnotation;
import com.framework.pages.DCTLoginPage;
import com.framework.utils.PropertyUtils;


public class DCTQuickQuoteTest1 extends BaseTest{
	private DCTQuickQuoteTest1() {
	}

	
	
	@FrameworkAnnotation(author= {"bhuvanesh"},category= {CategoryType.REGRESSION,CategoryType.SANITY})
	@Test
	public void DCTQuickQuoteFlowTest1(Map<String,String> data) throws InterruptedException {

		new DCTLoginPage().enterUserName(PropertyUtils.get(ConfigProperties.USERNAME))
		.enterPassword(PropertyUtils.get(ConfigProperties.PASSWORD))
		.clickOnLogin()
		.goToNewQuotePage()
		.selectEntity("Executive Risk")
		.enterProductNumber("")
		.entereffectivedate("")
		.selectLOB("Simple Cyber GM") 
		.clickonNewQuoteBtn()
		.enterQuickQuoteGenearlInfo(data.get("accounttype"),data.get("insuredname"), data.get("insuredaddress"),
				data.get("city"),data.get("state"),data.get("zip"),
				data.get("insuredcontactname"),data.get("insuredcontactphone"),data.get("insuredcontactemail"),
				data.get("domain"),data.get("YearEstablished"),data.get("ratablerevenue"),
				data.get("quoteversiondescription"),
				data.get("underwriter"),data.get("producerrname"),data.get("producercontact"),
				data.get("produceremail"),
				data.get("effectivedate"),data.get("continutitydate"),
				data.get("company"),data.get("naicscode"),data.get("commission"),
				data.get("ratinglevel") , data.get("nyftz"), data.get("underwritercomment") )

		.priorClaimHistory(data.get("noofclaims"),data.get("priorclaimlossdate"), data.get("totalincurred"), data.get("status"),
				data.get("yearsofpriorcoverage"),data.get("claimhistorycommants")
				)
		.covereageOptions(data.get("expandedfirstparty"), data.get("multimediacoverage"), data.get("ecrime"),
				data.get("increasesublimits"), data.get("fraudulentinvoice"), data.get("waitingperiod"),
				data.get("extracoveragecomment"), data.get("additionalcoveragedescription"), data.get("coveragepremiun"));

		/*.limitanddeductible(data.get("one"), data.get("aggregatelimitofliability"),
				data.get("ecrimelosssubmitofliability"), data.get("quoteprmium"),
				data.get("finalpremium"));*/




	}








}
