package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BaekJoon14501 {
    static int sum = 0;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void dfs(int[][] arr, boolean[] visited, int currentIndex, int N) {
        if (currentIndex > N) {
            // sum 기록
            arrayList.add(sum);

            return;
        }
        for (int i = currentIndex; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sum += arr[i][1];
                dfs(arr, visited, i + arr[i][0], N);
                sum -= arr[i][1];
                visited[i] = false;
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N+1][2];
        boolean[] visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            String[] inputs = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(inputs[0]);
            arr[i][1] = Integer.parseInt(inputs[1]);
            if (arr[i][0] + i-1 > N)
                arr[i][1] = 0;
        }

        for (int i = 1; i <= N; i++) {
            dfs(arr, visited, i, N);
        }
        Collections.sort(arrayList);

        System.out.println(arrayList.get(arrayList.size() - 1));
    }
}
