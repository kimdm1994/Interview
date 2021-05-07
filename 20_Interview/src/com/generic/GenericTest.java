package com.generic;

import java.util.ArrayList;

public class GenericTest {
	/*
	 * 제네릭 사용법
	 * 제네릭 주요 개념(바운디드 타입, 와일드 카드)
	 * 제네릭 메소드 만들기
	 * Erasure
	 * 
	 * 제네릭(Generic)은 Data type을 특정한 type 하나로 정하지 않고 사용할 때마다 바뀔 수 있게 범용적이고 포괄적으로 지정한다.
	 * 제네릭 타입은 <>을 가지는 클래스와 인터페이스를 말한다.
	 * 
	 * 사용이유 : 잘못된 타입이 사용될 수 있는 문제를 '컴파일 과정에서 제거'할 수 있다.
	 *            실행 시 타입 에러가 나는것보다는 '컴파일 시에 에러를 사전에 방지'하는 것이 좋다.
	 *            제네릭 코드를 사용하면 타입을 국한하기 때문에 요소를 찾아올 때 '타입변환을 할 필요가 없어 프로그램 성능이 향상'된다.
	 * 
	 * 제네릭 장점
	 *  1. 타입 안정성 제공
	 *    - 컴파일 타임에 타입 체크를 하기 떄문에 런타임에서 ClassCastException과 같은 UncheckedException을 보장받음
	 *  2. 타입체크와 형변환 생략 가능
	 *    - 코드가 간결해짐
	 *    
	 * 제네릭 특징
	 *  1. 모든 객체에 대해 동일하게 동작해야하는 static 멤버에 타입 변수 T를 사용할 수 없다.
	 *    - T는 인스턴스변수로 간주되기 때문이다.
	 *    - static 멤버는 인스턴스변수를 참조할 수 없다.
	 *  2. 제네릭 타입의 배열을 생성하는 것도 허용되지 않는다.
	 *    - 제네릭 배열 타입의 참조변수를 선언하는 것은 가능하지만, new T[10]과 같이 배열을 생성하는 것은 안된다.
	 *      이유는 new 연산자 때문이다. 이 연산자는 컴파일 시점에 타입 T가 무엇인지 명확히 알아야 하기 때문이다.
	 *  * 꼭 제네릭 배열을 생성해야 할 필요가 있을 땐 new 연산자 대신 'Reflection API'의 new Instance()와 같이 
	 *    동적으로 객체를 생성하는 메소드로 생성하거나, Object 배열을 생성해서 형변환 하는 방법 등 사용
	 *    
	 * 제네릭 사용법
	 *  - public class 클래스명<T> {...}
	 *  - public interface 인터페이스명<T> {...}
	 *  - 제네릭 타입은 타입을 파라미터로 가지는 클래스와 인터페이스를 말한다.
	 *  - 제네릭 타입은 클래스 또는 인터페이스 이름 뒤에 <> 부호가 붙고 사이에 타입 파라미터가 위치한다.
	 *  - <T> : Type           [정해진 규칙은 없지만 대문자 알파벳 한글자로 표현]
	 *  - <E> : Element
	 *  - <K> : Key
	 *  - <N> : Number
	 *  - <V> : Value
	 *  - <R> : Result
	 *  
	 * 제네릭 주요 개념
	 *  - 한정적 타입 매개변수(Bounded Type)
	 *  - 타입 파라미터들은 바운드(bound) 될 수 있다.
	 *  - 바운드 된다는 것은 제한된다는 의미인데 '메소드가 받을 수 있는 타입을 제한할 수 있다'는 것이다.
	 *  
	 * 제네릭 와일드 카드
	 *  - 코드에서 ?를 일반적으로 와일드카드라고 부른다.
	 *  - <?> : 타입 파라미터를 대치하는 것으로 모든 클래스나 인터페이스타입이 올 수 있다.
	 *  - <? extends 상위타입> : 객체의 하위 클래스만 올 수 있다.
	 *  - <? extends 하위타입> : 객체의 상위 클래스만 올 수 있다.
	 *  
	 * 제네릭 메소드
	 *  - 제네릭 메소드는 '매개 타입과 리턴 타입으로 타입 파라미터를 갖는 메소드'를 말한다.
	 *  - public <타입 파라미터 ...> 리턴타입 메소드명(매개변수, ...) {...} -> public <T> Box<T> boxing(T t) {...}
	 *  - 호출방법
	 *    1. 리턴타입 변수 = <구체적 타입> 메소드명(매개값); -> Box<Integer> box = <Integer>boxing(100);
	 *    2. 리턴타입 변수 = 메소등명(매개값); -> Box<Integer> box = boxing(100); // 타입 파라미터를 Integer로 추정, 일반적으로 사용
	 *    
	 * Erasure
	 *  - 제네릭 타입의 안정성을 보장하며 실행시간에 오버헤드가 발생하지 않도록 하기 위해 추가되었다.
	 *  - 컴파일러는 제네릭 타입을 이용하여 소스파일을 체크하고 필요한 곳에 형변환을 넣어준다. 그리고 '제네릭 타입을 제거'한다.
	 *    - 제네릭 타입이 <T extends Fruit> 라면 T -> Fruit로 치환
	 *    - <T>인 경우 T -> Object로 치환
	 *    - 클래스 옆의 선언은 제거
	 *  
	 *  ex) 
	 *  1. 변경전
	 *  class Box<T extends Fruit> {
	 *  	void add(T t) {...}
	 *  }
	 *  2. 변경후
	 *  class Box {
	 *  	void add(Fruit t) {...}
	 *  }
	 *  3. 제네릭 타입을 제거 후 타입이 일치하지 않으면, 형변환을 추가
	 *  T get(int i) {
	 *  	return list.get();
	 *  }
	 *  
	 *  Fruit get(int i) {
	 *  	return (Fruit) list.get(i);
	 *  }
	 */
	
	public static void main(String[] args) {
		
		// 1. 제네릭을 사용하지 않을 경우 -> 타입 변환이 필요하다.
		ArrayList list = new ArrayList();
		list.add("test");
		
		String temp = (String) list.get(0);
		System.out.println(temp);
		
		// 2. 제네릭을 사용할 경우 -> 타입 변환이 필요없다.
		ArrayList<String> list2 = new ArrayList();
		list2.add("test2");
		String temp2 = list2.get(0);
		System.out.println(temp2);
		
		MultiGenetricTest<String, Integer, Double> genericTest = new MultiGenetricTest<>();
		genericTest.setFirst("안녕하세요");
		genericTest.setSecond(10);
		genericTest.setThird(0.01);
		
		genericTest.show();
	}
}

// 제네릭 클래스           
// - Bounded Type : <T extends Number> -> ExGeneric의 타입으로 Number의 서브 타입만 허용한다.(문자열 전달 시 컴파일 에러)
class ExGeneric<T /*extends Number*/> {
	private T t;

	public void setT(T t) {
		this.t = t;
	}
	
	public T getT() {
		return t;
	}
}

// 제네릭 인터페이스
interface ExInterfaceGeneric<T> {
	T example();
}

class ExGeneric2 implements ExInterfaceGeneric<String> {
	
	@Override
	public String example() {
		// TODO Auto-generated method stub
		return null;
	}
}

class MultiGenetricTest<A, B, C> {
	private A first;
	private B second;
	private C third;
	
	public MultiGenetricTest() {
		// TODO Auto-generated constructor stub
	}
	
	public A getFirst() {
		return first;
	}
	public void setFirst(A first) {
		this.first = first;
	}
	public B getSecond() {
		return second;
	}
	public void setSecond(B second) {
		this.second = second;
	}
	public C getThird() {
		return third;
	}
	public void setThird(C third) {
		this.third = third;
	}
	
	public void show() {
		System.out.println("A의 타입은 : " + first.getClass().getTypeName());
		System.out.println("B의 타입은 : " + second.getClass().getTypeName());
		System.out.println("C의 타입은 : " + third.getClass().getTypeName());
	}
	
}