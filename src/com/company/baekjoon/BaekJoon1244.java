package com.company.baekjoon;

import java.util.Scanner;

public class BaekJoon1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        boolean[] arr = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt() > 0;
        }
        int s = sc.nextInt();
        for (int i = 0; i < s; i++) {
            int gender = sc.nextInt();
            int idx = sc.nextInt();

            if (gender == 1) {
                for (int j = idx; j < arr.length; j+=idx) {
                    if (j % idx == 0)
                        arr[j] = !arr[j];
                }
            } else {
                int a = 1;
                arr[idx] = !arr[idx];
                while(true) {
                    if (idx - a < 1 || idx + a > n) break;
                    if (arr[idx+a] == arr[idx-a]) {
                        arr[idx+a] = !arr[idx+a];
                        arr[idx-a] = !arr[idx-a];
                        a++;
                    } else
                        break;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            int value = arr[i] ? 1 : 0;
            if (i != n)
                sb.append(value + " "); // 이거때문에 틀림
            else
                sb.append(value);

            if (i % 20 == 0)
                sb.append("\n");
        }
        System.out.println(sb);
    }
}
/*
0 1 0 1 0 0 0 1
0 1 1 1 0 1 0 1
1 0 0 0 1 1 0 1

 */