package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon13023 {
    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> lists;
    static boolean[] visited;
    public static void dfs(int depth, int index) {
        if (depth == 5) {
            System.out.println(1);
            System.exit(0);
        }

        for (int j = 0; j < lists.get(index).size(); j++) {
            if (!visited[lists.get(index).get(j)]) {
                visited[lists.get(index).get(j)] = true;
                dfs(depth +1, lists.get(index).get(j));
                visited[lists.get(index).get(j)] = false;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lists = new ArrayList();
       visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            lists.add(new ArrayList());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists.get(a).add(b);
            lists.get(b).add(a);
        }
        for (int i = 0; i < lists.size(); i++) {
            visited[i] = true;
            dfs(1,i);
            visited[i] = false;
        }
        System.out.println(0);

    }
}
