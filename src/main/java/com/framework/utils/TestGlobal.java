package com.framework.utils;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.driver.DriverManager;



public class TestGlobal {
	
	
	public static Actions actObj;
	public static JavascriptExecutor js;
	public static DateTimeFormatter dtf;
	
	
	
	//Click on Button
		public static void buttonClick(WebElement element)  {
			try {
				if (element != null) {
				element.click();	
				}
				
		  }catch(Exception e) {System.out.println(e);}
			
		}
		
		//Enter text to Text Field
		public static void sendKeys(WebElement element, String value) {
	        
	        try {
	            element.sendKeys(value);
	        } catch (Exception e) {
	            System.out.println(String.format("Error in sending [%s] to the following element: [%s]", value, element.toString()));
	        }
	    }
		
		//getText
		public static String readData(WebElement element)  {
			String val=null;;
			try {
				if (element != null) {
				val=element.getText();
				}
				
		  }catch(Exception e) {System.out.println(e);}
			
			return val;
			
		}
		
		//Select All CheckBoxes in A Page
		public static void selectAllCheckBox(List <WebElement> AllCheckBoxes) {
		 AllCheckBoxes = DriverManager.getDriver().findElements(By.xpath("//input[@type='checkbox']"));
		 System.out.println("Number of Check boxes : "+ Integer.toString(AllCheckBoxes.size()));
	         
		 try {
			 for(WebElement cb:AllCheckBoxes)
		    {
		        cb.click();
		    }
		    System.out.println("All check boxes have been checked");
	      }catch (Exception e) {
	          System.out.print(e);
	      }
		
	    }
		
		//Select a Radio Button
		public static void radioButtonClick(WebElement radioButton)  {
			try {
				
				if (radioButton != null  && radioButton.isEnabled()==true ) {
					radioButton.click();	
				}
				
		  }catch(Exception e) {System.out.println(e);}
			
		}
	   
		//Select a Checkbox
		public static void selectCheckBox(WebElement checkbox)  {
			try {
				if (checkbox != null && checkbox.isSelected()==false ) {
					checkbox.click();	
				}
				
		  }catch(Exception e) {System.out.println(e);}
			
		}
		
		//Clear a TextField
	    public static void clearField(WebElement element) {
	        try {
	            element.clear();
	        } catch (Exception e) {
	            System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
	        }
	    }

		//Switch to WindowHandle
		public static void switchToNewWindows() {
			
			Set<String> allwindow = DriverManager.getDriver().getWindowHandles();
			for(String eachwindow:allwindow) {
				try {
				DriverManager.getDriver().switchTo().window(eachwindow);
				} catch (NoSuchWindowException e) {
				System.out.println("Window is not present" +e);
				}
			}
			
		}
		

		//Switch to Frame
		public static void switchToFrame(WebElement frameid,int EXPLICIT_WAIT_TIME ) {
			
			try {
				WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), EXPLICIT_WAIT_TIME);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameid));
				DriverManager.getDriver().switchTo().frame(frameid);
				} catch (NoSuchFrameException e) {}
		}
		
		
		//Switch to parent Frame
		
		public static void switchToParentFrame() {
			
			try {
				DriverManager.getDriver().switchTo().parentFrame();
				} catch (NoSuchFrameException e) {}
		}
		
		//Switch to Main Frame
		public static void switchToMainFrame() {
				
				try {
					DriverManager.getDriver().switchTo().defaultContent();
					} catch (NoSuchFrameException e) {}
		}
			
	
		//Sleep -Not Recommended to use unless absolutely required
		public static void sleepDuringExecution(long SLEEP_TIME) {
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
		//getCurrentDate in specificFormat-MMddyyyy
		public static String getCurrentDate() {
			dtf = DateTimeFormatter.ofPattern("MMddyyyy");
			LocalDateTime now = LocalDateTime.now();
			return (dtf.format(now));
		}
		
		//getCurrentDate in specificFormat-MMddyyyyhhmmss
			public static String getCurrentDateWithTime() {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")  ;
				   LocalDateTime now = LocalDateTime.now();  
				   return (dtf.format(now).toString());
				}
				
		
		//Generate random integers in range 0 to 999 
		public static int generateRandomNumber() {
			Random rand = new Random(); 
			  
	        int rand_int1 = rand.nextInt(85000);
	        return rand_int1;
		}
			 
		
	   //Select Dropdown by text
		public static void selectDropdownUsingVisibleText(WebElement locator,String value) {
			
			Select select=new Select(locator);
			select.selectByVisibleText(value);
		}
		
		//Select Dropdown by Index
		public void selectDropdownUsingIndex(WebElement locator, int index){
			Select select = new Select(locator);
			select.selectByIndex(index);
		}
		
		//Select dropdownUsing Value	
		public static void selecDropsDownUsingValue(WebElement locator, String value){
			Select select = new Select(locator);
			select.selectByValue(value);
		}
		
		//Select All Values of Dropdown
		public List<String> getAllDropDownValues(WebElement locator) {
			Select select = new Select(locator);
			List<WebElement> elementList = select.getOptions();
			List<String> valueList = new LinkedList<String>();
			
			for (WebElement element : elementList) {
				
				valueList.add(element.getText());
			}
			return valueList;
		}
		
		//Get Selected value
		public String getSelectedValue(WebElement element) {
			String value = new Select(element).getFirstSelectedOption().getText();
			
			return value;
		}
		
		//Select from MultiSelectdropdown/List dropdown
		
		public void selectMultipleValue(WebElement element,ArrayList optionstobeselected) {
	
	        Select select = new Select(element);
            for(int i=0;i<optionstobeselected.size();i++) {
	        select.selectByVisibleText(optionstobeselected.get(i).toString());
            }
	
		}
		
			
		
		//Scroll UP/DOWN
		public static void scrollUP() {
			
			js=(JavascriptExecutor) DriverManager.getDriver();
			//Use -450 for two scrolls up. For two scrolls down use 450
			js.executeScript("window.scrollBy(0,450)");
		}
		
		public static void buttonClickUsingJS(WebElement element) {

			JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
			executor.executeScript("arguments[0].click();", element);
		}
		
		// Scroll till object view
		public static void doScrollTillObjView(WebElement element) {

			JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

			js.executeScript("arguments[0].scrollIntoView();", element);

		}
		
		public static void doScrollWindowDownCompletely() {

			JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			// Actions act = new Actions(DriverManager.getDriver());
			// act.sendKeys(Keys.PAGE_DOWN).build().perform();

		}

		//Wait for Element to be Clickable
		public static void waitForElementClickable(WebElement element, int timeOutInSeconds) {
			//log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeOutInSeconds);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			//log.info("element is clickable now" + element);
		}

		//Wait for URL Match
		public void waitForURLMatches(String url, int timeOutInSeconds) {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeOutInSeconds);
			wait.until(ExpectedConditions.urlMatches(url));
		}

		//Wait for Element to be Invisible
		public static boolean waitForElementHide(WebElement element, int timeOutInSeconds) {
			//log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeOutInSeconds);
			return wait.until(ExpectedConditions.invisibilityOf(element));
		}

		//Wait for Element to be Visible
		public static void waitForElementVisible(WebElement element, int timeOutInSeconds) {
			//log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		
		//Convert double to string
		public static String convertDoubleToString(double value) {
			String str = String.format("%f", value);
			String strValue = str.split("\\.")[0];
			return strValue;
		}
		
		//Covert Number to Currency	
		public static String numberToCurrencyConverter(double number) {
			NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
			String currency = format.format(number);
			String strValue = currency.split("\\.")[0];
			System.out.println("Value in currency format is : " + strValue);
			return strValue;
		}
	    
		//Number to Currency Converter
		public static String numberToCurrencyConverterDoubleDecimal(double number) {
			NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
			String currency = format.format(number);
			System.out.println("Value in currency format is : " + currency);
			return currency;
		}
		
		
		//Convert String to Integer
		public static int stringToInteger(String stringValue) {
			
			int number=Integer.parseInt(stringValue);
			return number;
		}
		
		//MoseHover
		public static void MouseOver(WebElement element){
					
			actObj=new Actions(DriverManager.getDriver());
			actObj.moveToElement(element).build().perform();
		}	
		
		//Merge Multiple DataProviders
		
		public static String removedotFromString(String s) {
			
			int index=s.indexOf(".");
			if (index>0) {
				s=s.substring(0,index);
				
			}
			return s;
		}


}
