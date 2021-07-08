package com.framework.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.framework.constants.FrameworkConstants;
import com.framework.utils.ExcelUtils;

public class MetholdInterceptor implements IMethodInterceptor {

	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		List<Map<String, String>> list1 = ExcelUtils.getTestDetails(FrameworkConstants.getRunManagerSheet());
		List<IMethodInstance> result=new ArrayList<IMethodInstance>();

		for(int i=0;i<methods.size();i++) {
			for(int j=0;j<list1.size();j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list1.get(j).get("testname")) &&
					list1.get(i).get("execute").equalsIgnoreCase("yes")) {
						methods.get(i).getMethod().setDescription(list1.get(j).get("testdescription"));
						//methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list1.get(j).get("count")));
						//methods.get(i).getMethod().setPriority(Integer.parseInt(list1.get(j).get("priority")));
						result.add(methods.get(i));
					}
				

			}
		}
		return result;
	}



}
