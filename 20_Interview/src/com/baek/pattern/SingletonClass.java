package com.baek.pattern;

import java.util.function.Supplier;

public class SingletonClass {

	/*
	 * 출처 : https://www.crocus.co.kr/
	 */
	public static final SingletonClass INSTANCE = new SingletonClass();
	
	// 1. @Test 중복 에러 해결을 위해 수정
	//	private SingletonClass() {
	//		if (INSTANCE != null) {
	//			throw new RuntimeException("INSTANCE can not be duplicated.");
	//		}
	//	}
	
	// 2.정적 팩토리 방식의 싱글턴
	private SingletonClass() {}
	
	public static SingletonClass getInstance() {
		return INSTANCE;
	}
	
	// 팩토리 메서드만 수정하면 언제든지 싱글톤이 아니게 바꿀 수 있으며, 제네릭 싱글턴 팩터리로 만듦으로써 타입에 유연하게 대처할 수 있다.
	// 또한, static 팩토리 메소드를 Supplier에 대한 메소드 레퍼런스로 사용할 수도 있다.
	Supplier<SingletonClass> sc = SingletonClass::getInstance;
	
	// enum으로 만드는 싱글턴은 가장 안전하고 좋은 방법이다. 복잡한 직렬화 상황이나, 리플렉션 공격에도 안전하다.
	// 단, 만들려는 싱글턴이 Enum 이외의 클래스를 상속해야 한다면 이 방법을 사용할 수 없다.
	// (열거 타입이 다른 인터페이스를 구현하도록 하는 건 가능.)
	// enum : 열거형이라고 부르며, 서로 연관된 상수들의 집합, 클래스라서 생성자도 가질 수 있다.
	// enum Rainbow { RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET }
	public enum Singleton {
		INSTANCE;
	}
	
}
