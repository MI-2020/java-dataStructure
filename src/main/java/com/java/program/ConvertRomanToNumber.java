package com.java.program;

import java.util.HashMap;
import java.util.Map;

// Convert Roman to Number
public class ConvertRomanToNumber {

	static Map<String, Integer> map = new HashMap<>();

	void printInNumber(String[] romanArry) {

		int bigNumber = 0;
		boolean check = true;
		StringBuilder roman = new StringBuilder();

		String prev = "";

		for (String romanNo : romanArry) {

			if (map.containsKey(roman.append(romanNo).toString()) && check) {

				bigNumber = map.get(roman.toString());
			} else {
				check = false;
				if (prev.equals("I") && (romanNo.equals("X") || romanNo.equals("V"))) {
					bigNumber = bigNumber + map.get(romanNo) - 2;
				} else {
					bigNumber = bigNumber + map.get(romanNo);
				}

			}
			prev = romanNo;
		}
		System.out.println(bigNumber);

	}

	public static void main(String[] args) {

		map.put("I", 1);
		map.put("II", 2);
		map.put("III", 3);
		map.put("IV", 4);
		map.put("V", 5);
		map.put("VI", 6);
		map.put("VII", 7);
		map.put("VIII", 8);
		map.put("IX", 9);
		map.put("X", 10);
		map.put("XX", 20);
		map.put("XXX", 30);
		map.put("XL", 40);
		map.put("L", 50);
		map.put("LX", 60);
		map.put("LXX", 70);
		map.put("LXXX", 80);
		map.put("LC", 90);
		map.put("C", 100);

		new ConvertRomanToNumber().printInNumber(new String("XLVII").split(""));// 48

	}
}
