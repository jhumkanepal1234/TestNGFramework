package com.syntax.practice;

import org.testng.annotations.Test;

import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class ExcelFunctionsTest {

	@Test
	public void excelTest() {

		ExcelUtility obj = new ExcelUtility();
		obj.openExcel(Constants.XL_FILEPATH, "EmployeeDetails");

		// retreive all value from excel and store into DataProvider (2D object array)
		int row = obj.getRowNum();
		int cell = obj.getColNum(0);
		Object[][] data = new Object[row][cell];

		for (int i = 1; i < row; i++) {
			for (int y = 0; y < cell; y++) {
				// retrieve value form excel
				String value = obj.getCellData(i, y);
				// store insie 2D array
				data[i][y] = value;
			}
		}
		System.out.println(data.length);

	}
}