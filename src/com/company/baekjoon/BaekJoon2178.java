package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BaekJoon2178 {
    static ArrayList<Integer> arrayList = new ArrayList();
    static int count = 0;
    public static void dfs(int[][] graph, boolean[][] visited, int x, int y, int N, int M) {
        if (x == N-1 && y == M-1) {
            arrayList.add(count);
            return;
        }
        if (x != N-1 && graph[x+1][y] != 0 && !visited[x+1][y]) {
            visited[x+1][y] = true;
            count++;
            dfs(graph, visited, x+1, y, N, M);
            visited[x+1][y] = false;
            count--;
        }
        if (x != 0 && graph[x-1][y] != 0 && !visited[x-1][y]) {
            visited[x-1][y] = true;
            count++;
            dfs(graph, visited, x-1, y, N, M);
            visited[x-1][y] = false;
            count--;
        }
        if (y != M-1 && graph[x][y+1] != 0 && !visited[x][y+1]) {
            visited[x][y+1] = true;
            count++;
            dfs(graph, visited, x, y+1, N, M);
            visited[x][y+1] = false;
            count--;
        }
        if (y != 0 && graph[x][y-1] != 0 && !visited[x][y-1]) {
            visited[x][y-1] = true;
            count++;
            dfs(graph, visited, x, y-1, N, M);
            visited[x][y-1] = false;
            count--;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arraySize = br.readLine().split(" ");
        int N = Integer.parseInt(arraySize[0]);
        int M = Integer.parseInt(arraySize[1]);

        int[][] graph = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(graph, visited, 0, 0, N, M);

        Collections.sort(arrayList);
        System.out.println(arrayList.get(0) + 1);
    }
}
