package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1767 {
    static int max;
    static int min;

    static int N;
    static int[][] arr;
    static int[] dx = new int[] {-1,1,0,0};
    static int[] dy = new int[] {0,0,-1,1};
    static ArrayList<int[]> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= testCaseCount; i++) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            arrayList = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    if (arr[j][k] == 1) {
                        if (j > 0 && j < N - 1 && k > 0 && k < N - 1) {
                            arrayList.add(new int[] {j,k});
                        }
                    }

                }
            }
            dfs(0,0,0);
            sb.append(String.format("#%d %d\n", i, min));
        }

        System.out.println(sb);
    }
    public static void dfs(int idx, int coreCnt, int len) {
        if (idx == arrayList.size()) {
            if (max < coreCnt) {
                max = coreCnt;
                min = len;
            }
            else if (max == coreCnt) {
                if (min > len) min = len;
            }
            return;
        }

        int y = arrayList.get(idx)[0];
        int x = arrayList.get(idx)[1];

        for (int i = 0; i < dx.length; i++) {
            int count = 0;
            int originY = y;
            int originX = x;
            int ny = y;
            int nx = x;

            while (true) {
                ny += dy[i];
                nx += dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N) break;

                if (arr[ny][nx] == 1) {
                    count = 0;
                    break;
                }
                count++;
            }

            for (int j = 0; j < count; j++) {
                originY += dy[i];
                originX += dx[i];

                arr[originY][originX] = 1;
            }
            if (count == 0) {
                dfs(idx+1, coreCnt, len);
            } else {
                dfs(idx+1, coreCnt+1, len+count);

                originY = y;
                originX = x;
                for (int j = 0; j < count; j++) {
                    originY += dy[i];
                    originX += dx[i];

                    arr[originY][originX] = 0;
                }
            }
        }
    }
}
