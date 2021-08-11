package com.common.qa.testcases;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Framwork.enums.CategoryType;
import com.Framwork.enums.ConfigProperties;
import com.framework.annotations.FrameworkAnnotation;
import com.framework.pages.DCTLoginPage;
import com.framework.utils.PropertyUtils;


public class DCTQuickQuoteTest6 extends BaseTest{
	SoftAssert softAssert;
	private DCTQuickQuoteTest6() {
	}

	@FrameworkAnnotation(author= {"bhuvanesh"},category= {CategoryType.REGRESSION,CategoryType.SANITY})
	@Test
	public void QuickQuoteFlowTest6(Map<String,String> data) throws InterruptedException {
		softAssert=new SoftAssert();
		boolean test6=new DCTLoginPage().enterUserName(PropertyUtils.get(ConfigProperties.USERNAME))
		.enterPassword(PropertyUtils.get(ConfigProperties.PASSWORD))
		.clickOnLogin()
		.goToNewQuotePage()
		.selectEntity("Executive Risk")
		.enterProductNumber("")
		.entereffectivedate("")
		.selectLOB("Simple Cyber GM") 
		.clickonNewQuoteBtn()
		.verifyNYFTIsAutocheck(data.get("accounttype"),data.get("insuredname"), data.get("insuredaddress"),
				data.get("city"),data.get("state"),data.get("zip"),
				data.get("insuredcontactname"),data.get("insuredcontactphone"),data.get("insuredcontactemail"),
				data.get("domain"),data.get("YearEstablished"),data.get("ratablerevenue"),
				data.get("quoteversiondescription"),
				data.get("underwriter"),data.get("producerrname"),data.get("producercontact"),
				data.get("produceremail"),
				data.get("effectivedate"),data.get("policyterm"),data.get("effectivedateTBD"),data.get("continutitydate"),
				data.get("company"),data.get("naicscode"),data.get("commission"),
				data.get("ratinglevel") , data.get("nyftz"), data.get("underwritercomment") );
		softAssert.assertEquals(test6, true);
		softAssert.assertAll();
	

	}

	





}
