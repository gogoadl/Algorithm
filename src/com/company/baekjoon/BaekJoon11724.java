package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11724 {
    public static void dfs(int[][] graph, boolean[] visited, int index, int n) {
        visited[index] = true;
        for (int i = 1; i <= n; i++) {
            if (graph[index][i] == 1 && !visited[i])
                dfs(graph, visited, i, n);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int answer = 0;
        int[][] array = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];

        for (int i = 1; i <= m; i++) {
            String[] node = br.readLine().split(" ");
            int a = Integer.parseInt(node[0]);
            int b = Integer.parseInt(node[1]);
            array[a][b] = 1;
            array[b][a] = 1;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(array, visited, i, n);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
