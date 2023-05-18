package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon2667 {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int count = 0;
    static ArrayList arrayList = new ArrayList();
    public static void bfs(int[][] graph, boolean[][] visited, int x, int y, int N) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});

        if (graph[x][y] == 1 && !visited[x][y]) {
            visited[x][y] = true;
            count++;
        }

        while (!queue.isEmpty()) {
            int[] value = queue.poll();
            int nowX = value[0];
            int nowY = value[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                    continue;
                }
                if (graph[nextX][nextY] == 0 || visited[nextX][nextY]) {
                    continue;
                }

                queue.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
                count++;
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < input.length; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] != 0 && !visited[i][j])
                bfs(graph, visited, i, j, N);
                if (count != 0) {
                    arrayList.add(count);
                    count = 0;
                }
            }
        }
        int size = arrayList.size();
        Collections.sort(arrayList);
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
