package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = 10;
        for (int i = 1; i <= testCaseCount; i++) {
            int answer = 0;
            int testCaseNumber = Integer.parseInt(br.readLine());
            String target = br.readLine();
            String input = br.readLine();

            while (true) {
                int idx = input.indexOf(target) + target.length();
                if (idx <= target.length() || target.length() >= input.length())
                    break;
                input = input.substring(idx);
                answer++;
            }
            sb.append(String.format("#%d %d\n", testCaseNumber, answer));
        }
        System.out.println(sb);
    }
}
