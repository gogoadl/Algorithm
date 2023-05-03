package com.company;

import java.io.IOException;
import java.util.Scanner;

public class SWEA1859 {
    // 1. i번 인덱스보다 큰 값이 다음 인덱스에 존재하는지 확인 후 없다면 해당 인덱스 스킵
    // 2. i번 인덱스보다 큰 값이 있다면 값 체크하면서 가장 큰 값 - 현재 인덱스 값을 결과에 저장
    // 3. for 문이 끝나면 형식에 따라 결과를 출력
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= testCaseCount; i++) {
            long output = 0;
            int caseDays = sc.nextInt();


            int[] caseValue = new int[caseDays];
            for (int j = 0; j < caseDays; j++) {
                caseValue[j] = sc.nextInt();
            }
            int maxValue = caseValue[caseDays-1];
            for (int j = caseDays - 1; j > 0; j--) {
                if (maxValue > caseValue[j-1])
                    output += maxValue - caseValue[j-1];
                else
                    maxValue = caseValue[j-1];
            }
            sb.append(String.format("#%d %d\n", i, output));
            output = 0;
        }
        System.out.println(sb.toString());
    }
}
