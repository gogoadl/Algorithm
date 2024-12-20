package com.company.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon17471 {
    // 1. combi 실행하여 조합 구하기
    // 2. 생성해낸 조합 중 같은 플래그 끼리 모두 인접한지 확인
    // 3. 같은 플래그 끼리 모두 인접해있다면 차이와 최소값을 비교

    static int[][] graph;
    static int[] value;
    static boolean[] visited;
    static int N;
    static int total;
    static int min = Integer.MAX_VALUE;
    static int max = 0;
    public static void combi(int start, int depth, int sum) {//조합 선택 시작점, 선택한 개수, 선택한 수들의 합
        if(1 <= depth && depth <= N/2) {
            if (find(true) && find(false)) {
                min = Math.min(min, diff());
//                System.out.println(Arrays.toString(visited));
            }

            if(depth==N/2) {//최대 N/2까지 뽑고 stop
                return;
            }
        }

        for(int i=start; i<N; i++) {
            visited[i] = true;
            combi(i+1, depth+1, sum+value[i]);
            visited[i] = false;
        }
    }
    public static boolean find(boolean selected) { // 연결여부 확인, 연결된 노드가 모두 인접해있다면 true 반환하기
       boolean[] isSelected = new boolean[N];
       Queue<Integer> list = new LinkedList<Integer>();

       // 시작점 찾기
        for (int i = 0; i < N; i++) {
            if (visited[i] == selected) {
                list.add(i);
                isSelected[i] = true;
                break;
            }
        }
        while (!list.isEmpty()) {
            int val = list.poll();

            for (int i = 0; i < N; i++) {
                if (isSelected[i] || selected != visited[i])
                    continue;

                if (graph[val][i] == 1) {
                    list.add(i);
                    isSelected[i] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == selected && !isSelected[i])
                return false;
        }

        return true;
    }
    static int diff() {
        int a = 0;
        int b = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i])
                a += value[i];
            else
                b += value[i];
        }
        return Math.abs(a - b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        value = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
            total += value[i];
            max = Math.max(value[i], max);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cnt; j++) {
                int val =Integer.parseInt(st.nextToken()) - 1;
                graph[i][val] = 1;
                graph[val][i] = 1;
            }
        }


        combi(0, 0, 0);

        if (min == Integer.MAX_VALUE)
            min = -1;

        System.out.println(min);
    }
}