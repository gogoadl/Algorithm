package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12904 {
	static int isTransform = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String s = st.nextToken();

		st = new StringTokenizer(br.readLine());
		String t = st.nextToken();

		dfs(s,t);
		System.out.println(isTransform);
	}
	public static void dfs(String s, String t) {
		if (s.length() > t.length()) {
			return;
		}
		if (s.equals(t)) {
			isTransform = 1;
		}

		dfs(s+"A", t);
		String newStr = "";
		for (int i = s.length()-1; i >= 0; i--) {
			newStr += s.charAt(i);
		}
		dfs(newStr+"B", t);
	}
}
