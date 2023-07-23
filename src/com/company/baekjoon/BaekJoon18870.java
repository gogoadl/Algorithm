package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sorted = inputs.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int index = 0;
        for (int i = 0; i < N; i++) {
            if (!hashMap.containsKey(sorted[i])) {
                    hashMap.put(sorted[i], index);
                    index++;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(hashMap.get(inputs[i]) + " ");
        }

        System.out.println(sb);
    }
}
