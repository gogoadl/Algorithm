package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1861 {
    public static int N;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int[][] arr;
    public static boolean[][] visited;
    public static String str;
    public static int answer = 0;
    public static void dfs(int x, int y, int sum, int depth, StringBuilder sb) {
        if (x==N-1 && y==N-1 && answer < sum) {
            answer = sum;
            str = sb.toString();
        }
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                sum += arr[nx][ny];
                if (i == 0) sb.append("U");
                else if (i == 1) sb.append("D");
                else if (i == 2) sb.append("L");
                else if (i == 3) sb.append("R");
                dfs(nx,ny, sum, depth+1, sb);
                sb.deleteCharAt(sb.length()-1);
                visited[nx][ny] = false;
                sum -= arr[nx][ny];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0][0] = true;
        dfs(0,0,arr[0][0],0, sb);
        System.out.println(answer);
        System.out.println(str);
    }
}
