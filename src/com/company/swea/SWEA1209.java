package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SWEA1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = 10;

        for (int i = 0; i < testCaseCount; i++) {
            int testCaseNumber = Integer.parseInt(br.readLine());
            ArrayList<Integer> arrayList = new ArrayList<>();
            int[][] arr = new int[100][100];
            for (int j = 0; j < 100; j++) {
                String[] s = br.readLine().split(" ");
                arr[j] = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
            }
            int xSum = 0;
            int ySum = 0;
            int lCross = 0;
            int rCross = 0;
            for (int j = 0; j < 100; j++) {
                xSum = 0;
                ySum = 0;

                for (int k = 0; k < 100; k++) {
                    xSum += arr[j][k];
                    ySum += arr[k][j];
                    if (j == k) {
                        lCross += arr[j][k];
                    } else if (99-j == 99-k) {
                        rCross += arr[99-j][99-k];
                    }
                }
                arrayList.add(xSum);
                arrayList.add(ySum);
            }
            arrayList.add(lCross);
            arrayList.add(rCross);

            Collections.sort(arrayList);

            int answer = arrayList.get(arrayList.size()-1);

            sb.append(String.format("#%d %d\n", testCaseNumber, answer));
        }
        System.out.println(sb);
    }
}
