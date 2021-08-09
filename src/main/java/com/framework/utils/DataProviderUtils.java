package com.framework.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.framework.constants.FrameworkConstants;

public final class DataProviderUtils {
	private static List<Map<String, String>> list=new ArrayList<Map<String,String>>();


	private DataProviderUtils() {

	}

	@DataProvider(parallel=true)
	public static Object[] getData(Method m) {
		String testname=m.getName();
		System.out.println("testname method:"+testname);
		if(list.isEmpty()) {
			list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationDataSheet());


		}
		List<Map<String, String>> smalllist= new ArrayList<Map<String,String>>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testname) 
					&& list.get(i).get("execute").equalsIgnoreCase("yes")){
				smalllist.add(list.get(i));
			}


		}

		return smalllist.toArray();


	}


}
