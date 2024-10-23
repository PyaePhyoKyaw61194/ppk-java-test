package com.ppk.test;

public class DecimalPointFormatter {
	public double process(int amount, int point) {
		if (point < 0) {
			throw new IllegalArgumentException("Point must be grater than zero");
		}

		double decimalVal = amount / Math.pow(10, point);
		return decimalVal;

	}

	public static void main(String[] args) {
		DecimalPointFormatter formatter = new DecimalPointFormatter();

		int[][] testCases = { { 12345, 0 }, { 12345, 2 }, { 12345, 5 }, { 12345, 7 }, { -12345, 3 } };

		for (int[] testCase : testCases) {
			int amount = testCase[0];
			int point = testCase[1];

			if (point == 0) {
				System.out.println(amount);
				continue;
			}
			try {
				double res = formatter.process(amount, point);
				System.out.println(res);
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}
