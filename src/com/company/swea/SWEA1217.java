package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1217 {
    public static int power(int N, int M, int number) {
        if (M == 1)
            return  N;
        return power(N * number, M - 1, number);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = 10;

        for (int i = 1; i <= testCaseCount; i++) {
            int testCaseNumber = Integer.parseInt(br.readLine());

            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            int answer = power(N, M, N);
            sb.append(String.format("#%d %d\n", testCaseNumber, answer));
        }
        System.out.println(sb);
    }
}
