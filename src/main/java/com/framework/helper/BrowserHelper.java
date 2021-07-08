package com.framework.helper;

import java.util.LinkedList;
import java.util.Set;

import com.framework.driver.DriverManager;

public class BrowserHelper {

	

	//public static Logger Log=Logger.getLogger(VerificationHelper.class);
	//Page refresh
	public static void refreshWebPage()  {
		DriverManager.getDriver().navigate().refresh();	
	}
	
	//Navigate Forward
	public static void navigatetoForward()  {
		DriverManager.getDriver().navigate().forward();	
	}
	
	//Navigate Backward
	public static void navigatetoBackward()  {
		DriverManager.getDriver().navigate().back();	
	}
	
	public Set<String> getWindowHandlens() {
		//Log.info("");
		return DriverManager.getDriver().getWindowHandles();
	}

	public void SwitchToWindow(int index) {

		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());

		if (index < 0 || index > windowsId.size()){
			throw new IllegalArgumentException("Invalid Index : " + index);
		}
		DriverManager.getDriver().switchTo().window(windowsId.get(index));
		//Log.info(index);
	}

	public void switchToParentWindow() {
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());
		DriverManager.getDriver().switchTo().window(windowsId.get(0));
		//Log.info("");
	}

	public void switchToParentWithChildClose() {
		LinkedList<String> windowsId = new LinkedList<String>(getWindowHandlens());

		for (int i = 1; i < windowsId.size(); i++) {
			//Log.info(windowsId.get(i));
			DriverManager.getDriver().switchTo().window(windowsId.get(i));
			DriverManager.getDriver().close();
		}

		switchToParentWindow();
	}
}
