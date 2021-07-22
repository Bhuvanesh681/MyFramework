package com.framework.pages;

import org.openqa.selenium.By;

import com.Framwork.enums.WaitStrategy;
import com.framework.utils.DynamicXpathUtils;

public class CoveragePricingPage extends BasePage {

	//Coverage Options fields

	
	private static By expandedfirstpartycov_yes=By.xpath("(//input[@fieldref='CovExpandedFirstPartyInput.ExpandedFirstPartySelection'])[1]");
	private static By expandedfirstpartycov_no=By.xpath("(//input[@fieldref='CovExpandedFirstPartyInput.ExpandedFirstPartySelection'])[2]");
	private static By multimediacov_yes=By.xpath("(//input[@fieldref='CovMultimediaCoverageInput.MultimediaCoverageSelection'])[1]");
	private static By multimediacov_no=By.xpath("(//input[@fieldref='CovMultimediaCoverageInput.MultimediaCoverageSelection'])[2]");
	private static By ecrime_yes=By.xpath("(//input[@fieldref='CoveCrimeInput.eCrimeCoverageSelection'])[1]");
	private static By ecrime_no=By.xpath("(//input[@fieldref='CoveCrimeInput.eCrimeCoverageSelection'])[2]");
	private static By increasesublimit_yes=By.xpath("(//input[contains(@fieldref,'CovIncreaseSublimitsInput.IncreaseSublimitsCoverageSelection')])[1]");
	private static By increasesublimit_no=By.xpath("(//input[contains(@fieldref,'CovIncreaseSublimitsInput.IncreaseSublimitsCoverageSelection')])[2]");
	private static By fraudulentinvoice_yes=By.xpath("(//input[contains(@fieldref,'CovFraudulentInvoiceInput.FraudulentInvoiceCoverageSelection')])[1]");
	private static By fraudulentinvoice_no=By.xpath("(//input[contains(@fieldref,'CovFraudulentInvoiceInput.FraudulentInvoiceCoverageSelection')])[2]");
	private static By waitingperoid_8=By.xpath("(//input[@fieldref='CovWaitingPeriodInput.WaitingPeriodSelection'])[1]");
	private static By waitingperoid_10=By.xpath("(//input[@fieldref='CovWaitingPeriodInput.WaitingPeriodSelection'])[2]");

	private static By endorsandextracoveragecommenttxtarea=By.xpath("//textarea[@fieldref='LineInput.EndorsementComments']");
	private static By additionalcoveragedescrtxtbx=By.xpath("//input[@fieldref='CovAdditionalCoverageInput.Description']");
	private static By coverageoptionpremiumtxtbx=By.xpath("//input[@fieldref='CovAdditionalCoverageInput.CoveragePremium']");

	
	
	//Limits/Deductible fields
	private static By optiononecheckbx=By.xpath("(//input[@type='checkbox'])[3]");
	private static By aggregatelimitofliabilitydropdown=By.xpath("//input[@fieldref='CovTechInput.AggregateLimit']");
	private static By selecteddeductibletxtbx=By.xpath("//input[@fieldref='CovTechInput.SelectedDeductible']");
	private static By quotepremiumtxtbx=By.xpath("//input[@fieldref='CovTechInput.TargetPremium']");
	private static By finalpremiumtxtbx=By.xpath("//input[@fieldref='CovTechInput.FinalPremium']");
	private static String coverageoptionstrno="(//input[@fieldref='LineInput.%s'])[2]";


	//Method to enters all fields value in Coverage and Pricing Screen
	public CoveragePricingPage covereageOptions(String expandedfirstparty, String multimediacoverage,String ecrime,
			String increasesublimits,String fraudulentinvoice,String waitingperiod,
			String extracoveragecomment,String additionalcoveragedescription,String coveragepricingpremium) {
		if(expandedfirstparty.equalsIgnoreCase("yes") ) {
			//Bydefault yes is selected ---no need to select

		}else if(expandedfirstparty.equalsIgnoreCase("no")) {

			click(expandedfirstpartycov_no, WaitStrategy.PRESENCE, "Coverage option radio button");
		}
		if(multimediacoverage.equalsIgnoreCase("yes") ) {
			//Bydefault yes is selected ---no need to select

		}else if(multimediacoverage.equalsIgnoreCase("no")) {

			click(multimediacov_no, WaitStrategy.PRESENCE, "Coverage option radio button");
		}
		if(ecrime.equalsIgnoreCase("yes") ) {
			//Bydefault yes is selected ---no need to select

		}else if(ecrime.equalsIgnoreCase("no")) {

			click(ecrime_no, WaitStrategy.PRESENCE, "Coverage option radio button");
		}
		if(increasesublimits.equalsIgnoreCase("yes") ) {
			click(increasesublimit_yes, WaitStrategy.PRESENCE, "Coverage option radio button");

		}else if(ecrime.equalsIgnoreCase("no")) {
			//Bydefault no is selected ---no need to select

		}
		if(fraudulentinvoice.equalsIgnoreCase("yes") ) {
			click(fraudulentinvoice_yes, WaitStrategy.PRESENCE, "Coverage option radio button");


		}else if(ecrime.equalsIgnoreCase("no")) {
			//Bydefault no is selected ---no need to select

		}
		if(waitingperiod.equalsIgnoreCase("8") ) {
			click(waitingperoid_8, WaitStrategy.PRESENCE, "Coverage option radio button");

		}else if(waitingperiod.equalsIgnoreCase("10")) {
			//Bydefault '10' is selected ---no need to select
		}

		sendKeys(endorsandextracoveragecommenttxtarea, extracoveragecomment, WaitStrategy.PRESENCE, "Extra coverage comment text area");
		sendKeys(additionalcoveragedescrtxtbx, additionalcoveragedescription, WaitStrategy.PRESENCE, "Additional coverage description text area");
		sendKeys(coverageoptionpremiumtxtbx, coveragepricingpremium, WaitStrategy.PRESENCE, "Coverage pricing premium text box ");
		return this;

	}

	//Method to enter all value in Limit/deductible screen
	public CoveragePricingPage limitanddeductible(String option,String aggregatelimitofliability,String selecteddeductible,
			String quoteprmium,String finalpremium) {
		if(option.equalsIgnoreCase("one")) {
			click(optiononecheckbx, WaitStrategy.CLIKABLE, "Option One undet Limit and Deductible");
		}
		sendKeysWithoutClick(aggregatelimitofliabilitydropdown, aggregatelimitofliability, WaitStrategy.PRESENCE, "Aggregate Limit Liability drop down");
		sendKeys(selecteddeductibletxtbx, selecteddeductible, WaitStrategy.PRESENCE, "Selected Deductible text box");
		sendKeys(quotepremiumtxtbx, quoteprmium, WaitStrategy.PRESENCE, "Quote Premium text box");
		sendKeys(finalpremiumtxtbx, finalpremium, WaitStrategy.PRESENCE, "Final Premium text box");
		return this;

	}
}
