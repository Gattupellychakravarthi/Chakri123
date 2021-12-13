package com.Vtiger.genericUtil;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewDataProvoider {
	@Test(dataProvider = "getvalue")
	public void print(String value1, String value2) {
		System.out.println(value1 + " " + value2);
	}
	@DataProvider
	public Object[][] getvalue() {

		Object arr[][] = new Object[4][2];
		arr[0][0] = "TYSS";
		arr[0][1] = "HYD";

		arr[1][0] = "TYSS";
		arr[1][1] = "Bangalore";

		arr[2][0] = "TYSS";
		arr[2][1] = "chennai";

		arr[3][0] = "TYSS";
		arr[3][1] = "pune";
		return arr;

	}
}
