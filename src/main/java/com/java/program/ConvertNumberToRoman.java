package com.java.program;

import java.util.HashMap;
import java.util.Map;
 
public class ConvertNumberToRoman {

	static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}

	void printInNumber(String romanArry) {

		int result = 0;
		int prevNumber = 0;

		for (char romanNo : romanArry.toCharArray()) {

			Integer number = map.get(romanNo);
			if (number == null) {
				System.out.println("Number is Invalid!!!");
				return;
			}

			if (prevNumber < number) {
				result = result + number - 2 * prevNumber;

			} else {
				result = result + number;
			}

			prevNumber = number;

		}
		System.out.println(result);
	}

	public static void main(String[] args) {

		new ConvertNumberToRoman().printInNumber("MCMXCV");// 1995
	}
}
