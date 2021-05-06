package com.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class TcpListExample {
	// List 컬렉션 클래스 [ ArrayList<E>, LinkedList<E>, Vector<E>, Stack<E> ]
	// 1. 요소의 저장 순서가 유지된다.
	// 2. 같은 요소의 중복 저장을 허용한다.
	
	public static void main(String[] args) {
		
		/*
		 * 1. ArrayList<E> 클래스
		 *  - 가장 많이 사용되는 컬렉션 클래스
		 *  - 내부적으로 배열을 이용하여 요소를 저장
		 *  - 배열의 크기를 변경할 수 없는 인스턴스이므로, 크기를 늘리기 위해 새로운 배열을 생성하고 
		 *    기존의 요소를 옮겨야 하는 과정을 거쳐야 한다.
		 *    
		 * 2. LinkedList<E> 클래스
		 *  - ArrayList 클래스가 배열을 이용하여 저장함으로써 발생하는 단점을 극복하기 위해 고안되었다.
		 *  - 배열은 순차적인 반면, LinkedList는 요소가 비순차적으로 분포, 이러한 요소들 사이를 Link로 연결하여 구성
		 *  - 나머지는 동일
		 * 
		 * 3. Vector<E> 클래스
		 *  - Vector 클래스는 ArrayList 클래스와 같은 동작을 수행
		 *  - Vector 클래스보다는 ArrayList 클래스를 사용하는 것이 좋음.
		 */
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		// add() 삽입
		arrList.add(40);
		arrList.add(20);
		arrList.add(30);
		arrList.add(10);
		
		System.out.println("1. add()");
		
		// get() 출력
		for(int i = 0; i < arrList.size(); i++) {
			System.out.print(arrList.get(i) + " "); // 40 20 30 10
		}
		
		System.out.println("\n");
		System.out.println("2. get()");
		
		// remove() 삭제
		arrList.remove(1); // arrList[0] : 20
		
		for (int arr : arrList) {
			System.out.print(arr + " ");
		}
		
		System.out.println("\n");
		System.out.println("3. remove()");
		
		// Collections.sort() 정렬
		Collections.sort(arrList);
		
		Iterator<Integer> iter = arrList.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		
		System.out.println("\n");
		System.out.println("4. Collections.sort()");
		
		// set(index, value) 요소 변경
		arrList.set(0, 20);
		
		for (int arr3 : arrList) {
			System.out.print(arr3 + " ");
		}
		
		System.out.println("\n");
		System.out.println("5. size()");
		
		// size()로 개수 구하기
		System.out.println("리스트의 크기 : " + arrList.size());
	}
}
