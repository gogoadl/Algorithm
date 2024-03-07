package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9465 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(st.nextToken());

		for (int i = 0; i < testCase; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()) + 1;
			long[][] origin = new long[2][n];
			long[][] dp = new long[2][n];

			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n-1; k++) {
					origin[j][k+1] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][1] = origin[0][1];
			dp[1][1] = origin[1][1];

			for (int j = 2; j < n; j++) {
				dp[0][j] = Math.max(dp[1][j-2], dp[1][j-1]) + origin[0][j];
				dp[1][j] = Math.max(dp[0][j-2], dp[0][j-1]) + origin[1][j];
			}

			sb.append(Math.max(dp[0][n-1],dp[1][n-1])).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}
}
