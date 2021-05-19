package com.framework.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;

import com.Framwork.enums.ConfigProperties;
import com.framework.constants.FrameworkConstants;
import com.framework.utils.PropertyUtils;


public class Driver {


	public static void initDriver() throws Exception {
		if(Objects.isNull(DriverManager.getDriver())) {
			System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
			DriverManager.setDriver(new ChromeDriver());
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}

	}

	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
