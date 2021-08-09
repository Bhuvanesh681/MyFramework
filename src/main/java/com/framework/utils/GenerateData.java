package com.framework.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateData {

	public String generateBusinessName() {
		  String allowedChars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		  String allowednums="1234567890";
		  String allowedspecial="'+&/:";
		  String businessName="";
		  String temp1=RandomStringUtils.random(3,allowedChars);
		  String temp2=RandomStringUtils.random(4,allowedChars);
		  String temp3=RandomStringUtils.random(3,allowednums);
		  String temp4=RandomStringUtils.random(7,allowedChars);
		  String temp5=RandomStringUtils.random(1,allowedspecial);
		  String temp6=RandomStringUtils.random(5,allowedChars);
		 // businessName=temp.substring(0,temp.length());
		  businessName=temp1+" "+temp2+" "+temp3+" "+temp4+temp5+temp6;
		  return businessName;	  
		  
		}
	
	
}

