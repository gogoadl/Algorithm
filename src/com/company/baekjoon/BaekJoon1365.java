package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1365 {
    static int[] dp;
    public static int find(int left, int right, int target) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;

            if (dp[mid] < target) {
                left = mid + 1;
            } else
                right = mid;
        }
        return right;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[array.length+1];
        int len = 0;
        int idx = 0;
        for(int i=0; i<array.length-1; i++) {
            if(array[i] > dp[len]) {
                len +=1;
                dp[len] = array[i];
            }else {
                idx = find(0,len, array[i]);
                dp[idx] = array[i];
            }
        }
        System.out.println(N - len);
    }
}
