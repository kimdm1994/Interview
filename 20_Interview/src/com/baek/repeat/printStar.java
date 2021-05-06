package com.baek.repeat;

import java.util.Scanner;

public class printStar {

	private Scanner scanner = new Scanner(System.in);

	public void star() {
		
		int N = 0;
		int i = 0;
		int j = 0;
		int k = 0;
		int count = 0;
		
		N = scanner.nextInt();
		//☆☆☆☆★
		//☆☆☆★★
		//☆☆★★★
		//☆★★★★
		//★★★★★
		for (i = 1 ; i <= N ; i++) {
			// i = {1 2 3 4 5}
			for (j = 1 ; j <= N-i ; j++) {
				// 빈별 4개 찬별 1개
				System.out.print(" ");
			}
			for(k = 1 ; k <= i ; k++) {
				System.out.print("★");
			}
			// 별을 찍고나서 다음줄
			System.out.println();
		}
	}

	public static void main(String[] args) {

		new printStar().star();
	}
}
