package com.sqa.rd.helpers;

import org.testng.*;
import org.testng.annotations.*;

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
	public void textDivisibleFile(int number, int divisor, boolean divisible) {
		try {
			boolean actualResult = isDivisible(number, divisor);
			Assert.assertEquals(actualResult, divisible, "Number is not divisible.");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	private boolean isDivisible(int number, int divisor) {
		// TODO Auto-generated method stub
		boolean isPrime = false;
		if (number % divisor == 0) {
			isPrime = true;
		}
		return isPrime;
	}
}
