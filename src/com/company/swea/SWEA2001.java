package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SWEA2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCaseCount; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            int[][] arr = new int[N][N];
            ArrayList<Integer> answerList = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                String[] strings = br.readLine().split(" ");
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(strings[k]);
                }
            }

            for (int j = 0; j <= N-M; j++) {
                for (int k = 0; k <= N-M; k++) {
                    int answer = 0;
                    for (int l = j; l < M+j; l++) {
                        for (int m = k; m < M+k; m++) {
                            answer += arr[l][m];
                        }
                    }
                    answerList.add(answer);
                }
            }
            Collections.sort(answerList);
            sb.append(String.format("#%d %d\n", i, answerList.get(answerList.size()-1)));
        }
        System.out.println(sb);
    }
}
