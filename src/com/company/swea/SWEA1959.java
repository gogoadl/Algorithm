package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA1959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCaseCount; i++) {
            String[] inputLength = br.readLine().split(" ");
            int aLength = Integer.parseInt(inputLength[0]);
            int bLength = Integer.parseInt(inputLength[1]);

            int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int maxValue = 0;
            if (aLength > bLength) {
                for (int j = 0; j <= aLength - bLength; j++) {
                    int sum = 0;
                    for (int k = j; k < bLength+j; k++) {
                        sum += a[k] * b[k-j];
                    }
                    if (sum > maxValue)
                        maxValue = sum;
                }
            } else {
                for (int j = 0; j <= bLength - aLength; j++) {
                    int sum = 0;
                    for (int k = j; k < aLength+j; k++) {
                        sum += a[k-j] * b[k];
                    }
                    if (sum > maxValue)
                        maxValue = sum;
                }
            }

            sb.append(String.format("#%d %d\n",i, maxValue));
        }

        System.out.println(sb.toString());
    }
}
