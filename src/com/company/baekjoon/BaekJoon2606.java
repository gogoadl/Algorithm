package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2606 {
    static int answer = 0;
    public static void dfs(int[][] graph, boolean[] visited, int index, int n) {
        visited[index] = true;

        for (int i = 1; i <= n; i++) {
            if (graph[index][i] == 1 && !visited[i]) {
                dfs(graph, visited, i, n);
                answer++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());

        int[][] graph = new int[count+1][count+1];
        boolean[] visited = new boolean[count+1];

        for (int i = 1; i <= line; i++) { // 인접 행렬 구성
            String[] input = br.readLine().split(" ");
            int first = Integer.parseInt(input[0]);
            int second = Integer.parseInt(input[1]);
            graph[first][second] = 1;
            graph[second][first] = 1;
        }

        dfs(graph, visited, 1, count);

        System.out.println(answer);
    }
}
