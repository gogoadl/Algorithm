package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(st.nextToken());

		ArrayList<int[]> lList = new ArrayList<>();


		for (int i = 0; i < testCase; i++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());

				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int[] value = new int[2];
				value[0] = l;
				value[1] = r;
				lList.add(value);
			}

			lList.sort((o1, o2) -> o1[0] -o2[0]);

			int ans = 1;
			int min = lList.get(0)[1];
			for (int j = 1; j < lList.size(); j++) {
				if (min > lList.get(j)[1]) {
					min = lList.get(j)[1];
					ans++;
				}
			}
			sb.append(ans).append("\n");
			lList.clear();
		}
		System.out.println(sb);
	}
}
