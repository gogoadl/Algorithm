package com.company.baekjoon;

import java.util.Scanner;

public class BaekJoon3474 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseCount = scanner.nextInt();
        for (int i = 0; i < testCaseCount; i++) {
            int N = scanner.nextInt();
            int answer = 0;
            int a = 5;
            while (a <= N) {
                answer += N / a;
                a *= 5;
            }
            System.out.println(answer);
        }
    }
}
