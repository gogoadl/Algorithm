package com.company.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon3649 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int x = scanner.nextInt() * 10000000;
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = scanner.nextInt();

            Arrays.sort(arr);

            int start = 0;
            int end = n-1;
            int l1 = -1;
            int l2 = -1;

            while (start < end) {
                int s = arr[start];
                int e = arr[end];

                if (s + e < x) {
                    start++;
                } else if (s + e > x) {
                    end--;
                } else {
                    l1 = s;
                    l2 = e;
                    break;
                }
            }
            if (l1 == -1 && l2 == -1) {
                System.out.println("danger");
            } else {
                System.out.println("yes " + l1 + " " + l2);
            }
        }
    }
}
