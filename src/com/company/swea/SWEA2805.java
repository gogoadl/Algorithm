package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCaseCount; i++) {
            int answer = 0;

            int farmSize = Integer.parseInt(br.readLine());
            int[][] farm = new int[farmSize][farmSize];

            for (int j = 0; j < farmSize; j++) {
                farm[j] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }
            int sumIndex = farmSize / 2;
            int start = sumIndex;
            int end = sumIndex;
            for (int j = 0; j < farmSize; j++) {
                for (int k = start; k <= end; k++) {
                    answer += farm[j][k];
                }
                if (j >= sumIndex) {
                    start += 1;
                    end -= 1;
                } else {
                    start -= 1;
                    end += 1;
                }
            }
            sb.append(String.format("#%d %d\n" ,i, answer));
        }
        System.out.println(sb);
    }
}
