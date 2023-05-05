package com.company.swea;

import java.util.Scanner;

public class SWEA2072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        int plusCount = 10;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= testCaseCount; i++) {
            int answer = 0;
            for (int j = 0; j < plusCount; j++) {
                int value = sc.nextInt();
                if (value % 2 != 0) {
                    answer += value;
                }
            }
            sb.append(String.format("#%d %d\n", i, answer));
        }
        System.out.println(sb);
    }
}
