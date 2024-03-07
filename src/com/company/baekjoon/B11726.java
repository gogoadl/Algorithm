package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11726 {
	static long[] dp = new long[1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for (int i = 4; i <= n; i++) {
			dp[i] = (dp[i-1] % 10007) + (dp[i-2] % 10007);
		}

		System.out.println(dp[n] % 10007);
	}
}
