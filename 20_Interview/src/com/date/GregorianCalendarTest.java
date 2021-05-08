package com.date;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianCalendarTest {
	
	/*
	 * 나라마다 시간, 날짜 등 조금씩 다르기 때문에 Calendar라는 클래스가 '추상클래스'로 선언되어있다.
	 *  - public abstract class Calendar implements Serializable, Cloneable, Comparable<Calendar>
	 * GregorianCalendar는 Calendar를 상속받은 클래스이다.
	 */
	
	public static void main(String[] args) {
		
		String pm = null;
		String am = null;
		
		// GregorianCalendar(년도, 월, 일, 시, 분, 초)로 생성자를 제공
		Calendar calendar = new GregorianCalendar();
		int year  = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;// 0월부터 시작, +1해서 출력해야됨
		int date  = calendar.get(Calendar.DATE);
		int hour  = calendar.get(Calendar.HOUR);
		int min   = calendar.get(Calendar.MINUTE);
		int sec   = calendar.get(Calendar.SECOND);
		
		if (calendar.get(Calendar.AM_PM) == 1) {
			pm = "오후";
			System.out.println(year + "년 " + month + "월 " + date + "일 " + pm + " " + hour + "시 " + min + "분 " + sec + "초 입니다.");
		} else {
			am = "오전";
			System.out.println(year + "년 " + month + "월 " + date + "일 " + am + " " + hour + "시 " + min + "분 " + sec + "초 입니다.");
		}
		
	}
}
