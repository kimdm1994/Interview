package com.baek.repeat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class QuickOpertator {

	public void method1() throws IOException {
		// 문제 : A + B
		
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		StringTokenizer stringTokenizer = null;
		
		// 입력 개수
		int T = 0;
		
		// 결과
		int result = 0;
		
		// 두 개의 정수
		String A = null;
		String B = null;
		
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 문자 입력 -> 정수형으로 형변환
		T = Integer.parseInt(bufferedReader.readLine());
		
		// T개의 정수값 입력
		for (int i = 0; i < T; i++) {
			// 반복문이 끝날때까지 stringTokenizer에 공백포함 문자열을 넣을거야!
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			bufferedWriter.write(Integer.parseInt(stringTokenizer.nextToken()) + Integer.parseInt(stringTokenizer.nextToken()) + "\n");
		}
		
		// flush() 먼저 비우고
		// 선언의 역순으로 close();
		bufferedWriter.flush();
		bufferedWriter.close();
		bufferedReader.close();
	}
	
	public static void main(String[] args) throws IOException {
		new QuickOpertator().method1();
	}
}
