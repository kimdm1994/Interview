package com.principle;

public class ClassTest {

	/*
	 * 클래스는 하나의 설계도이다.
	 *  - 멤버변수, 메소드, 내부 클래스 등이 존재할 수 있다.
	 *  - 클래스라는 설계도를 통해 실체화한 것이 인스턴스(Instance)이다.
	 *  
	 *  여기서, 객체(Object)는 소프트웨어 세계에 구현할 대상
	 *  이를 구현하기 위한 설계도가 클래스(Class)
	 *  이 설계도에 따라 구현된 실체가 인스턴스(instance)이다.
	 *  
	 * 클래스의 인스턴스화 예시)
	 * 클래스명 변수명 = new 클래스명();
	 * Tv t = new Tv(); -> 참조변수 t가 TV라는 인스턴스를 가리키고 있다.(인스턴스는 오직 참조변수를 통해서만 다룰 수 있다.)
	 */
	
	// 멤버변수, 인스턴스 변수
	int age;
	
	// 기본 생성자
	public ClassTest() {
	}
	
	// 매개변수가 있는 생성자
	public ClassTest(int age) {
		this.age = age;
	}

	// Getters and Setters
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	// 메소드
	void eat() {
		System.out.println("냠냠");
	}

	// toString()
	@Override
	public String toString() {
		return "ClassTest [age=" + age + "]";
	}
	
}
