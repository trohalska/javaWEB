package com.epam.training;

import java.util.Arrays;

public class Demo {
	private static final boolean isDebug = false;

	public static void main(String[] args) {
		int[] values = { 1, 2, 3, 4, 5, 6, 7 };
		for (int i = 1; i < values.length; i += 2) {
			int t = values[i - 1];
			values[i - 1] = values[i];
			values[i] = t;
			if (isDebug) {
				System.out.println("v[" + (i-1) + "]" + values[i-1] + ", v[" + (i) + "] " + values[i]) ;
			}
		}
	}
}
