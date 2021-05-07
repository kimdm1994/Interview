package com.principle;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 객체 지향 4대원칙 캡슐화, 상속, 추상화, [다형성]
 * 상위 객체에 하위 객체를 넣어서 여러 형태로 변환해 사용하는 것
 * 장점 : 여러 타입의 객체를 하나의 타입으로 관리가 가능하기 때문에 각각 정의하지 않아도 되므로 코드양이 줄어든다.
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
	public void call();
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