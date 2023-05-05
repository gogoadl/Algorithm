package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCaseCount = 9;

        for (int i = 1; i <= testCaseCount; i++) {
            int buildingCount = Integer.parseInt(br.readLine());
            int answer = 0;
            String[] buildings = br.readLine().split(" ");
            int[] buildingArray = Arrays.stream(buildings).mapToInt(Integer::parseInt).toArray();
            int[] arrays = new int[4];
            for (int j = 2; j < buildingCount - 2; j++) {
                arrays[0] = buildingArray[j] - buildingArray[j-2];
                arrays[1] = buildingArray[j] - buildingArray[j-1];
                arrays[2] = buildingArray[j] - buildingArray[j+1];
                arrays[3] = buildingArray[j] - buildingArray[j+2];

                if (arrays[0] >= 0 && arrays[1] >= 0 && arrays[2] >= 0 && arrays[3] >= 0) {
                    answer += Arrays.stream(arrays).min().getAsInt();
                }
            }
            sb.append(String.format("#%d %d\n", i, answer));
        }
        System.out.println(sb);
    }
}
