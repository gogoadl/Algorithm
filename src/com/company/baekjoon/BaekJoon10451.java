package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon10451 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            int size = Integer.parseInt(br.readLine());
            int answer = 0;
            String[] input = br.readLine().split(" ");
            int[] array = new int[size+1];
            boolean[] visited = new boolean[size+1];
            for (int j = 1; j <= size; j++) {
                array[j] = Integer.parseInt(input[j-1]);
            }

            for (int j = 1; j <= size; j++) {
                if (!visited[j]) {
                    dfs(array, visited, j);
                    answer++;
                }
            }

            sb.append(answer);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int[] array, boolean[] visited, int index) {
        visited[index] = true;

        int next = array[index];
        if (!visited[next])
            dfs(array, visited, next);
    }
}
