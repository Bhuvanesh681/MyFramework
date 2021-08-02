package com.framework.driver;

import java.net.MalformedURLException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import com.framework.exception.BrowserInvocationFailedException;
import com.framework.factories.DriverFactory;
import com.framework.utils.PropertyUtils;
import com.Framwork.enums.ConfigProperties;


/**
 * 
 * @author BSikarwar
 *
 */

public class Driver {


	public static void initDriver(String browser)  {
		if(Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailedException("Browser Invocation failed. Please check the capabilities");
			}
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
