package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SWEA1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = 10;

        for (int i = 1; i <= testCaseCount; i++) {
            int swapCount = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int j = 0; j < 100; j++) {
                arrayList.add(Integer.parseInt(input[j]));
            }
            for (int j = 0; j < swapCount; j++) {
                Collections.sort(arrayList);
                arrayList.set(0, arrayList.get(0) + 1);
                arrayList.set(arrayList.size() - 1, arrayList.get(arrayList.size() - 1) - 1);
            }
            Collections.sort(arrayList);
            int answer = arrayList.get(arrayList.size() - 1) - arrayList.get(0);

            sb.append(String.format("#%d %d\n", i, answer));
        }
        System.out.println(sb);
    }
}
