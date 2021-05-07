package com.str;

public class StringTypeTest {

	/*
	 * 1. String, StringBuffer, StringBuilder
	 * 
	 * 차이점 : String과 StringBuffer, StringBuilder 클래스들의 가장 큰 차이점은 String은 불변(immutable)의 속성을 갖는다. 
	 * 문제점 : String은 힙 메모리(Heap)에 많은 'Garbage가 생성'되어 힙 메모리 부족으로 성능에 치명적인 영향을 끼친다.
	 * 해결 : StringBuffer, StringBuilder -> 추가, 수정, 삭제가 가능, 가변(mutable) 성질을 가지고 있다.
	 */
	
	public static void main(String[] args) {
		
		/*
		 * 아래 예제에서 "hello" 값을 가지고 있던 String 클래스의 참조변수 str이 가리키는 곳에 저장된 "hello"에  "world" 문자열을 더해
		 * "hellow world" 로 변경한 것으로 착각할 수 있다.
		 * 하지만, 기존에 "hello" 값이 들어있던 str이 "hello world" 라는 값을 가지고 있는 '새로운 메모리영역을 가리키게 변경되고',
		 * 처음 선언했던 "hello" 로 값이 할당 되어 있던 메모리 영역은 Garbage로 남아있다가 GC(Garbage collection)에 의해 사라지게 된다.
		 * String 클래스는 불변하기 때문에 문자열을 수정하는 시점에서 '새로운 String 인스턴스가 생성'된 것이다.
		 */
		String str = "hello"; // String str = new String("hello"); -> GC에 의해 사라짐
		str = str + " world"; // [hello world] -> 새로운 인스턴스 생성
		
		System.out.println(str); // hello world
		
		/*
		 * 2. StringBuffer vs StringBuilder 
		 * 
		 * 공통점 : 동일한 API를 가지고 있다.
		 * 차이점 : 동기화의 유무
		 *  - StringBuffer는 동기화 키워드를 지원(멀티쓰레드 환경에서 안전(thread-safe)하다.
		 *  - String도 불변(immutable)성을 가지기 때문에 멀티쓰레드 환경에서의 안전성(thread-safe)을 가지고 있다.
		 *  - 반면, StringBuilder는 동기화를 지원하지 않기 때문에 멀티쓰레드 환경에서 사용하는 것은 적합하지 않지만 '단일 쓰레드'에서의 성능은 StringBuffer보다 뛰어나다.
		 * 
		 * 결론 : 단순히 성능만 놓고 본다면 연산이 많은 경우 (StringBuilder > StringBuffer >>> String)
		 * 
		 * String : 문자열 연산이 적고 멀티쓰레드 환경일 경우 
		 * StringBuffer : 문자열 연산이 많고 멀티쓰레드 환경일 경우 
		 * StringBuilder : 문자열 연산이 많고 단일쓰레드이거나 동기화를 고려하지 않아도 되는 경우
		 * 
		 * 출처 : dev-coco.tistory.com
		 */
	}
}
