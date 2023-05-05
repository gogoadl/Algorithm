package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SWEA16800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCaseCount; i++) {
            long input = Long.parseLong(br.readLine());
            long answer = 0;

            ArrayList<Long> arrayList = new ArrayList();
            ArrayList<Long> arrayList1 = new ArrayList();
            for (long j = 1; j <= Math.sqrt(input); j++) {
                if (input % j == 0) {
                    arrayList.add(j);
                }
            }
            if (arrayList.size() > 1) {
                for (int j = 1; j < arrayList.size(); j++) {
                    long value = (input / arrayList.get(j));
                    arrayList1.add(arrayList.get(j) + value - 2);
                }

                Collections.sort(arrayList1);
                answer = arrayList1.get(0);
            } else {
                answer = input - 1;
            }
            sb.append(String.format("#%d %s\n", i, answer));
        }
        System.out.println(sb);
    }
}
