package com.baek.conditional;

import java.util.Scanner;

public class TestScore {

	/*
	 * 문제 : 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
	 * 입력 : 첫째 줄에 시험 점수가 주어진다. 시험 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
	 * 출력 : 시험 성적을 출력한다.
	 */
	
	private Scanner scanner = new Scanner(System.in);
	
	public void inputScore() {
		
		int score = 0;
		String answer = "";
		
		score = scanner.nextInt();
		
		if (score >= 90 && score <= 100) {
			answer = "A";
		} else if (score >= 80 && score <= 89) {
			answer = "B";
		} else if (score >= 70 && score <= 79) {
			answer = "C";
		} else if (score >= 60 && score <= 69) {
			answer = "D";
		} else {
			answer = "F";
		}
		
		System.out.println(answer);
		
		scanner.close();
	}
	
	public static void main(String[] args) {
		new TestScore().inputScore();
	}
}
