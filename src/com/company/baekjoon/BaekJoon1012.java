package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1012 {
    static int width;
    static int height;
    static int[] dx = new int[] {-1,1,0,0};
    static int[] dy = new int[] {0,0,-1,1};
    static boolean[][] visited;
    static int[][] arr;
    public static void dfs(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int currentX = x + dx[i];
            int currentY = y + dy[i];

            if (currentY < 0 || currentX < 0 || currentX >= width || currentY >= height)
                continue;
            if (arr[currentX][currentY] != 0 && !visited[currentX][currentY]) {
                visited[currentX][currentY] = true;
                dfs(currentX, currentY);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) { // 배열 초기화
            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            arr = new int[width][height];
            visited = new boolean[width][height];
            for (int j = 0; j < cnt; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }
            int answer = 0;
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < height; k++) {
                    if (arr[j][k] != 0 && !visited[j][k]) {
                        dfs(j,k);
                        answer++;
                    }
                }
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}
