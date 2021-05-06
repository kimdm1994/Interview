package com.baek.repeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Descending {

	// N 찍기 5 -> 5 4 3 2 1 쓸데없는짓..
	
	public void method1() throws IOException {
		
		BufferedReader br = null;
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = T ; i > 0 ; i--) {
			System.out.println(i);
		}
		
		br.close();
	}
	
	public static void main(String[] args) throws IOException {
		new Descending().method1();
	}
}
