package com.company.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon3040 {
    static boolean[] visited = new boolean[9];
    static int[] arr = new int[9];
    static int[] result = new int[7];
    static int count = 0;
    public static void dfs(int index, int depth, int sum) {
        if (depth == 7) {
            count--;
            if (sum == 100)
                for (int i : result) {
                    System.out.println(i);
                }
            return;
        }
        for(int i = index; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[count++] = arr[i];
                dfs(i,depth+1, sum + arr[i]);
                visited[i] = false;
            }

        }
        count--;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(0, 0, 0);
    }
}