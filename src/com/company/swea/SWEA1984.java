package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SWEA1984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCaseCount; i++) {
            int answer = 0;
            float sum = 0;
            ArrayList<Integer> arrayList = new ArrayList<>();
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < input.length; j++) {
                arrayList.add(Integer.parseInt(input[j]));
            }

            Collections.sort(arrayList);

            for (int j = 1; j < input.length - 1; j++) {
                sum += arrayList.get(j);
            }
            answer = Math.round(sum / (input.length - 2));
            sb.append(String.format("#%d %d\n", i, answer));
        }
        System.out.println(sb);
    }
}
