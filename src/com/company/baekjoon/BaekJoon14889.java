package org.example.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon14889 {
    public static int sum = Integer.MAX_VALUE;
    public static void dfs(int[][] graph, int[] arr, int[] result, boolean[] visited, int index, int N, int depth) {
        depth += 1;
        if (depth == N / 2) {
            int[] startTeam = new int[N/2];
            int[] linkTeam = new int[N/2];
            int startIndex = 0;
            int linkIndex = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    startTeam[startIndex] = arr[i];
                    startIndex++;
                } else {
                    linkTeam[linkIndex] = arr[i];
                    linkIndex++;
                }
            }
            int start = 0;
            int link = 0;
            for (int i = 0; i < N/2; i++) {
                for (int j = i + 1; j < N/2; j++) {
                    int graphXIndex = startTeam[i] - 1;
                    int graphYIndex = startTeam[j] - 1;
                    start += graph[graphXIndex][graphYIndex] + graph[graphYIndex][graphXIndex];

                    graphXIndex = linkTeam[i] - 1;
                    graphYIndex = linkTeam[j] - 1;
                    link += graph[graphXIndex][graphYIndex] + graph[graphYIndex][graphXIndex];
                }
            }
            int a = Math.abs(start - link);
            if (a < sum)
                sum = a;
            return;
        }

        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                dfs(graph, arr, result, visited, i, N, depth);
                visited[i] = false;
                result[depth] = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        boolean[] visited = new boolean[N];
        int teamSize = N/2;
        int[] team = new int[teamSize];
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[i] = i + 1;
        }
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            team[0] = arr[i];
            dfs(graph, arr, team, visited, i, N, 0);
            visited[i] = false;
        }


        System.out.println(sum);
    }
}
