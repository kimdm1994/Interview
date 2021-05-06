package com.baek.repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ascending {

	// N 찍기 5 -> 1 2 3 4 5 쓸데없는짓..
	
	public void method1() throws IOException {
		
		BufferedReader br = null;
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0 ; i < T ; i++) {
			System.out.println(i + 1);
		}
		
		br.close();
	}
	
	public static void main(String[] args) throws IOException {
		new Ascending().method1();
	}
}
