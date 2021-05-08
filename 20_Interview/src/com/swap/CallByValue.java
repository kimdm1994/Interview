package com.swap;

public class CallByValue {
	
	/*
	 * Call by value (값에 의한 호출)
	 *  - 값이 바뀌지 않음
	 *  - swap() 메서드 호출 시에 사용한 인자 a, b와 swap() 메서드내의 매개변수 x, y는 서로 다르기 때문이다.
	 *  - 할당 된 메모리 변수에 각각 10과 20의 값이 저장 -> 이후, swap() 메서드 호출 시에 사용한 인자 a와 b는 할당 된 메모리 주소가 아닌
	 *    메모리에 담겨져 있는 값만이 복사되어 swap() 메서드 내부의 매개변수 x와 y의 메모리 주소에 담겨지게 된다.
	 *  - Call by value는 메서드 호출 시에 사용되는 인자의 메모리에 저장되어 있는 값(value)을 복사하여 보낸다.
	 *  
	 *  결론 : 자바는 기본형 데이터를 처리할 때 Call by value 형식으로 처리
	 *         객체 또한 메소드로 값이 전달 될 때 그 참조값은 Call by value 형태로 전달(Wrapper)
	 */
	public static void swap(int x, int y) {
		int temp = x;
		
		x = y;
		
		y = temp;
	}
	
	
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		System.out.println("호출 전 : " + "a = " + a + ", b = " + b ); // a = 10, b = 20
		
		swap(a, b);
		
		System.out.println("호출 후 : " + "a = " + a + ", b = " + b); // a = 10, b = 20
	}
}
