package com.keyword;

public class TestStatic {
	
	/*
	 * 예제로 이해하기 출처 : https://blog.naver.com/goddlaek/220888359923
	 * 멤버 변수는 클래스 영역에 선언된 변수를 말하고, '클래스 변수, 인스턴스 변수'가 있다
	 * 클래스 변수는 'static'이 붙어있는 변수를 말하고, 값을 공유하는 변수이다. (정적이라는 뜻을 가지며, 변하지 않는 값을 뜻한다.)
	 * 'final' 은 상수, 메소드, 클래스를 정의한 뒤 값을 재정의하지 못하게 할 때 사용한다.
	 * 'static final' 은 클래스에 존자해는 하나의 상수이며, 선언과 동시에 초기화를 해주어야한다.
	 */
	
	static int testVal = 1; // static value
	int val = 3; // instance value
	
	// static method
	public static void testMethod() {
		System.out.println("test");
	}
	
	public static void main(String[] args) {
		// System.out.println(val); static method 안에서는 외부의 static 멤버에만 접근이 가능하다.
		System.out.println("static int testVal : " + testVal);
		System.out.println("Test class static int a : " + Test.a);
		
		Test.print(); // static method 입니다.
		testMethod(); // test
		
		Test test = new Test();
		System.out.println("Test class int b : " + test.b); // 1
		
		Test test2 = new Test();
		System.out.println("Test class int a : " + test.a); // 2
		System.out.println("Test class int b : " + test.b); // 1
		
		// static 변수 a는 객체를 생성하기 전부터 0을 가지고 있다가 객체 생성자에 의해 1씩 3번 증가가 되었고, (a = 1 씩 증가)
		// b 는 각 인스턴스가 생성될 때 0으로 초기화 됐다가 생성자에 의해 1씩 증가했기 때문이다. (b = 1)
		// 결론 : 한 클래스의 static 변수는 Class 영역에 저장되어 있어 어떤 인스턴스든 모두 똑같은 값을 가진다.
		Test test3 = new Test();
		System.out.println("Test class int a : " + test.a); // 3
	}
}

class Test {
	
	static int a = 0;
	int b = 0;
	
	Test() {
		a++;
		b++;
	}
	
	static void print() {
		System.out.println("static method 입니다.");
	}
}
