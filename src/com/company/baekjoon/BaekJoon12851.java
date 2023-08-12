package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon12851 {
    static int N;
    static int K;
    static int min = 0;
    static int visited[] = new int[100001];
    static int answer = 0;
    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {N, 0});
        while (!queue.isEmpty()) {
            int[] i = queue.poll();

            if (i[0] == K) {
                if (answer == 0)
                    min = i[1];
                if (min == i[1])
                    answer++;
            }

            int[] arr = {i[0]-1, i[0]+1, i[0]*2};

            for (int j = 0; j < 3; j++) {
                int next = arr[j];
                if (next < 0 || next > 100000) continue;
                if (visited[next] == 0 || visited[next] == i[1]+1) {
                    visited[next] = i[1] + 1;
                    queue.add(new int[]{next, i[1] + 1});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(min);
        System.out.println(answer);
    }
}
