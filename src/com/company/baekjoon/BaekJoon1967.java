package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon1967 {
    static List<Node>[] list;
    static boolean[] visited;
    static int max = 0;
    static int max_idx = 0; // root로 부터 가장 큰 가중치를 가지는 노드
    public static void dfs(int index, int sum) {
        if(max < sum) {
            max = sum;
            max_idx = index;
        }
        for(Node a : list[index]) {
            if(!visited[a.index]) {
                visited[a.index] = true;
                dfs(a.index, sum+a.weight);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<Node>();
        }
        visited = new boolean[N+1];
        visited[1] = true;

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[parent].add(new Node(child, weight));
            list[child].add(new Node(parent, weight));
        }
        dfs(1,0); // root 노드부터 가중치가 가장 큰 노드 탐색

        visited = new boolean[N+1];
        visited[max_idx] = true;
        dfs(max_idx,0); // 가중치가 가장 큰 노드부터 시작하여 가중치가 가장 큰 경우 탐색
        System.out.println(max);

    }
    public static class Node {
        int index;
        int weight;
        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}