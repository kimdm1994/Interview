package com.swap;

public class CallByReference {

	/*
	 * Call by reference
	 *  - 값이 아닌 주소(Address)를 넘겨줌으로써, 주소를 참조(Reference)하여 데이터를 변경
	 *  - Call by reference는 메서드 호출 시 사용되는 인자 값의 메모리에 저장되어있는 주소(Address)를 복사하여 보낸다.
	 *  
	 *  결론 : 객체를 메소드로 넘길 때 객체를 참조하는 지역변수의 실제 주소를 넘기는 것이 아니라 그 지역변수가 가리키고 있는 힙 영역의 객체를
	 *         가리키는 새로운 지역변수를 생성하여 그것을 통하여 같은 객체를 가리키도록 하는 방식
	 */
	int value; // 전역 변수
	
	public CallByReference() {
	}
	
	public CallByReference(int value) {
		this.value = value;
	}

	public static void swap(CallByReference x, CallByReference y) {
		int temp = x.value;
		x.value = y.value;
		y.value = temp;
	}
	
	public static void main(String[] args) {
		CallByReference a = new CallByReference(10);
		CallByReference b = new CallByReference(20);
		
		System.out.println("호출 전 : a = " + a.value + ", b = " + b.value);
		
		swap(a, b);
		
		System.out.println("호출 후 : a = " + a.value + ", b = " + b.value);
	}
	
}
