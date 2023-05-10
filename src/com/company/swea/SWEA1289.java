package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCaseCount; i++) {
            int answer = 0;

            char[] input = br.readLine().toCharArray();
            char[] memory = new char[input.length];
            for (int j = 0; j < input.length; j++) {
                memory[j] = '0';
            }
            for (int j = 0; j < input.length; j++) {
                char character = input[j];
                if (character != memory[j]) {
                    for (int k = j; k < input.length; k++) {
                        memory[k] = character;
                    }
                    answer++;
                }
            }

            sb.append(String.format("#%d %d\n", i, answer));
        }
        System.out.println(sb);
    }
}
