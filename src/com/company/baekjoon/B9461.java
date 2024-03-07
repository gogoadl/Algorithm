package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9461 {
	static long[] dp = new long[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(st.nextToken());
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		for (int i = 4; i <= 100; i++) {
			if (i % 3 == 0) {
				dp[i] = dp[i-3] + dp[i-4] + dp[i-5];
			} else {
				dp[i] = dp[i-2] + dp[i-3];
			}
		}

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());

			sb.append(dp[n]).append("\n");
		}

		System.out.println(sb);
	}
}
