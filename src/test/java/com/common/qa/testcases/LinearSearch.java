package com.common.qa.testcases;

public class LinearSearch {

	public static void main(String[] args) {
		int[] arr= {4,7,11,22,5,8,99,34};
		int res=findelement(arr,7);
		System.out.println("Element: "+"99"+ "found at"+res+"place");

	}

	private static int findelement(int[] arr, int x) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==x) {
				return i;
				}
		}
		return -1;

	}

}
