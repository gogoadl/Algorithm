package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1954 {
    // 1. i = 0 고정, j = 0 마지막까지 채우기
    // 2. i = 0 마지막까지, j = 마지막 고정 채우기
    // 3. i = 마지막 고정, j = 마지막 부터 0까지 채우기
    // 4. i = 마지막 부터 1까지, j = 0 고정 채우기
    //
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());


        for (int i = 1; i <= testCaseCount; i++) {
            int snailCount = Integer.parseInt(br.readLine());
            int value = 1;
            int[][] snailArray = new int[snailCount][snailCount];
            int xIndex = 0;
            int yIndex = 0;
            while (value != snailCount*snailCount) {
                for (int j = xIndex; j < snailCount-xIndex; j++) {
                    snailArray[xIndex][j] = value++;
                }
                xIndex++;
                for (int j = xIndex; j < snailCount; j++) {
                    snailArray[j-xIndex][snailCount-xIndex] = value++;
                }
                yIndex++;
                for (int j = snailCount-xIndex; j > 0 ; j--) {
                    snailArray[snailCount-xIndex][j-xIndex] = value++;
                }
                for (int j = snailCount-xIndex-1; j >= xIndex ; j--) {
                    snailArray[j][xIndex-1] = value++;
                }
            }
        }
    }
}
