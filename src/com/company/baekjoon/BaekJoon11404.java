package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon11404 {
    static int N;
    static int[][] graph;
    static int INF = 9900001;
    public static void floyd() {
        for (int k = 1; k <= N; k++) { // 라운드
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];

        for(int i=1; i<=N; i++) { // 모든 노드를 INF로 먼저 초기화
            for(int j=1; j<=N; j++) {
                graph[i][j] = INF;
                if(i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < count; i++) { // 노드간 이동 가능한 경우에 거리 초기화
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            // 이미 값이 있는 경우 최솟값으로 설정
            graph[x][y] = Math.min(graph[x][y], value);

        }
        floyd();
        for (int i = 1;  i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] == INF)
                    sb.append("0 ");
                else
                    sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
