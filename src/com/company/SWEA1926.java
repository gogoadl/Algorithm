package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());

        for (int i = 1; i <= number; i++) {
          String[] str = String.valueOf(i).split("");
          int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
          int clapCount = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != 0 && arr[j] % 3 == 0) {
                    clapCount++;
                }
            }
            if (clapCount != 0) {
                for (int j = 0; j < clapCount; j++) {
                    sb.append("-");
                }
            } else {
                sb.append(i);
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
