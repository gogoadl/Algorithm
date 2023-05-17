package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon1260 {
    static StringBuilder sb = new StringBuilder();
    public static void dfs(int[][] graph, boolean[] visited, int index, int N) {
        visited[index] = true;
        for (int i = 1; i <= N; i++) {
            if (graph[index][i] == 1 && !visited[i]) {
                sb.append(i + " ");
                dfs(graph, visited, i, N);
            }
        }
    }
    public static void bfs(int[][] graph, boolean[] visited, int index, int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (graph[idx][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    sb.append(i + " ");
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int index = Integer.parseInt(input[2]);

        int[][] graph = new int[N + 1][N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            String[] value = br.readLine().split(" ");
            int a = Integer.parseInt(value[0]);
            int b = Integer.parseInt(value[1]);
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        sb.append(index + " ");
        dfs(graph, visited, index, N);
        System.out.println(sb);
        sb.setLength(0);
        visited = new boolean[N + 1];

        sb.append(index + " ");
        bfs(graph, visited, index, N);
        System.out.println(sb);
    }
}
