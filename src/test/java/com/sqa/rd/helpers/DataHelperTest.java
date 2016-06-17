package com.sqa.rd.helpers;

import org.testng.*;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import com.sqa.rd.helpers.data.*;

public class DataHelperTest {
	/* iddivisible test case check */
	@DataProvider(name = "textDivisible")
	public Object[][] getData1() {
		Object[][] data;

		data = DataHelper.getTextFileData("C:\\Users\\Richa\\workspace\\divisor-project\\src\\main\\resources\\",
				"data.csv", TextFormat.CSV, true, Integer.TYPE, Integer.TYPE, Boolean.TYPE);
		DisplayHelper.multArray(data);
		return data;
	}

	@Test(dataProvider = "textDivisible")
	public void textDivisibleFile(int num1, int num2, boolean divisible) {
		try {
			// System.out.println("Number " + num1 + ", is divisible by " + num2
			// + ")");
			boolean actualResult = isDivisible(num1, num2);
			Assert.assertEquals(actualResult, divisible, "Number is not divisible.");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	private boolean isDivisible(int num1, int num2) {
		// TODO Auto-generated method stub
		boolean isPrime = false;
		if (num1 % num2 == 0) {
			isPrime = true;
		}
		return isPrime;
	}
}
