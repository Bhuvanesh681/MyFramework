package com.common.qa.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import com.Framwork.enums.CategoryType;
import com.Framwork.enums.ConfigProperties;
import com.framework.annotations.FrameworkAnnotation;
import com.framework.pages.DCTLoginPage;
import com.framework.utils.PropertyUtils;


public class DCTQuickQuoteTest2 extends BaseTest{
	private DCTQuickQuoteTest2() {
	}

	
	
	@FrameworkAnnotation(author= {"bhuvanesh"},category= {CategoryType.REGRESSION,CategoryType.SANITY})
	@Test
	public void QuickQuoteFlowTest2(Map<String,String> data) throws InterruptedException {

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
				data.get("effectivedate"),data.get("policyterm"),data.get("effectivedateTBD"),data.get("continutitydate"),
				data.get("company"),data.get("naicscode"),data.get("commission"),
				data.get("ratinglevel") , data.get("nyftz"), data.get("underwritercomment") )

		.priorClaimHistory(data.get("noofclaims"),data.get("priorclaimlossdate"), data.get("totalincurred"), data.get("status"),
				data.get("yearsofpriorcoverage"),data.get("claimhistorycommants")
				)
		.covereageOptions(data.get("expandedfirstparty"), data.get("multimediacoverage"), data.get("ecrime"),
				data.get("increasesublimits"), data.get("fraudulentinvoice"), data.get("waitingperiod"),
				data.get("extracoveragecomment"), data.get("additionalcoveragedescription"), data.get("coveragepremiun"))
		
		.enterScheduleandRatingValues(data.get("FinancialCondition_value"),data.get("FinancialCondition_comment"),
				data.get("MaturityOfBusiness_value"),data.get("MaturityOfBusiness_comment"),
				data.get("QualityOfManagement_value"),data.get("QualityOfManagement_comment")
				)

		.limitanddeductible(data.get("limitanddeductibleoption"), data.get("aggregatelimitofliability"),
				data.get("ransomwaresublimitliability"), data.get("ransomwarecoinsurance")
				)
		.optionalcoverageTaxAndSurchage().redirectToQuotePage();



	}








}
