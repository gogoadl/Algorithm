package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon14400 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long answer = 0;
        int[][] arr = new int[N][2];
        int[] x = new int[N];
        int[] y = new int[N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            x[i] = Integer.parseInt(s[0]);
            y[i] = Integer.parseInt(s[1]);
            arr[i][0] = x[i];
            arr[i][1] = y[i];
        }
        Arrays.sort(x);
        Arrays.sort(y);
        int compX = x[N/2];
        int compY = y[N/2];
        for (int i = 0; i < N; i++) {
            answer += Math.abs(arr[i][0] - compX) + Math.abs(arr[i][1] - compY);
        }
        System.out.println(answer);
    }
}