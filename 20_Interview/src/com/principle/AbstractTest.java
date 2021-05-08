package com.principle;

import java.util.ArrayList;

public class AbstractTest {

	/* 객체 지향 4대원칙 캡슐화, 상속, [추상화], 다형성
	 * 
	 * 추상클래스
	 *  - 객체를 직접 생성할 수 있는 클래스를 실체클래스라고 한다면
	 *  - 클래스들의 '공통적인 특성'을 추철해서 선언한 클래스를 추상클래스라고 한다.
	 *  - 추상클래스가 부모, 실체클래스가 자식으로 상속관계를 통해 추상클래스의 모든 특성을 물려받는 형태로 쓰인다.
	 *  - 실체 클래스들의 공통된 필드와 메소드의 이름을 통일할 목적
	 *  - 실체 클래스를 작성할 때 시간을 절약
	 */
	
	public static void main(String[] args) {
		
		ArrayList<Car> carList = new ArrayList<>();
		
		carList.add(new Sonata());
		
		for (Car car : carList) {
			car.run();
		}
	}
}

class Sonata extends Car {
	
	@Override
	public void start() {
		System.out.println("시동 킨다.");
	}

	@Override
	public void drive() {
		System.out.println("달린다.");
	}

	@Override
	public void stop() {
		System.out.println("멈춘다.");
	}

	@Override
	public void turnoff() {
		System.out.println("시동 끈다");
	}
}

abstract class Car {
	
	public abstract void start();
	public abstract void drive();
	public abstract void stop();
	public abstract void turnoff();
	
	final public void run() {
		start();
		drive();
		stop();
		turnoff();
	}
}

