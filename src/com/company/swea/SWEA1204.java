package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SWEA1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCaseCount; i++) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            int testCaseIndex = Integer.parseInt(br.readLine());
            String[] numbers = br.readLine().split(" ");

            for (int j = 0; j < numbers.length; j++) {
                hashMap.put(numbers[j], hashMap.getOrDefault(numbers[j], 0) + 1);
            }

            List<Map.Entry<String, Integer>> array = hashMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
            String answer = array.get(array.size()-1).getKey();
            sb.append(String.format("#%d %s\n", testCaseIndex, answer));
        }
        System.out.println(sb);
    }
}
