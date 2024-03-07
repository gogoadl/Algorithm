package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1080 {
	static int n;
	static int m;
	static int[][] arr;
	static int[][] target;
	static int count;
	static int a=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		target = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j)-48;
			}
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < m; j++) {
				target[i][j] = str.charAt(j)-48;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != target[i][j] && i+3 <= n && j+3 <= m) {
					flip(i, j);
					count++;
				}
			}
		}

		boolean isTranslated = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != target[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(count);
	}
	public static void flip(int i, int j) {
		for (int k = i; k < i + 3; k++) {
			for (int l = j; l < j + 3; l++) {
				arr[k][l] = arr[k][l] == 1 ? 0 : 1;
			}
		}
	}
}
