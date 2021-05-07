package com.keyword;

import java.util.Scanner;

public class TestFinal extends Test2 /* Test3 final class error */ {

	/*
	 * final 키워드
	 *  - final은 상수, 메서드, 클래스 3가지 경우에 같이 사용할 수 있다.
	 */
	
	/*
	 * 1. 상수정의에 사용
	 *  - 용도 : 상수에 언제든 값을 한번 저장하고 다음에 다시 바꾸지 않을때 사용한다.
	 *  - 형태 : final 타입 상수명
	 */
	private Scanner scanner = new Scanner(System.in);
	
	public void testMethod() {
		final int a;
		
		a = scanner.nextInt();
		// a = 10; 에러발생 (값을 변경할 수 없다.)
		
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		
//		new TestFinal().testMethod();
		System.out.println(x); // 1 static final var
	}
	

	// Oveeride(재정의) 테스트
	@Override
	public void test1() {
		// TODO Auto-generated method stub
		super.test1();
	}
	// public final void Test2 @Override 안 됨
	
	/*
	 * 4. static final
	 *  - static 은 클래스 변수이며, static final 은 객체(인스턴스)가 아닌 클래에서 존재하는 '단 하나의 상수'이다.
	 *  - 클래스에 존재하는 상수이므로 '선언과 동시에 초기화'를 해 주어야하는 클래스 상수이다. 
	 */
	static final int x = 1;
}

/*
 * 2. 메서드에 사용
 *  - 용도 : 오버라이딩(재정의)을 못하게 만든다.
 *  - 형태 : final 반환형 메서드명(매개변수) {}
 */
class Test2 {
	
	public void test1() {}
	public final void test2() {}
}

/*
 * 3. 클래스에 사용
 *  - 용도 : 상속을 못하게 만든다
 *  - 형태 : final class : 클래스명{}
 */
final class Test3 {
	int test;
}
