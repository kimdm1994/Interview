package com.baek.repeat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LessThanX {

	/*
	 * 문제 : 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오. 입력
	 * : 첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000) 둘째 줄에 수열 A를 이루는 정수 N개가 주어진다. 주어지는 정수는
	 * 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다. 출력 : X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다.
	 * X보다 작은 수는 적어도 하나 존재한다.
	 */

	private Scanner scanner = new Scanner(System.in);

	public void method1() {

		int N; // N 개수만큼 입력
		int X; // X 보다 작은 값만 추출
		int i;
		int[] array = {};

		N = scanner.nextInt(); // N 개수만큼 입력
		X = scanner.nextInt(); // X 보다 작은 값만 추출
		array = new int[N];

		for (i = 0; i < N; i++) {
			array[i] = scanner.nextInt();
		}

		for (i = 0; i < N; i++) {
			if (array[i] < X) {
				System.out.print(array[i] + " ");
			}
		}

		scanner.close();
	}

	public void method2() throws IOException {

		int N;
		int X;
		int i;
		int val;
		int[] arr = {};
		StringBuilder sb = null;

		sb = new StringBuilder();

		N = scanner.nextInt();
		X = scanner.nextInt();
		arr = new int[N];

		for (i = 0; i < N; i++) {

			val = scanner.nextInt();
			if (val < X) {
				sb.append(val + " ");
			}
		}
		System.out.println(sb);
	}

	public void method3() throws IOException {

		int N;
		int X;
		int i;
		int val;
		int[] arr = {};
		BufferedReader br = null;
		BufferedWriter bw = null;
		StringTokenizer st = null; // 문자열 분리

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine() + " "); // (val1 val2 )
		N = Integer.parseInt(st.nextToken()); // val1
		X = Integer.parseInt(st.nextToken()); // val2

		st = new StringTokenizer(br.readLine() + " "); // N 만큼의(val1, ..., val(n))
		for (i = 0; i < N; i++) {
			val = Integer.parseInt(st.nextToken());

			if (val < X) {
				bw.write(val + " ");
				// sb.append(value).append(' ');
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static void main(String[] args) throws IOException {

		new LessThanX().method3();
	}
}
