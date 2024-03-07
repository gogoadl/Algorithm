package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B1325 {
	static int N;
	static int M;
	static boolean[] visited;
	static LinkedList<Integer>[] graph;
	static int maxCnt = 0;
	static int[] cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new LinkedList[N];
		cnt = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new LinkedList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken()) - 1;
			int second = Integer.parseInt(st.nextToken()) - 1;
			graph[second].add(first);
		}
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i);
			Arrays.fill(visited,false);
		}

		for (int i = 0; i < N; i++) {
			maxCnt = Math.max(cnt[i], maxCnt);
		}
		for (int i = 0; i < N; i++) {
			if (cnt[i] == maxCnt)
				sb.append(i+1).append(" ");
		}
		sb.deleteCharAt(sb.lastIndexOf(" "));
		System.out.println(sb);
	}
	public static void dfs(int s) {
		for (int val: graph[s]) {
			if (!visited[val]) {
				visited[val] = true;
				cnt[val]++;
				dfs(val);
			}
		}
	}
}