package com.generic.exam;

public class Util {
	// Generic Method
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {

		// compare(Key, Value)
		boolean keyCompare, valueCompare;

		keyCompare = p1.getKey().equals(p2.getKey());
		valueCompare = p1.getValue().equals(p2.getValue());

		return keyCompare && valueCompare;
	}
}