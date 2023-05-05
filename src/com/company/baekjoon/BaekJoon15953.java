package com.company.baekjoon;

import java.util.Scanner;

public class BaekJoon15953 {
    public static void main(String[] args) {
        int count;
        Scanner scanner = new Scanner(System.in);

        count = scanner.nextInt();
        int[] printSum = new int[count];
        if(count <= 1000 && count >= 0)
        {
            for(int i = 0; i < count; i++)
            {
                int first;
                int second;
                int sum = 0;

                first = scanner.nextInt();
                second = scanner.nextInt();

                if (first >= 0 && first <= 100)
                {
                    if (first == 0 ) { }
                    else if (first == 1 ) { sum += 5000000; }
                    else if (first <= 3) { sum += 3000000; }
                    else if (first <= 6) { sum += 2000000; }
                    else if (first <= 10) { sum += 500000; }
                    else if (first <= 15) { sum += 300000; }
                    else if (first <= 21) { sum += 100000; }
                    else if (first >= 22 ) { }
                }
                if (second >= 0 && second <= 64)
                {
                    if (second == 0) {  }
                    else if (second == 1) { sum += 5120000; }
                    else if (second <= 3) { sum += 2560000; }
                    else if (second <= 7) { sum += 1280000; }
                    else if (second <= 15) { sum += 640000; }
                    else if (second <= 31) { sum += 320000; }
                    else if (second >= 32 ) { }
                }
                printSum[i] = sum;

            }
            for(int i = 0; i < printSum.length; i++)
            {
                System.out.println(printSum[i]);
            }
        }
    }
}
