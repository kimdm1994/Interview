package com.baek.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

public class SingletonClassTest {

	@Test
	public void test() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
		SingletonClass c1 = SingletonClass.INSTANCE;
		SingletonClass c2 = SingletonClass.INSTANCE;
		
		// 동일한지 테스트
		assertEquals(c1, c2);
		
		// 단점
		Constructor<SingletonClass> constructor = (Constructor<SingletonClass>) c2.getClass().getDeclaredConstructor();
		constructor.setAccessible(true);
		SingletonClass c3 = constructor.newInstance();
		assertEquals(c1, c3);
		
		// java.lang.AssertionError : 
		// Expected : com.baek.pattern.SingletonClass@481a15ff
		// Actual : com.baek.pattern.SingletonClass@78186a70		
	}

}
