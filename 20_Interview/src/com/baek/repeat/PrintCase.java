package com.baek.repeat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PrintCase {

	// A + B - 7 -> Case #x: A + B

	public void method1() throws IOException {

		BufferedReader br = null;
		BufferedWriter bw = null;
		StringTokenizer st = null;
		int A = 0;
		int B = 0;
		int T = 0;
		int i = 0;

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 개수 T
		T = Integer.parseInt(br.readLine());

		for (i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());

			bw.write("Case #" + i + ": " + (A + B) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public void method2() throws IOException {

		BufferedReader br = null;
		BufferedWriter bw = null;
		StringTokenizer st = null;
		int A = 0;
		int B = 0;
		int T = 0;
		int i = 0;

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 개수 T
		T = Integer.parseInt(br.readLine());

		for (i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());

			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			bw.write("Case #" + i + ": " + A + " + " + B + " = " + (A + B) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static void main(String[] args) throws IOException {
		new PrintCase().method2();
	}
}
