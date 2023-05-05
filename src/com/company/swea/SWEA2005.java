package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCaseCount; i++) {
            int number = Integer.parseInt(br.readLine());
            sb.append("#" + i + "\n");
            int[][] arr = new int[number][number];
            for (int j = 0; j < number; j++) {
                for (int k = 0; k <= j; k++) {
                    if (k == 0 || k == j) {
                        arr[j][k] = 1;
                    } else if (j >= 2) {
                        arr[j][k] = arr[j-1][k] + arr[j-1][k-1];
                    }
                }
            }

            for (int j = 0; j < number; j++) {
                for (int k = 0; k <= j; k++) {
                    if (arr[j][k] != 0) {
                        sb.append(arr[j][k] + " ");
                    }
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
