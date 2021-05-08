package com.principle;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 객체 지향 4대원칙 캡슐화, 상속, 추상화, [다형성, 인터페이스]
 * 상위 객체에 하위 객체를 넣어서 여러 형태로 변환해 사용하는 것
 * 장점 : 여러 타입의 객체를 하나의 타입으로 관리가 가능하기 때문에 각각 정의하지 않아도 되므로 코드양이 줄어든다.
 * 
 * 인터페이스(interface)
 *  - 자바에서는 클래스를 통한 다중 상속은 지원하지않는다.
 *  - 다만, 인터페이스를 통해 다중 상속을 지원한다.
 *  - 다른 클래스를 작성할 때 기본이 되는 틀을 제공하면서, 다른 클래스 사이의 중간 매개 역할까지 담당하는 추상 클래스를 의미한다.
 *  - 인터페이스는 오로지 추상 메소드와 상수만을 포함할 수 있다.
 *  장점 : 다중상속이 가능하고, 대규모 프로젝트 시 일관되고 정형화된 개발이 가능, 개발시간 단축, 클래스마다 독립적인 프로그래밍 가능
 */

class Human {
	public void call() {
		System.out.println("Human Call");
	}
}

class Cheolsu extends Human {
	
	@Override
	public void call() {
		System.out.println("Cheolsu Call");
	}
	
	public void status() {
		System.out.println("Cheolsu Status");
	}
}

interface Champion {
	/* public static final 상수이름 = 상수값; */
	public abstract void call(); // abstract 는 생략가능
}

class Garen implements Champion {
	
	@Override
	public void call() {
		System.out.println("Garen Call");
	}
}

public class PolymorphismTest {
	
	public static void main(String[] args) {
		Human human = new Cheolsu();
		human.call();
		
		Champion champion = new Garen();
		champion.call();
		
		// 다형성의 예시
		Map<String, String> m = new HashMap<String, String>();
		Map<String, String> m2 = new LinkedHashMap<String, String>();
	}
}