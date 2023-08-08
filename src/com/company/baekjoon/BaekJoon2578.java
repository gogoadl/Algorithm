package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2578 {
    static int arr[][];
    static boolean check[][];
    static int bingo = 0;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[5][5];
        check = new boolean[5][5];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (flag)
                break;
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                if (flag)
                    break;
                int target = Integer.parseInt(s[j]);
                count++;
                find(target);
                if (bingo >= 1)
                    checkDiagBingo();
                if (flag)
                    System.out.println(count);
            }
        }
    }
    public static void find(int target) {
        for (int i = 0; i < arr.length; i++) {
            if (flag)
                break;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == target) {
                    check[i][j] = true;
                    checkBingo(i,j);
                    if (flag)
                        break;
                }

            }
        }
    }
    public static void checkBingo(int i, int j) {
        int checker = 0;
        for (int k = 0; k < arr.length; k++) {
            if (check[i][k])
                checker++;
        }
        if (checker == 5)
            bingo++;
        checker = 0;
        for (int k = 0; k < arr.length; k++) {
            if (check[k][j])
                checker++;
        }
        if (checker == 5)
            bingo++;
    }
    public static void checkDiagBingo() {
        int diagBingo = 0;
        int checker = 0;
        for (int l = 0; l < arr.length; l++) {
            if (check[l][l])
                checker++;
        }
        if (checker == 5)
            diagBingo++;
        checker = 0;
        for (int l = 0; l < arr.length; l++) {
            int a = 4-l;
            if (check[a][l])
                checker++;
        }
        if (checker == 5)
            diagBingo++;
        if (diagBingo + bingo >= 3)
            flag = true;
    }
}