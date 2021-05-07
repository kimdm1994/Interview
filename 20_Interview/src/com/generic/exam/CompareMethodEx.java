package com.generic.exam;

public class CompareMethodEx {

	// 실습 예제
	public static void main(String[] args) {
		// 타입 파라미터 지정
		Pair<String, Integer> p1 = new Pair<String, Integer>("coco", 26);
		// 타입 파라미터 추정
		Pair<String, Integer> p2 = new Pair<>("coco", 26);
		// GenericMethod 호출
		boolean result = Util.compare(p1, p2);
		System.out.println(result);

		Pair<String, Integer> p3 = new Pair<>("coco", 26);
		Pair<String, Integer> p4 = new Pair<>("Jack", 30);

		result = Util.compare(p3, p4);
		System.out.println(result);
	}
}
