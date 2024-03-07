package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class B1189 {
    static int[] dx = new int[] {-1,1,0,0};
    static int[] dy = new int[] {0,0,-1,1};
    static int r;
    static int c;
    static int k;
    static int[][] arr;
    static boolean[][] visited;

    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '.') {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 1;
                }
            }
        }
        visited[r-1][0] = true;
        dfs(r-1, 0, 1);
        System.out.println(count);
    }
    public static void dfs(int i, int j, int depth) {
        if (i == 0 && j == c-1) {
            if (depth == k) count++;
            return;
        }
        for (int l = 0; l < dy.length; l++) {
            int ny = i + dy[l];
            int nx = j + dx[l];

            if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
            if (visited[ny][nx]) continue;
            if (arr[ny][nx] == 1) continue;
            visited[ny][nx] = true;
            dfs(ny, nx, depth + 1);
            visited[ny][nx] = false;
        }
    }
}
