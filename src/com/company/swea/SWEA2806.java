package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2806 {
    // 퀸은 상하좌우 대각선으로 이동 가능.
    // N * N 보드에서 N개의 퀸을 서로 공격하지 못하게 놓는 수를 구하기.

    // (0,0) 부터 차례대로 탐색 시작.
    // 보드크기와 동일한 boolean 2차원배열 생성
    // 좌표의 상, 하, 좌, 우, 대각선 위치를 boolean 배열에서 모두 체크함 (true로 변환)
    // 다음 사용가능한 좌표를 boolean 변수를 통해 탐색 후 동일한 작업 수행.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCaseCount; i++) {
            int answer = 0;
            int count = 0;
            boolean[][] booleans = new boolean[i][i];

            for (int j = 0; j < i; j++) {
                for (int k = 0; k < i; k++) {
                    
                }
            }


            sb.append(String.format("#%d %d", i, answer));
        }
    }
}
