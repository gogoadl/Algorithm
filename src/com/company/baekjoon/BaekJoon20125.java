package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split("");
        }
        boolean isFind = false;
        int lArm = 0;
        int rArm = 0;
        int lLeg = 0;
        int rLeg = 0;
        int waist = 0;
        for (int i = 0; i < N; i++) {
            if (isFind)
                break;
            for (int j = 0; j < N; j++) {
                if (isFind)
                    break;
                if (arr[i][j].equals("*")) { // 머리 찾았으니 바로 시작
                    isFind = true;
                    sb.append(i+2)
                        .append(" ")
                        .append(j+1)
                        .append("\n");
                    int heartX = j;
                    int heartY = i + 1;
                    for (int k = heartX-1; k >= 0; k--) {
                        if (arr[heartY][k].equals("*"))
                            lArm++;
                        else
                            break;
                    }
                    for (int k = heartX+1; k < N; k++) {
                        if (arr[heartY][k].equals("*"))
                            rArm++;
                        else
                            break;
                    }
                    for (int k = heartY+1; k < N; k++) {
                        if (arr[k][j].equals("*"))
                            waist++;
                        else {
                            for (int l = k; l < N; l++) {
                                if (arr[l][heartX-1].equals("*")) {
                                    lLeg++;
                                }
                                if (arr[l][heartX+1].equals("*")) {
                                    rLeg++;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
        sb.append(lArm + " " + rArm + " " + waist + " " + lLeg + " " + rLeg);
        System.out.println(sb);
    }
}
