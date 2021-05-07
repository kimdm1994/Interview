package com.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormatTest {

	/*
	 * 자바에서 현재 날짜와 시간 구하기
	 *  - Date 객체 사용
	 *  - Calender 클래스의 getInstance() 메소드 사용
	 *  - System 클래스의 currentTimeMillis() 메소드 사용
	 *  
	 *  Calender와 GregorianCalendar는 뒤에서 다뤄보기
	 *  
	 *  SimpleDateFormat 기호
	 *   - [y/년], [M/월], [d/일], [D/월 구분이 없는 일(1~365)], [E/요일], [h/시(1~12)] 
	 *     [H/시(0~23)], [m/분], [s/초], [S/밀리세컨드(1/1000초)], [a/오전,오후]
	 */
	
	public static void main(String[] args) {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		// 1. Date() 객체 사용
		Date now = new Date();
		String nowTime = now.toString();
		System.out.println("Base Time : " + nowTime); // [Fri May 07 14:44:48 KST 2021]
		
		String nowTime2 = sdf1.format(now);
		System.out.println("yyyy-MM-dd HH:mm:ss : " + nowTime2);
		String nowTime3 = sdf2.format(now);
		System.out.println("yyyy년 MM월 dd일 : " + nowTime3);
		
		// 2. Calender 클래스의 getInstance() 메소드 사용
		//  - Calender 클래스는 추상(abstract)클래스이므로 new 연산자를 사용해서 인스턴스를 생성할 수 없다.(지역마다 다르기 때문에)
		Calendar cal = Calendar.getInstance(); // static getInstance() method
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; 
		int day = cal.get(Calendar.DAY_OF_MONTH); 
		int week = cal.get(Calendar.DAY_OF_WEEK); 
		int amPm = cal.get(Calendar.AM_PM); 
		int hour = cal.get(Calendar.HOUR); 
		int minute = cal.get(Calendar.MINUTE); 
		int second = cal.get(Calendar.SECOND);

		// StringDateFormat 으로 활용 가능
		String nowTime4 = sdf1.format(cal.getTime());
		System.out.println("Calendar.getTime() : " + nowTime4);
		
		// 3. System 클래스의 currentTimeMillis() 메소드 사용
		String nowTime5 = sdf1.format(System.currentTimeMillis());
		System.out.println("System.currentTimeMillis() : " + nowTime5);
		
	}
}
