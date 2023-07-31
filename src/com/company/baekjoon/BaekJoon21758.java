package org.example.BaekJoon;

import java.util.Scanner;

public class BaekJoon21758 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n+1];
        int[] sum = new int[n+1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
            sum[i] = sum[i-1] + arr[i];
        }

        int s = 0;
        for (int i = 2; i <= n; i++) { // 꿀통 젤왼쪽
            s = sum[n] - arr[1] -arr[i] + sum[n] - sum[i];
            if (s > answer)
                answer = s;
        }

        for (int i = n-1; i >= 1; i--) { // 꿀통 젤오른쪽
            s = sum[n-1] - arr[i] + sum[n-1] - (sum[n-1] - sum[i-1]);
            if (s > answer)
                answer = s;
        }

        for (int i = 2; i <= n-1; i++) { // 꿀통 중간
            s = sum[i] - arr[i-1] + sum[n-1] - sum[i-1];
            if (s > answer)
                answer = s;
        }

        System.out.println(answer);
    }
}
