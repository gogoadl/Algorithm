package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[26][input.length()];
        boolean[] initialized = new boolean[array.length];
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            String c = inputs[0];
            int start = Integer.parseInt(inputs[1]);
            int end = Integer.parseInt(inputs[2]);

            int index = c.charAt(0) - 'a';
            if (!initialized[index]) {
                int sum = 0;
                for (int j = 0; j < input.length(); j++) {
                    if (c.charAt(0) == input.charAt(j))
                        sum++;
                    array[index][j] = sum;
                }
                initialized[index] = true;
            }
            int answer = 0;
            if (start == 0)
                answer = array[index][end];
            else
                answer = array[index][end] - array[index][start - 1];

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
