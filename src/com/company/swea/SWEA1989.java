package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCaseCount; i++) {
            String input = br.readLine();

            String[] str = input.split("");
            String reverseStr = "";
            int isPalindrome = 0;
            for (int j = str.length - 1; j >= 0; j--) {
                reverseStr += str[j];
            }

            if (reverseStr.equals(input)) {
                isPalindrome = 1;
            }
            sb.append(String.format("#%d %d\n", i, isPalindrome));
        }
        System.out.println(sb);
    }
}
