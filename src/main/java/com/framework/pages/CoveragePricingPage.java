package com.framework.pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;

import com.Framwork.enums.WaitStrategy;
import com.framework.driver.DriverManager;
import com.framework.helper.JavaScriptHelper;
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

	//Schedule Rating fields
	private static By financialconditiontxtbx=By.xpath("//input[@fieldref='Mods.FinancialCondition']");
	private static By financialconditioncommenttxtarea=By.xpath("//textarea[@fieldref='Mods.FinancialConditionComment']");
	private static By maturityofbusinesstxtbx=By.xpath("//input[@fieldref='Mods.MaturityOfBusiness']");
	private static By maturityofbusinesscommenttxtarea=By.xpath("//textarea[@fieldref='Mods.MaturityOfBusinessComment']");
	private static By qualityofmanagmenttxtbx=By.xpath("//input[@fieldref='Mods.QualityOfManagement']");
	private static By qualityofmanagmenttxtarea=By.xpath("//textarea[@fieldref='Mods.QualityOfManagementComment']");
	private static By volumofinformationtxtbx=By.xpath("//input[@fieldref='Mods.VolumeOfInformation']");
	private static By volumofinformationtxtarea=By.xpath("//textarea[@fieldref='Mods.VolumeOfInformationComment']");
	private static By territoryofoperationtxtbx=By.xpath("//input[@fieldref='Mods.TerritoryOfOperations']");
	private static By territoryofoperationtxtarea=By.xpath("//textarea[@fieldref='Mods.TerritoryOfOperationsComment']");
	private static By natureofcontenttxtbx=By.xpath("//input[@fieldref='Mods.NatureOfContent']");
	private static By natureofcontenttxtarea=By.xpath("//textarea[@fieldref='Mods.NatureOfContentComment']");
	private static By natureofreputationaltxtbx=By.xpath("//input[@fieldref='Mods.NatureOfReputational']");
	private static By natureofreputationaltxtarea=By.xpath("//textarea[@fieldref='Mods.NatureOfReputationalComment']");
	private static By natureofpaymentcardtxtbx=By.xpath("//input[@fieldref='Mods.NatureOfPaymentCard']");
	private static By natureofpaymentcardtxtarea=By.xpath("//textarea[@fieldref='Mods.NatureOfPaymentCardComment']");
	private static By privacyandsecuritytxtbx=By.xpath("//input[@fieldref='Mods.PrivacyAndSecurity']");
	private static By privacyandsecuritytxtarea=By.xpath("//textarea[@fieldref='Mods.PrivacyAndSecurityComment']");
	private static By participationriskcontroltxtbx=By.xpath("//input[@fieldref='Mods.ParticipationRiskControl']");
	private static By participationriskcontroltxtarea=By.xpath("//textarea[@fieldref='Mods.ParticipationRiskControlComment']");
	private static By scheduleratingfactortxtbx=By.xpath("//input[@fieldref='Mods.TotalMods']");
	private static By scheduleratingcomments=By.xpath("//textarea[@fieldref='Mods.ScheduleRatingComments']");


	//Limits/Deductible fields
	private static By optiononecheckbx=By.xpath("(//input[@fieldref='OptionInput.Select'])[1]");
	private static By aggregatelimitofliabilitydropdown=By.xpath("//input[@fieldref='OptionInput.AggregateLimitOfLiability']");
	private static By selecteddeductibletxtbx=By.xpath("//input[@fieldref='CovTechInput.SelectedDeductible']");
	private static By ransomwaresublimitofliabilitytxtbx=By.xpath("//input[@fieldref='OptionInput.RansomwareSublimitOfLiability']");
	private static By ransomwarecoinsurancetxtbx=By.xpath("//input[@fieldref='OptionInput.RansomwareCoinsurance']");
	private static By standardpremiumtxtbx=By.xpath("//input[@fieldref='CyberLimitsOutput.StandardPremium']");
	
	//Advanced Risk Control
	private static By advancedriskcontroladdbtn=By.xpath("(//span[@class='g-btn-text'][contains(.,'ADD')])[2]");
	private static String advancedriskcontrolremovestring="(//span[@class='g-btn-text'][contains(.,'X')])['%s']";
	private static By advancedriskcontrolcommenttxtarea=By.xpath("//textarea[@fieldref='AdvancedRiskControlInput.AdditionalComments']");

	//Optional Coverage tax/surcharge
	private static By managedservicedrpdwn=By.xpath("//input[@fieldref='LineInput.ManagedServiceSelection']");
	private static By njpligalabel=By.xpath("//label[contains(.,'NJ PLIGA')]");
	private static By nextbtn=By.xpath("//span[@class='g-btn-text'][contains(.,'Next')]");



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

	//Method to enter all values in Schedule Rating fields
	public CoveragePricingPage enterScheduleandRatingValues(String financialconditionValue,String financialconditionComment,
			String maturityofbusinessValue,String maturityofbusinessComment,
			String qualityofmanagmentValue,String qualityofmanagmentComment) {
		sendKeys(financialconditiontxtbx, financialconditionValue, WaitStrategy.PRESENCE, "Financial Condition text box");
		sendKeys(financialconditioncommenttxtarea, financialconditionComment, WaitStrategy.PRESENCE, "Financial Condition Comment box");
		sendKeys(maturityofbusinesstxtbx, maturityofbusinessValue, WaitStrategy.PRESENCE, "Maturity of business text box");
		sendKeys(maturityofbusinesscommenttxtarea, maturityofbusinessComment, WaitStrategy.PRESENCE, "Maturity of business Comment box");
		sendKeys(qualityofmanagmenttxtbx, qualityofmanagmentValue, WaitStrategy.PRESENCE, "Quality of managment text box");
		sendKeys(qualityofmanagmenttxtarea, qualityofmanagmentComment, WaitStrategy.PRESENCE, "Quality of managment Comment box");
		//sendKeys(scheduleratingfactortxtbx, scheduleratingfactor, WaitStrategy.PRESENCE, "Schedule Rating Factor text box");
		return this;

	}

	//Method to enter all value in Limit/deductible screen
	public CoveragePricingPage limitanddeductible(String option,String aggregatelimitofliability,String ransomwaresublimit,
			String ransomwarecoinsurance) throws InterruptedException {
		scrollIntoView(optiononecheckbx);
		Thread.sleep(2000);
		if(option.equalsIgnoreCase("one")) {
			clickUsingJS(optiononecheckbx);
			JavaScriptHelper.scrollDownByPixel(200);
			Thread.sleep(4000);
			
		}
		sendKeysWithEnter(aggregatelimitofliabilitydropdown, aggregatelimitofliability, WaitStrategy.PRESENCE, "Aggregate Limit Liability drop down");
		sendKeys(ransomwaresublimitofliabilitytxtbx, ransomwaresublimit, WaitStrategy.PRESENCE, "Ransomware Sublimit text box");
		sendKeys(ransomwarecoinsurancetxtbx, ransomwarecoinsurance, WaitStrategy.PRESENCE, "Ransomware coinsurance text box");
		//sendKeys(standardpremiumtxtbx, standardpremium, WaitStrategy.PRESENCE, "Standard Premium text box");
		return this;

	}
	
	//Method for Advanced Risk Control
	public CoveragePricingPage addAdvancedRisk(String count) {
		click(advancedriskcontroladdbtn, WaitStrategy.CLIKABLE, "Advanced Risk Control Add Button");
		return this;
		
	}
	
	public CoveragePricingPage removeAdvancedRisk(String rownum) {
		String advancedriskcontrolremovebtnxpath=DynamicXpathUtils.getXpath(advancedriskcontrolremovestring, rownum);
		click(By.xpath(advancedriskcontrolremovebtnxpath), WaitStrategy.CLIKABLE, "Advanced Risk Control Remove Button");
		return this;
		
	}

	//Method for Optional Coverage, Tax and Surcharge
	
	public boolean verifyNJPLIGALabel() {
		if(isElemnetPresent(njpligalabel, WaitStrategy.PRESENCE, "NJ PLIGA label")) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public PolicyFormPage optionalcoverageTaxAndSurchage() throws InterruptedException {
		Thread.sleep(2000);
		JavaScriptHelper.scrollDownVertically();
		Thread.sleep(2000);
		click(nextbtn, WaitStrategy.CLIKABLE, "Next Button");
		Thread.sleep(3000);
		return new PolicyFormPage();
	}
}
