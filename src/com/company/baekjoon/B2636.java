package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2636 {
    static int[] dx = new int[] {-1,1,0,0};
    static int[] dy = new int[] {0,0,-1,1};
    static int INSIDE_CHEESE = 0;
    static int CHEESE = 1;
    static int OUTSIDE_CHEESE = 2;
    static int WILL_MELTED = 3;
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;

    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        int cheeseCount = 0;
        int lastCheeseCount = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) cheeseCount++;
            }
        }
        while (true) {
            bfs(0,0);
            visited = new boolean[N][M];
            if (cheeseCount == 0) break;
            lastCheeseCount = cheeseCount;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == CHEESE) {
                        int cnt = 0;
                        for (int k = 0; k < dx.length; k++) {
                            int ny = dy[k] + i;
                            int nx = dx[k] + j;
                            if (arr[ny][nx] == OUTSIDE_CHEESE)
                                cnt++;
                        }
                        if (cnt >= 1)
                            arr[i][j] = WILL_MELTED;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == WILL_MELTED) {
                        arr[i][j] = OUTSIDE_CHEESE;
                        cheeseCount--;
                    }
                }
            }

            count++;
        }
        System.out.println(count);
        System.out.println(lastCheeseCount);
    }
    public static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{i,j});
        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            for (int k = 0; k < dx.length; k++) {
                int ny = dy[k] + val[0];
                int nx = dx[k] + val[1];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (visited[ny][nx]) continue;
                if (arr[ny][nx] == CHEESE) continue;
                visited[ny][nx] = true;
                arr[ny][nx] = OUTSIDE_CHEESE;
                queue.add(new int[]{ny,nx});
            }
        }
    }
}
