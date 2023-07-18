package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA12712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());


        int[] dx = { -1, 1, 0, 0};
        int[] dy = { 0, 0, 1, -1};

        int[] diagDx = {-1, -1, 1, 1};
        int[] diagDy = {-1, 1, -1, 1};


        for (int i = 1; i <= testCaseCount; i++) {
            int answer = 0;

            String[] inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]);
            int M = Integer.parseInt(inputs[1]);

            int[][] array = new int[N][N];
            for (int j = 0; j < N; j++) {
                array[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            for (int j = M-1; j <= N-M; j++) {
                for (int k = M-1; k <= N-M; k++) {
                    System.out.println(String.format("Target : (%d, %d)", j, k));
                    int sum = array[j][k];
                    int diagSum = array[j][k];
                    for (int l = 0; l < M-1; l++) { // 수직 수평 합
                        for (int m = 0; m < dx.length; m++) {
                            int currentX = j + dx[m] + l * dx[m];
                            int currentY = k + dy[m] + l * dy[m];

                            sum += array[currentX][currentY];

                            int currentDiagX = j + diagDx[m] + l;
                            int currentDiagY = k + diagDy[m] + l;

                            diagSum += array[currentDiagX][currentDiagY];

                        }
                    }
                    answer = Math.max(answer,Math.max(diagSum, sum));
                }
            }

            sb.append(String.format("#%d %d", i , answer));
        }
        System.out.println(sb);
    }
}
