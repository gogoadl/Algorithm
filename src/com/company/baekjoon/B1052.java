package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int val;
		while (k > 1) {
			val = 0;
			while (n > Math.pow(2, val)) {
				val++;
			}
			n -= Math.pow(2, val-1);
			if (n == 0) {
				System.out.println(0);
				return;
			}
			k--;
		}

		val = 0;

		while (n > Math.pow(2, val)) {
			val++;
		}

		System.out.println((int)Math.pow(2, val)-n);

	}
}
