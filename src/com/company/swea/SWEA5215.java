package com.company.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class SWEA5215 {
    static int count;
    static int calorie;
    static int totalCalorie;
    static int answer;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void dfs(int[][] inputs, boolean[] visited, int index) {
        visited[index] = true;
        if (totalCalorie <= calorie) {
            arrayList.add(answer);
            return;
        }
        for (int i = 0; i < count; i++) {
            if (!visited[i]) {
                calorie += inputs[i][1];
                answer += inputs[i][0];
                if (totalCalorie >= calorie) {
                    dfs(inputs, visited, i);
                    visited[i] = false;
                }
                calorie -= inputs[i][1];
                answer -= inputs[i][0];

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCaseCount; i++) {
            String[] input = br.readLine().split(" ");
            count = Integer.parseInt(input[0]);
            totalCalorie = Integer.parseInt(input[1]);
            answer = 0;
            calorie = 0;
            int[][] inputs = new int[count][2];
            boolean[] visited = new boolean[count];
            for (int j = 0; j < count; j++) {
                String[] value = br.readLine().split(" ");
                inputs[j][0] = Integer.parseInt(value[0]);
                inputs[j][1] = Integer.parseInt(value[1]);
            }
            for (int j = 0; j < count; j++) {
                if (!visited[j]) {
                    calorie += inputs[j][1];
                    answer += inputs[j][0];
                    dfs(inputs, visited, j);
                    calorie -= inputs[j][1];
                    answer -= inputs[j][0];
                    visited[j] = false;
                }
            }
            Collections.sort(arrayList);
            sb.append(String.format("#%d %d\n", i, arrayList.get(arrayList.size()-1)));
        }
        System.out.println(sb);
    }
}
