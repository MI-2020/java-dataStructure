package com.java.program;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapSortByValue {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();

		map.put("A", 10);
		map.put("B", 40);
		map.put("C", 30);
		map.put("D", 20);

		Set<Entry<String, Integer>> entrySet = map.entrySet();
		List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(entrySet);

		Collections.sort(entryList, (o1, o2) -> o2.getValue() - o1.getValue());

		for (Entry<String, Integer> entry : entryList)
			System.out.println(entry.getValue());
	}
}
