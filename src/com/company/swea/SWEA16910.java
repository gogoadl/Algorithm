package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA16910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCaseCount; i++) {
            int input = Integer.parseInt(br.readLine());
            int answer = 0;

            for (int j = -input; j <= input; j++) {
                for (int k = -input; k <= input; k++) {
                    if (j*j + k*k <= input*input) {
                        answer++;
                    }
                }
            }

            sb.append(String.format("#%d %d\n", i, answer));
        }
        System.out.println(sb);
    }
}
